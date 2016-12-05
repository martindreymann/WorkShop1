package worksshop1;

public class WorksShop1 {


    public static void main(String[] args) {
        
        BuildingSystem bsys = new BuildingSystem();
        Sensors t1 = new TemperatureSensor("Temperature Sensor1");
        Sensors aq1 = new AirQualitySensor("Air Quality Sensor1");
        
        Building b = new Building("SDU","Somewhere",t1,aq1);
        bsys.addBuilding(b);
        bsys.addBuilding(new Building("SDU2","OppeIMor",t1,aq1));
        
        bsys.getBuilding("SDU").readAllMeasurements();
        
        bsys.printBuildings();
        
        bsys.getBuilding("SDU").printAllMeasurements();
       
    }
    
    
    
    
}
