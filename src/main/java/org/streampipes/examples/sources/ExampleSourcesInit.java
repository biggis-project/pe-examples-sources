package org.streampipes.examples.sources;

import org.streampipes.container.init.DeclarersSingleton;
import org.streampipes.container.standalone.init.StandaloneModelSubmitter;
import org.streampipes.examples.sources.config.ExampleSourcesConfig;

public class ExampleSourcesInit extends StandaloneModelSubmitter {

  public static void main(String[] args) {
    DeclarersSingleton.getInstance().add(new VehicleSource())
            .add(new WaterTankSource());

    new ExampleSourcesInit().init(ExampleSourcesConfig.INSTANCE);
  }
}
