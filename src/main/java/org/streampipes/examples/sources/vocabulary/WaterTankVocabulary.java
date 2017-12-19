package org.streampipes.examples.sources.vocabulary;

import org.streampipes.vocabulary.SO;

public class WaterTankVocabulary {

  public static final String NS = "https://streampipes.org/vocabulary/examples/watertank/v1/";

  public static final String HAS_SENSOR_ID = NS + "hasSensorId";
  public static final String IS_OVERFLOW = NS + "isOverflow";
  public static final String IS_UNDERFLOW = NS + "isUnderflow";
  public static final String HAS_WATER_LEVEL = SO.Number;
  public static final String HAS_MASS_FLOW = SO.Number;
  public static final String HAS_TEMPERATURE = SO.Number;
  public static final String HAS_PRESSURE = SO.Number;

  public static final String HAS_VOLUME_FLOW= SO.Number;
  public static final String HAS_SENSOR_FAULT_FLAGS = SO.Number;
  public static final String HAS_DENSITY = SO.Number;
}
