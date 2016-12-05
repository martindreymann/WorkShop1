
package worksshop_1;

import java.text.DecimalFormat;
import java.util.Date;


public class Measurement {
    
    private String censorName;
    private double measure;
    private Date date;
    
    public Measurement(String censorName, double measure, Date date){
        this.censorName = censorName;
        this.measure = measure;
        this.date = date;
    }
    
    public String getCensorName(){
        return censorName;
    }
    
    public double getMeasure(){
        DecimalFormat df = new DecimalFormat("#,##");
        return Double.parseDouble(df.format(measure));
        
    }
    
    public Date getDate(){
        return date;
    }
}
