
package business;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;


public class Measurement implements Serializable {
    
    private String sensorName;
    private double measure;
    private Date date;
    private SensorType sensorType;
    
    public Measurement(String sensorName, double measure, Date date, SensorType st){
        this.sensorName = sensorName;
        this.measure = measure;
        this.date = date;
        this.sensorType = st;
    }
    
    public String getSensorName(){
        return sensorName;
    }
    
    public SensorType getType(){
        return sensorType;
    }
    
    public double getMeasure(){
        DecimalFormat df = new DecimalFormat("#,##");
        return Double.parseDouble(df.format(measure));
        
    }
    
    public String getDate(){
        String s = date.toString();
        String[] sSplit = s.split("CET");
        return sSplit[0];
    }
}
