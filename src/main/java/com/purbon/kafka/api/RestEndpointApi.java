package com.purbon.kafka.api;

import static com.purbon.kafka.streams.CountLabResults.RESULTS_STORE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.purbon.kafka.model.AreaCount;
import java.io.Writer;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.state.KeyValueIterator;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import java.util.Map;

@WebServlet(name = "RestEndpointServlet", urlPatterns = {"/"}, loadOnStartup = 1)
public class RestEndpointApi extends HttpServlet {

  private final KafkaStreams streams;

  private ObjectMapper mapper;

  public RestEndpointApi(KafkaStreams streams) {
    this.streams = streams;
    this.mapper = new ObjectMapper();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setStatus(HttpServletResponse.SC_OK);
    response.setContentType("application/json");
    response.setCharacterEncoding("utf-8");

    Writer writer = response.getWriter();

    Map<String, AreaCount> stateStoreContent = fetchStateStoreContent();
    String jsonValue = mapper.writeValueAsString(stateStoreContent);

    writer.write(jsonValue);
  }

  private Map<String, AreaCount> fetchStateStoreContent() {
      return null;
  }
}