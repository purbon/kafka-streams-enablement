package com.purbon.kafka.streams;

import static com.purbon.kafka.SerdesUtils.serdesForAreaCount;
import static com.purbon.kafka.SerdesUtils.serdesForLabResult;

import com.purbon.kafka.api.RestEndpointApi;
import com.purbon.kafka.model.AreaCount;
import com.purbon.kafka.model.LabResult;
import java.util.Properties;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Aggregator;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.ForeachAction;
import org.apache.kafka.streams.kstream.KGroupedStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Named;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.KeyValueStore;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class CountLabResults {

  public static final String ORIGIN_TOPIC = "lab-results";
  public static final String TARGET_TOPIC = "total-counts";
  public static final String RESULTS_STORE = "results-store";


  public static Properties config() {
    final Properties config = new Properties();
    config.put(StreamsConfig.APPLICATION_ID_CONFIG, "counting-lab-results-v99");
    config.put(StreamsConfig.CLIENT_ID_CONFIG, "counting-v1");

    config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Long().getClass().getName());
    config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

    config.put(StreamsConfig.COMMIT_INTERVAL_MS_CONFIG, 100);
    config.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG, 10);
    config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

    String rpcEndpoint = "localhost:8080";
    config.put(StreamsConfig.APPLICATION_SERVER_CONFIG, rpcEndpoint);

    return config;
  }

  public static Topology buildTopology() {
    return null;
  }


  public static void main(String[] args) throws Exception {


      Topology myTopology = buildTopology();
      KafkaStreams streams = new KafkaStreams(myTopology, config());

      streams.setUncaughtExceptionHandler((Thread thread, Throwable throwable) -> {

      });

      Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

      startJettyServer(streams);
      streams.start();
  }

  public static void startJettyServer(KafkaStreams streams) throws Exception {

    int port = 8080;
    Server server = new Server(port);
    ServletHandler handler = new ServletHandler();
    server.setHandler(handler);

    RestEndpointApi endpointApi = new RestEndpointApi(streams);
    ServletHolder endpointHolder = new ServletHolder(endpointApi);
    handler.addServletWithMapping(endpointHolder, "/*");

    server.start();
  }

}
