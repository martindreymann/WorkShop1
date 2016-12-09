package worksshop_1;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
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
    
    public Map<String, Double> getChartData(){
        Map<String, Double> returnMap = new TreeMap<>();
        
        for (Measurement m : aqMeasure){
            returnMap.put(m.getDate().toString() ,  m.getMeasure());
        }
        
        return returnMap;
    }

    public ArrayList<String> getAirQuality() {

        ArrayList<String> rList = new ArrayList<>();

        for (Measurement m : aqMeasure) {
            rList.add( m.getCensorName() + ": " + m.getMeasure() + " CO2\n");
        }
        return rList;
    }

    public ArrayList<String> getTemperature() {

        ArrayList<String> rList = new ArrayList<>();

        for (Measurement m : tempMeasure) {
            
            rList.add(m.getCensorName() + ": " + m.getMeasure() + " celcius\n");
        }
        return rList;
    }
    
    public double[][] getTempGraph(){
        
        int range = tempMeasure.size();
        double[][] rArray = new double[range][2];
        
        for (int i = 0; i < tempMeasure.size() ; i++){
            rArray[i][0] = i;
            rArray[i][1] = tempMeasure.get(i).getMeasure();
        }
        
        return rArray;
    }
    
    @Override
    public String toString(){
        return name;
    }

}
