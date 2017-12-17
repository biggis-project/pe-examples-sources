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

package org.streampipes.examples.sources.vocabulary;

public class WaterTankVocabulary {

  public static final String NS = "https://streampipes.org/vocabulary/examples/watertank/v1/";
  public static final String NS_PREFIX = "wt";

  public static final String HAS_SENSOR_ID = NS + "hasSensorId";
  public static final String IS_OVERFLOW = NS + "isOverflow";
  public static final String IS_UNDERFLOW = NS + "isUnderflow";
  public static final String HAS_WATER_LEVEL = NS + "hasWaterLevel";
  public static final String HAS_MASS_FLOW = NS + "hasMassFlow";
  public static final String HAS_TEMPERATURE = NS + "hasTemperature";
  public static final String HAS_PRESSURE = NS + "hasPressure";

  public static final String HAS_VOLUME_FLOW= NS + "hasVolumeFlow";
  public static final String HAS_SENSOR_FAULT_FLAGS = NS + "hasSensorFaultFlags";
  public static final String HAS_DENSITY = NS + "hasDensity";
}
