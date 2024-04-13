/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capstonedemo;


/**
 *
 * @author Clenard
 */
public class CapstoneDemo {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        FootMap myMap = new FootMap();
        
        myMap.makeMap();
        myMap.displayMap();
        
        Noise capNoise = new Noise();
        
        /*
        * Increase the values of all sensors
        * while adding some periodic noise and
        * random noise instances.
        */
        for (int i=0; i<91; i++) {
            System.out.println("================================================" + i);
            myMap.upMap();
            myMap.displayMap();
            
            if (i>= 1) { 
                myMap.s1.setPress(i);
                myMap.s1.incMat(capNoise.perNoise(i));
                myMap.s1.incMat(capNoise.ranNoise());
                myMap.s1.interpolate();
            }
            
            if (i>= 6) { 
                
                myMap.s2.setPress(i-5);
                myMap.s2.incMat(capNoise.perNoise(i));
                myMap.s2.incMat(capNoise.ranNoise());
                myMap.s2.interpolate();
            }
            
            if (i>= 11) { 
                myMap.s3.setPress(i-10);
                myMap.s3.incMat(capNoise.perNoise(i));
                myMap.s3.incMat(capNoise.ranNoise());
                myMap.s3.interpolate();
            }
            
            if (i>= 16) { 
                
                myMap.s4.setPress(i-15);
                myMap.s4.incMat(capNoise.perNoise(i));
                myMap.s4.incMat(capNoise.ranNoise());
                myMap.s4.interpolate();
            }
            
            if (i>= 21) { 
                
                myMap.s5.setPress(i-20);
                myMap.s5.incMat(capNoise.perNoise(i));
                myMap.s5.incMat(capNoise.ranNoise());
                myMap.s5.interpolate();
            }
            
            if (i>= 26) { 
                
                myMap.s6.setPress(i-25);
                myMap.s6.incMat(capNoise.perNoise(i));
                myMap.s6.incMat(capNoise.ranNoise());
                myMap.s6.interpolate();
            }
            
            Thread.sleep(50);
        }
        

    }
}