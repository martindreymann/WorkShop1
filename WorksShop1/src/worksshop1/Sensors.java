
package worksshop1;

public abstract class Sensors {
    
    private String name;
    
    
    public Sensors(String name){
        this.name = name;
        
    }
    
    public Measurement getCurrentMeasure(){ return null; }
    public String getName() { return name; }
    
}
