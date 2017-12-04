package org.streampipes.examples.sources.config;

public enum ExampleSourcesVariables {

    SIENENS_FLOWRATESENSOR1("flowrate1", "Siemens Flow Rate Sensor 1 ", "","org.streampipes.examples.siemens.flowrate" +
						".sensor1", "icon-flowrate-1"),
    SIENENS_FLOWRATESENSOR2("flowrate2", "Siemens Flow Rate Sensor 2", "","org.streampipes.examples.siemens.flowrate.sensor2", "icon-flowrate-2"),
    SIEMENS_LEVELSENSOR("level", "Siemens Level Sensor", "","org.streampipes.examples.siemens.level.sensor1", "icon-water-level"),

    FESTO_CONTAINERB101("container101", "Container101", "","org.streampipes.examples.festo.container.b101", "icon-water-level"),
    FESTO_CONTAINERB102("container102", "Container102", "","org.streampipes.examples.festo.container.b102", "icon-water-level"),
    FESTO_FLOWRATE("flowrate", "Festo Flow Rate Sensor", "","org.streampipes.examples.festo.flowrate", "Flowrate-Festo"),
    FESTO_PRESSURE_TANK("pressure", "Pressure Tank Sensor", "","org.streampipes.examples.festo.pressuretank", "pressure");

	String tagNumber;
	String eventName;
	String description;
	String topic;
	String icon;
	
	ExampleSourcesVariables(String tagNumber, String eventName, String description, String topic, String icon)
	{
		this.tagNumber = tagNumber;
		this.eventName = eventName;
		this.description = description;
		this.topic = topic;
		this.icon = icon;
	}
	
	public String tagNumber()
	{
		return tagNumber;
	}
	
	public String eventName()
	{
		return eventName;
	}
	
	public String description()
	{
		return description;
	}
	
	public String topic()
	{
		return topic;
	}
	
	public String icon() {
		return icon;
	}
}
