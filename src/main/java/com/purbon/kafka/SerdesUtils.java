package com.purbon.kafka;

import com.purbon.kafka.model.AreaCount;
import com.purbon.kafka.model.LabResult;
import com.purbon.kafka.model.PartialCount;
import com.purbon.kafka.streams.serdes.JsonPOJODeserializer;
import com.purbon.kafka.streams.serdes.JsonPOJOSerializer;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;

public class SerdesUtils {


  public static Serde<LabResult> serdesForLabResult() {
    Map<String, Object> serdeProps = new HashMap<>();

    final Serializer<LabResult> serializer = new JsonPOJOSerializer<>();
    serdeProps.put("JsonPOJOClass", LabResult.class);
    serializer.configure(serdeProps, false);

    final Deserializer<LabResult> deserialier = new JsonPOJODeserializer<>();
    serdeProps.put("JsonPOJOClass", LabResult.class);
    deserialier.configure(serdeProps, false);

    return Serdes.serdeFrom(serializer, deserialier);
  }

  public static Serde<PartialCount> serdesForPartialCount() {
    Map<String, Object> serdeProps = new HashMap<>();

    final Serializer<PartialCount> serializer = new JsonPOJOSerializer<>();
    serdeProps.put("JsonPOJOClass", PartialCount.class);
    serializer.configure(serdeProps, false);

    final Deserializer<PartialCount> deserialier = new JsonPOJODeserializer<>();
    serdeProps.put("JsonPOJOClass", PartialCount.class);
    deserialier.configure(serdeProps, false);

    return Serdes.serdeFrom(serializer, deserialier);
  }

  public static Serde<AreaCount> serdesForAreaCount() {
    Map<String, Object> serdeProps = new HashMap<>();

    final Serializer<AreaCount> serializer = new JsonPOJOSerializer<>();
    serdeProps.put("JsonPOJOClass", AreaCount.class);
    serializer.configure(serdeProps, false);

    final Deserializer<AreaCount> deserialier = new JsonPOJODeserializer<>();
    serdeProps.put("JsonPOJOClass", AreaCount.class);
    deserialier.configure(serdeProps, false);

    return Serdes.serdeFrom(serializer, deserialier);
  }

}
