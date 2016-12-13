
package business;

import java.io.Serializable;


public enum SensorType implements Serializable {
    
    CO2("co2"),TEMPERATURE("temperature");
    
    private String type;
    
    SensorType(String type){
        this.type = type;
    }
    
    public String getType(){
        return type;
    }
    
}
