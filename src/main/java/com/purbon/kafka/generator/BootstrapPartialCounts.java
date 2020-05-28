package com.purbon.kafka.generator;

import com.purbon.kafka.SerdesUtils;
import com.purbon.kafka.model.PartialCount;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class BootstrapPartialCounts {

  public static Properties config() {
    Properties props = new Properties();
    props.put("bootstrap.servers", "localhost:9092");
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("buffer.memory", 33554432);
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", SerdesUtils.serdesForPartialCount().serializer().getClass());
    return props;
  }

  private static String TOPIC = "partial-counts";

  public static void main(String [] args) throws ExecutionException, InterruptedException {

    KafkaProducer<String, PartialCount> producer = new KafkaProducer<>(config());
    Random rand = new Random(System.currentTimeMillis());
    int count = areas.length;
    int i = 0;
    Future<RecordMetadata> future = null;
    while(i < count) {
      PartialCount partialCount = new PartialCount();
      partialCount.setArea(findArea(i));
      partialCount.setCount(getCount(rand));

      ProducerRecord<String, PartialCount> record = new ProducerRecord<>(TOPIC, partialCount.getArea(), partialCount);
      future = producer.send(record);
      i++;
    }
    future.get();
  }

  private static String[] areas = new String[]{"Berlin", "NRW", "Bayern", "Bremen", "Hamburg"};

  private static String findArea(int i) {
    return areas[i];
  }

  private static String findArea(Random rand) {
    return areas[rand.nextInt(areas.length)];
  }

  private static Long getCount(Random rand) {
    return Math.abs(rand.nextLong()%1000);
  }


}
