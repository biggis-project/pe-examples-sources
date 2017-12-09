package org.streampipes.examples.sources.config;

public enum ExampleSourcesVariables {
  FLOWRATE_1("flowrate_1", "Flow Rate Sensor 1", "", "org.streampipes.examples.flowrate_1", "Flowrate-Festo"),
  FLOWRATE_2("flowrate_2", "Flow Rate Sensor 2", "", "org.streampipes.examples.flowrate_2", "icon-flowrate-1"),
  WATER_LEVEL_1("water_level_1", "Water Level 1", "", "org.streampipes.examples.waterlevel", "icon-water-level"),
  WATER_LEVEL_2("warter_level_2", "Water Level 2", "", "org.streampipes.examples.waterlevel_2", "icon-water-level"),
  PRESSURE_TANK("pressure", "Pressure Tank Sensor", "", "org.streampipes.examples.pressuretank", "pressure");

  String tagNumber;
  String eventName;
  String description;
  String topic;
  String icon;

  ExampleSourcesVariables(String tagNumber, String eventName, String description, String topic, String icon) {
    this.tagNumber = tagNumber;
    this.eventName = eventName;
    this.description = description;
    this.topic = topic;
    this.icon = icon;
  }

  public String tagNumber() {
    return tagNumber;
  }

  public String eventName() {
    return eventName;
  }

  public String description() {
    return description;
  }

  public String topic() {
    return topic;
  }

  public String icon() {
    return  ExampleSourcesConfig.iconBaseUrl + "/" +  icon;
  }
}
