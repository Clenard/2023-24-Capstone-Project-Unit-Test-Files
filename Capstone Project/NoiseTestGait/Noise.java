/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstonedemo;

import java.lang.*;
import java.util.*;
/**
 *
 * @author Clenard
 */
public class Noise {
    
    public Noise() {
        
    }
    
    /*
    * This method returns a noise level 
    * taken from the sin curve. The value
    * is added a small noise value at random
    * times for more noise.
    */
    public double perNoise(double n) {
        double b = Math.toRadians(4*n);
        double pNoise = Math.sin(b)*5;
        
        pNoise += (ranNoise()/4);
        
        
        return pNoise;
    }
    
    /*
    * This method generates noise at random
    * points. The threshold is between -5 and 5
    */
    public double ranNoise() {
        double rNoise = 0;
        double x = Math.random();
        double chance = Math.random()*5;
        
        if (chance <= 2) {
            if (chance > 1 || chance < 3.5) {
                x = x*-1;
            }
            rNoise = x*20;
        }
        
        return rNoise;
    }
}
