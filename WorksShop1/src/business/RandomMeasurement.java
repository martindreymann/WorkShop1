/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.Date;

/**
 *
 * @author Martin
 */
public class RandomMeasurement {
    
    public static Measurement getRandom(SensorType st, String sensorName){
        double randomNumber = Math.random() * 100;
        Date date = new Date();
        
        return new Measurement(sensorName, randomNumber, date, st);
        
    }
    
}
