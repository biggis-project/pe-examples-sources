# StreamPipes

StreamPipes enables flexible modeling of stream processing pipelines by providing a graphical modeling editor on top of existing stream processing frameworks.

It leverages non-technical users to quickly define and execute processing pipelines based on an easily extensible 
toolbox of data sources, data processors and data sinks.

Learn more about StreamPipes at [https://www.streampipes.org/](https://www.streampipes.org/)

Read the full documentation at [https://docs.streampipes.org](https://docs.streampipes.org)

### StreamPipes examples for data sources and data streams

This project includes examples for data streams that can be used to directly try the preview with real-time data (see 
below).

The sources simulate live data with a frequency of roughly 1 event per second per stream.

The following example data streams are available in this project:

**Vehicle Source**
* Vehicle Position: Simulates the position of a delivery vehicle driving in Manhattan. An event consists of a 
`timestamp`, a `plateNumber` and `latitude` and `longitude` values denoting the vehicle's position.

**Water Tank Source**

The water tank source demonstrates a simple scenario from the manufacturing domain. The production line consists of 
two water tanks that are connected by various pipes. Water is exchanged between both tanks at a specific flow rate. 
From time to time, a leak in a pipe is simulated: The water level in the tank drops, while the flow rate measured in 
the corresponding pipe decreases.

This scenario consists of the following sensors:

* Flow Rate 1: A sensor that measures the flow rate and some other parameters in a pipe: `timestamp`, 
`sensorId`, `volume_flow` and `mass_flow`
* Flow Rate 2: A second sensor measuring the flow, but at another location and with additional parameters 
`volume_flow`, `density` and `fluid_temperature`.
* Pressure Tank: Simulates a sensor in a pressure tank by providing the following measurement values: `timestamp`, 
`sensorId` and `pressure`.
* Water Level 1: A water level sensor that measures the current water level in tank 1: The sensor provides the 
`timestamp`, `sensorId`, current `level` and two boolean parameters `overflow` and `underflow`.
* Water Level 2: Similar to the water level sensor 1, but only provides a `level` parameter and the `underflow` 
property.

Import these sources into the StreamPipes UI if you would quickly like to try StreamPipes!

### Getting started

Currently, the StreamPipes core is available as a preview in form of ready-to-use Docker images.

It's easy to get started:
* Download the `docker-compose.yml` file from [https://www.github.com/streampipes/preview-docker](https://www.github.com/streampipes/preview-docker)
* Follow the installation guide at [https://docs.streampipes.org/quick_start/installation](https://docs.streampipes.org/quick_start/installation)
* Check the [tour](https://docs.streampipes.org/user_guide/features) and build your first pipeline!

### Extending StreamPipes

You can easily add your own data streams, processors or sinks. 

Check our developer guide at [https://docs.streampipes.org/developer_guide/introduction](https://docs.streampipes.org/developer_guide/introduction)

### Feedback

We'd love to hear your feedback! Contact us at [feedback@streampipes.org](mailto:feedback@streampipes.org)

