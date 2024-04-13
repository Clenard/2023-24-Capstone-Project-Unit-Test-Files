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
    public static void main(String[] args) throws InterruptedException {
        double s1=0, s2=0, s3=0, s4=0, s5=0;
        double d1,d2,d3,d4,d5;
        String senInput = "";
        
        FootMap myMap = new FootMap();
        BufferedReader reader;
        StringTokenizer st;
        
        myMap.makeMap();
        myMap.displayMap();
        
        int i=0;
        
        try {
            reader = new BufferedReader(new FileReader("C:/Users/Clenard/Downloads/test1.txt")); // change for file
            String line = reader.readLine();
            
            while (line != null) {
                senInput = line;
                
                st = new StringTokenizer(senInput, " ");
                
                d5 = Double.parseDouble(st.nextToken());
                d4 = Double.parseDouble(st.nextToken());
                d3 = Double.parseDouble(st.nextToken());
                d2 = Double.parseDouble(st.nextToken());
                d1 = Double.parseDouble(st.nextToken());
                
                myMap.s1.setPress(d1/100);
                myMap.s2.setPress(d2/100);
                myMap.s3.setPress(d3/100);
                myMap.s4.setPress(d4/100);
                myMap.s5.setPress(d5/100);
                
                
                myMap.upMap();
                myMap.displayMap();
                i++;
                
                //System.out.println(d1 + " " + d2 + " " + d3 + " " + d4 + " " + d5);
                System.out.println("==================== " + i + "====================");
                
                //read next line
                line = reader.readLine();
            }
            
            reader.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}