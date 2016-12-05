package worksshop1;

import java.util.ArrayList;
import javafx.util.Pair;

public class Building {

    private String name, adress;

    private ArrayList<Sensors> sensorList;
    public ArrayList<Measurement> tempMeasure, aqMeasure;

    public Building(String name, String adress, Sensors... sensorses) {
        sensorList = new ArrayList<>();
        this.name = name;
        this.adress = adress;
        tempMeasure = new ArrayList<>();
        aqMeasure = new ArrayList<>();

        for (Sensors s : sensorses) {
            sensorList.add(s);
        }
    }

    public void readAllMeasurements() {
        for (Sensors s : sensorList) {

            if (s instanceof TemperatureSensor) {
                tempMeasure.add(s.getCurrentMeasure());
            } else if (s instanceof AirQualitySensor) {
                aqMeasure.add(s.getCurrentMeasure());
            } else {
                System.out.println("OMFG");
            }
        }
    }

    public void addSensor(Sensors s) {
        sensorList.add(s);
    }

    public void removeSensor(Sensors s) {
        sensorList.remove(s);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getAirQuality() {

        ArrayList<String> rList = new ArrayList<>();

        for (Measurement m : aqMeasure) {
            rList.add("Sensor:" + m.getCensorName() + " | Measure: " + m.getMeasure() + " CO2");
        }
        return rList;
    }

    public ArrayList<String> getTemperature() {

        ArrayList<String> rList = new ArrayList<>();

        for (Measurement m : tempMeasure) {
            rList.add("Sensor:" + m.getCensorName() + " | Measure: " + m.getMeasure() + " celcius");
        }
        return rList;
    }
    
    public int[][] getTempGraph(){
        
        for (Measurement m : tempMeasure){
            
        }
        
        return null;
    }

}
