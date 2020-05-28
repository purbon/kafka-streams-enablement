package com.purbon.kafka.streams;

import static com.purbon.kafka.SerdesUtils.serdesForAreaCount;
import static com.purbon.kafka.SerdesUtils.serdesForLabResult;
import static com.purbon.kafka.SerdesUtils.serdesForPartialCount;

import com.purbon.kafka.model.AreaCount;
import com.purbon.kafka.model.LabResult;
import com.purbon.kafka.model.PartialCount;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.ForeachAction;
import org.apache.kafka.streams.kstream.GlobalKTable;
import org.apache.kafka.streams.kstream.KeyValueMapper;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Named;
import org.apache.kafka.streams.kstream.Printed;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.ValueJoiner;
import org.apache.kafka.streams.state.KeyValueStore;

public class GlobalKTablesAndStateStores {

  public static final String ORIGIN_TOPIC = "lab-results";
  public static final String TARGET_TOPIC = "total-counts";


  public static Properties config() {
    final Properties config = new Properties();
    config.put(StreamsConfig.APPLICATION_ID_CONFIG, "counting-with-a-globalktable-v13");
    config.put(StreamsConfig.CLIENT_ID_CONFIG, "counting-v1");

    config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Long().getClass().getName());
    config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

    config.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 100);
    config.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG, 4);
    config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

    return config;
  }

  public static Topology buildTopology() {
    return null;
  }


  public static void main(String[] args) {


      Topology myTopology = buildTopology();
      KafkaStreams streams = new KafkaStreams(myTopology, config());

      streams.setUncaughtExceptionHandler((Thread thread, Throwable throwable) -> {

      });

      Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
      streams.start();

  }

}
