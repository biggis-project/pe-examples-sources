/*
 * Copyright 2017 FZI Forschungszentrum Informatik
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.streampipes.examples.sources.config;

import org.streampipes.config.SpConfig;
import org.streampipes.container.model.PeConfig;

public enum ExampleSourcesConfig implements PeConfig {
  INSTANCE;


  /*
     TUTORIAL:
     The service ID MUST be unique. As a convention use the package name with the prefix "pe/" for processing element.
   */
  private final static String SERVICE_ID = "pe/org.streampipes.pe.sources.examples";


  private SpConfig config;

  /*
    TUTORIAL:
    Do NOT change those static strings
  */
  private final static String HOST = "host";
  private final static String PORT = "port";
  private final static String KAFKA_HOST = "kafka_host";
  private final static String KAFKA_PORT = "kafka_port";
  private final static String ZOOKEEPER_HOST = "zookeeper_host";
  private final static String ZOOKEEPER_PORT = "zookeeper_port";
  private final static String SERVICE_NAME = "service_name";
  private final static String ICON_HOST = "icon_host";
  private final static String ICON_PORT = "icon_port";

  public final static String serverUrl;
  public final static String iconBaseUrl;


  ExampleSourcesConfig() {
    config = SpConfig.getSpConfig(SERVICE_ID);

    /*
    FOR CONFIGURING SERVICES VIA ENVIRONMENT VARIABLES
    */
    String peHost = System.getenv("PE_HOST");
    String kafkaHost = System.getenv("KAFKA_HOST");
    String zkHost = System.getenv("ZOOKEEPER_HOST");
    String iconHost = System.getenv("ICON_HOST");

    if (peHost != null && !peHost.isEmpty())
      config.register(HOST, peHost, "Hostname for the examples-sources project");
    else
      config.register(HOST, "pe-examples-sources", "Hostname for the examples-sources project");

    if (kafkaHost != null && !kafkaHost.isEmpty())
      config.register(KAFKA_HOST, kafkaHost, "Host for kafka of the pe demonstrator project");
    else
      config.register(KAFKA_HOST, "kafka", "Host for kafka of the pe demonstrator project");

    if (zkHost != null && !zkHost.isEmpty())
      config.register(ZOOKEEPER_HOST, zkHost, "Host for zookeeper of the pe demonstrator project");
    else
      config.register(ZOOKEEPER_HOST, "zookeeper", "Host for zookeeper of the pe demonstrator project");

    if (iconHost != null && !iconHost.isEmpty())
      config.register(ICON_HOST, iconHost, "Hostname for the icon host");
    else
      config.register(ICON_HOST, "backend", "Hostname for the icon host");

    /*
      TUTORIAL:
      The second parameter is the default value for the configuration property.
      This value is set in Consul when the parameter does not exist.
      Important. Changes here are not effective if the configuration parameter is already set in consul. In
      such cases the value has to be changed in consul directly.
    */
    config.register(PORT, 8090, "Port of the sources project");
    config.register(KAFKA_PORT, 9092, "Port for kafka of the pe demonstrator project");
    config.register(ZOOKEEPER_PORT, 2181, "Port for zookeeper of the pe demonstrator project");
    config.register(ICON_PORT, 80, "Port for the icons in nginx");
    config.register(SERVICE_NAME, "Example Sources", "StreamPipes example sources");
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
