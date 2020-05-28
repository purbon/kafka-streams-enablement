package com.purbon.kafka.streams;

import static com.purbon.kafka.SerdesUtils.serdesForAreaCount;
import static com.purbon.kafka.SerdesUtils.serdesForLabResult;
import static com.purbon.kafka.streams.CountLabResults.ORIGIN_TOPIC;
import static com.purbon.kafka.streams.CountLabResults.TARGET_TOPIC;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import com.purbon.kafka.model.AreaCount;
import com.purbon.kafka.model.LabResult;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.TestInputTopic;
import org.apache.kafka.streams.TestOutputTopic;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.TopologyTestDriver;
import org.junit.Test;

public class CountLabResultsTest {

  @Test
  public void testEventsPositiveAndNegative() {


  }

  @Test
  public void testSumOfEvents() {


  }

  private TopologyTestDriver configureTopology(String applicationId) {
    return null;
  }
}
