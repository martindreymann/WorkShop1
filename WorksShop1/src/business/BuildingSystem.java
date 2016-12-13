
package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class BuildingSystem implements Serializable {
    
    private ArrayList<Building> buildings;
    
    public BuildingSystem(){
       buildings = new ArrayList<>();
    }
    
    
    public void addBuilding(Building building){
        buildings.add(building);
    }
    
    public void removeBuilding(Building building){
        buildings.remove(building);
    }
    
    public Building getBuilding(String bname){
        for (Building b : buildings){
            if (b.getName().equals(bname)){
                return b;
            }
        }
        return null;
    }
    
    public ArrayList<Building> getAllBuildings(){
        return buildings;
    }
    
    
    public void createSomeStuff(){
        
        Sensor s1 = new Sensor("CO2-sensor-1",SensorType.CO2);
        Sensor s2 = new Sensor("TEMP-sensor-1",SensorType.TEMPERATURE);
        Building b = new Building("SDU","Campusvej 55",s1,s2);
        b.readAllMeasurements();                
        addBuilding(b);
        
        
        
    }
    
}
