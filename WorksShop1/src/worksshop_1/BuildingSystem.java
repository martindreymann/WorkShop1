
package worksshop_1;

import java.util.ArrayList;

public class BuildingSystem {
    
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
        
        AirQualitySensor aq1 = new AirQualitySensor("AQsensor1");
        AirQualitySensor aq2 = new AirQualitySensor("AQsensor2");
        AirQualitySensor aq3 = new AirQualitySensor("AQsensor3");
        
        TemperatureSensor t1 = new TemperatureSensor("TSensor1");
        TemperatureSensor t2 = new TemperatureSensor("TSensor2");
        TemperatureSensor t3 = new TemperatureSensor("TSensor3");
        
        Building building1 = new Building("SDU", "Somewhere", aq1, aq2, t1, t2);
        Building building2 = new Building("DinMor", "HosDinMor", aq3, t3);
        
        buildings.add(building1);
        buildings.add(building2);
        
        building1.readAllMeasurements();
        building2.readAllMeasurements();
        
    }
    
}
