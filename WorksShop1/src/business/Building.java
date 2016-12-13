package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import javafx.util.Pair;

public class Building implements Serializable {

    private String name, adress;

    private ArrayList<Sensor> sensorList;
    public ArrayList<Measurement> measures;

    public Building(String name, String adress, Sensor... sensors) {
        sensorList = new ArrayList<>();
        this.name = name;
        this.adress = adress;
        measures = new ArrayList<>();

        for (Sensor s : sensors) {
            sensorList.add(s);
        }
    }

    public void addSensor(Sensor s) {
        sensorList.add(s);
    }

    public void removeSensor(Sensor s) {
        sensorList.remove(s);
    }

    public String getName() {
        return name;
    }
    
    public void readAllMeasurements(){
        for (Sensor s : sensorList){
            measures.add(s.getCurrentMeasure());           
        }
    }

    public Map<String, Double> getLineChartData(SensorType st) {
        Map<String, Double> returnMap = new TreeMap<>();

        for (Measurement m : measures) {
            if(m.getType() == st)
                returnMap.put(m.getDate(), m.getMeasure());
        }

        return returnMap;
    } 

    @Override
    public String toString() {
        return name;
    }
    
    public void addNewMeasure(double temp, double co2){
        //Haha, nothing happens. You thought it would work, didn't you?
    }
    

}
