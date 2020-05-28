package com.purbon.kafka.streams;

import static java.lang.System.exit;

import com.purbon.kafka.api.RestEndpointApi;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.Topology;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class AppCLI {

  public static final String CONFIG_OPTION = "clientConfig";
  public static final String CONFIG_DESC = "The application configuration file.";

  public static final String HELP_OPTION = "help";
  public static final String HELP_DESC = "Prints usage information.";

  public static final String APP_NAME = "filtering-app";


  private static Options options() {

    final Option configFileOption =
        Option.builder()
            .longOpt(CONFIG_OPTION)
            .hasArg()
            .desc(CONFIG_DESC)
            .required()
            .build();

    final Option helpOption =
        Option.builder()
            .longOpt(HELP_OPTION)
            .hasArg(false)
            .desc(HELP_DESC)
            .required(false)
            .build();


    final Options options = new Options();
    options.addOption(configFileOption);
    options.addOption(helpOption);
    return options;
  }

  private static Boolean useCLI = false;


  public static void main(String[] args) throws Exception {

    if (useCLI) {
      mainWithCLI(args);
    } else {
      String topology = "CountLabResults";

      Topology myTopology = CountLabResults.buildTopology();
      KafkaStreams streams = new KafkaStreams(myTopology, CountLabResults.config());

      streams.setUncaughtExceptionHandler((Thread thread, Throwable throwable) -> {

      });

      Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

      startJettyServer(streams);
      streams.start();
    }
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

  private static void mainWithCLI(String[] args) {
    CommandLineParser parser = new DefaultParser();
    HelpFormatter formatter = new HelpFormatter();

    CommandLine cmd = parseArgsOrExit(parser, options(), args, formatter);

    if (cmd.hasOption(HELP_OPTION)) {
      formatter.printHelp(APP_NAME, options());
    } else {
      String clientConfigFile = cmd.getOptionValue(CONFIG_OPTION);

    }
  }

  private static Properties buildConfig(String file) throws IOException {
    Properties props = new Properties();
    props.load(new FileInputStream(file));
    return props;
  }

  private static CommandLine parseArgsOrExit(
      CommandLineParser parser, Options options, String[] args, HelpFormatter formatter) {
    CommandLine cmd = null;
    try {
      cmd = parser.parse(options, args);
    } catch (ParseException e) {
      System.out.println("Parsing failed cause of " + e.getMessage());
      formatter.printHelp("cli", options);
      exit(1);
    }
    return cmd;
  }
}
