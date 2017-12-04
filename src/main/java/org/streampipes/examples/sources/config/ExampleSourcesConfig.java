package org.streampipes.examples.sources.config;

import org.streampipes.config.SpConfig;
import org.streampipes.container.model.PeConfig;

public enum ExampleSourcesConfig implements PeConfig {
  INSTANCE;

  private SpConfig config;
  private final static String HOST = "host";
  private final static String PORT = "port";
  private final static String KAFKA_HOST = "kafka_host";
  private final static String KAFKA_PORT = "kafka_port";
  private final static String ZOOKEEPER_HOST = "zookeeper_host";
  private final static String ZOOKEEPER_PORT = "zookeeper_port";

  private final static String ICON_HOST = "icon_host";
  private final static String ICON_PORT = "icon_port";

  public final static String serverUrl;
  public final static String iconBaseUrl;

  private final static String SERVICE_ID = "pe/org.streampipes.pe.sources.examples";
  private final static String SERVICE_NAME = "streampipes-examples-sources";

  ExampleSourcesConfig() {
    config = SpConfig.getSpConfig(SERVICE_ID);
    config.register(HOST, "examples-sources", "Hostname for the examples-sources project");
    config.register(PORT, 8090, "Port of the sources project");
    config.register(KAFKA_HOST, "kafka", "Host for kafka of the pe demonstrator project");
    config.register(KAFKA_PORT, 9092, "Port for kafka of the pe demonstrator project");
    config.register(ZOOKEEPER_HOST, "zookeeper", "Host for zookeeper of the pe demonstrator project");
    config.register(ZOOKEEPER_PORT, 2181, "Port for zookeeper of the pe demonstrator project");

    config.register(ICON_HOST, "backend", "Hostname for the icon host");
    config.register(ICON_PORT, 80, "Port for the icons in nginx");

    config.register(SERVICE_NAME, "Source demonstrator", "The name of the service");
  }

  static {
    serverUrl = ExampleSourcesConfig.INSTANCE.getHost() + ":" + ExampleSourcesConfig.INSTANCE.getPort();

    iconBaseUrl = ExampleSourcesConfig.INSTANCE.getIconHost() + ":" + ExampleSourcesConfig.INSTANCE.getIconPort() + "/img/pe_icons";
  }

  @Override
  public String getHost() {
    return config.getString(HOST);
  }

  @Override
  public int getPort() {
    return config.getInteger(PORT);
  }

  public String getKafkaHost() {
    return config.getString(KAFKA_HOST);
  }

  public int getKafkaPort() {
    return config.getInteger(KAFKA_PORT);
  }

  public String getKafkaUrl() {
    return getKafkaHost() + ":" + getKafkaPort();
  }

  public String getZookeeperHost() {
    return config.getString(ZOOKEEPER_HOST);
  }

  public int getZookeeperPort() {
    return config.getInteger(ZOOKEEPER_PORT);
  }

  public String getIconHost() {
    return config.getString(ICON_HOST);
  }

  public int getIconPort() {
    return config.getInteger(ICON_PORT);
  }

  @Override
  public String getId() {
    return SERVICE_ID;
  }

  @Override
  public String getName() {
    return config.getString(SERVICE_NAME);
  }

}
