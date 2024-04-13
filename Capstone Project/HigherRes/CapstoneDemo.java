/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstonedemo;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 *
 * @author Clenard
 */
public class CapstoneDemo {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        double s1=0, s2=0, s3=0, s4=0, s5=0;
        double d1,d2,d3,d4,d5;
        String senInput = "";
        
        FootMap myMap = new FootMap();
        BufferedReader reader;
        StringTokenizer st;
        
        myMap.makeMap2();
        myMap.displayMap();
        
        myMap.initializeMap();
        myMap.displayMap();
        
        myMap.makeMap2();
        myMap.displayMap();
    }
}