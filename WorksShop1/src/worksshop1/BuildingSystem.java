
package worksshop1;

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
    
    public void printBuildings(){
        System.out.println("Buildings registered:");
        for (Building b : buildings){
            System.out.println(b.getName());
        }
    }
    
}
