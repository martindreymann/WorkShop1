package business;

import java.io.Serializable;

public class Sensor implements Serializable {

    private String sensorName;
    private SensorType sensorType;

    public Sensor(String name, SensorType st) {
        this.sensorName = name;
        this.sensorType = st;
    }

    public SensorType getType() {
        return sensorType;
    }

    public Measurement getCurrentMeasure() {
        return RandomMeasurement.getRandom(sensorType, sensorName);
    }

    public String getName() {
        return sensorName;
    }

}
