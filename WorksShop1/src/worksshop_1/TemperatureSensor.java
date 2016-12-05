
package worksshop_1;

import java.util.Date;


public class TemperatureSensor extends Sensors {
    
    public TemperatureSensor(String name) {
        super(name);
    }
    
    @Override
    public Measurement getCurrentMeasure(){
        //Random number
        return new Measurement(this.getName(),getMeasure(),new Date());
    }
    
    private double getMeasure(){
        return Math.random()*100;
    }
    
    
    
}
