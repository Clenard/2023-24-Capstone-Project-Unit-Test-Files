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
        
        Noise testNoise = new Noise();
        
        double c1=0, c2=0, c3=0, c4=0, c5=0, c6=0;
        double rNoise=0, pNoise=0;
        
        
        for (int i=0; i<100; i++) {
            myMap.upMap();
            myMap.displayMap();
            
            if (i>= 1 && i<=20) { // heel strike
                c5 += 1;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s5.setPress(c5 + pNoise + rNoise);
                
                c6 += 1;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s6.setPress(c6 + pNoise + rNoise);
            }
            
            if (i>= 21 && i<=40) { // loading response
                c1 += 2.5;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s1.setPress(c1 + pNoise + rNoise);
                
                c2 += 2.5;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s2.setPress(c2 + pNoise + rNoise);
                
                c3 += 2.5;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s3.setPress(c3 + pNoise + rNoise);
                
                c4 += 3;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s4.setPress(c4 + pNoise + rNoise);
                
                
                c5 -= 0.5;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s5.setPress(c5 + pNoise + rNoise);
                
                c6 -= 0.5;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s6.setPress(c6 + pNoise + rNoise);
            }
            
            if (i>= 41 && i<=60) { // middle stance
                c1 += 1;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s1.setPress(c1 + pNoise + rNoise);
                
                c2 += 1;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s2.setPress(c2 + pNoise + rNoise);
                
                c3 += 1;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s3.setPress(c3 + pNoise + rNoise);
                
                c4 += 0.75;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s4.setPress(c4 + pNoise + rNoise);
            }
            
            if (i>= 61 && i<=80) { // terminal stance
                c1 += 0.75;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s1.setPress(c1 + pNoise + rNoise);
                
                c2 += 0.75;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s2.setPress(c2 + pNoise + rNoise);

                c3 += 0.75;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s3.setPress(c3 + pNoise + rNoise);
                
                c4 += 1;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s4.setPress(c4 + pNoise + rNoise);
                
                c5 -= 3;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s5.setPress(c5 + pNoise + rNoise);
                
                c6 -= 3;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s6.setPress(c6 + pNoise + rNoise);
            }
            
            if (i>= 81 && i<100) { // pre-swing
                c1 += 0.25;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s1.setPress(c1 + pNoise + rNoise);
                
                c2 += 0.25;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s2.setPress(c2 + pNoise + rNoise);

                c3 += 0.25;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s3.setPress(c3 + pNoise + rNoise);
                
                c4 += 0.15;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s4.setPress(c4 + pNoise + rNoise);
                
                c5 -= 0.75;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s5.setPress(c5 + pNoise + rNoise);
                
                c6 -= 0.75;
                pNoise = testNoise.perNoise(i);
                rNoise = testNoise.ranNoise();
                myMap.s6.setPress(c6 + pNoise + rNoise);
                
            }
            System.out.println("============================================" + i);
            
            myMap.s1.interpolate();
            myMap.s2.interpolate();
            myMap.s3.interpolate();
            myMap.s4.interpolate();
            myMap.s5.interpolate();
            myMap.s6.interpolate();
        
            Thread.sleep(50);
        }
        
        
        /*
        for (int i=0; i<100; i++) {
            myMap.upMap();
            myMap.displayMap();
            
            if (i>= 1 && i<=20) { // heel strike
                myMap.s5.incMat(1);
                myMap.s6.incMat(1);
            }
            
            if (i>= 21 && i<=40) { // loading response
                myMap.s1.incMat(2.5);
                myMap.s2.incMat(2.5);
                myMap.s3.incMat(2.5);
                myMap.s4.incMat(3);
                
                myMap.s5.decMat(0.5);
                myMap.s6.decMat(0.5);
            }
            
            if (i>= 41 && i<=60) { // middle stance
                myMap.s1.incMat(1);
                myMap.s2.incMat(1);
                myMap.s3.incMat(1);
                myMap.s4.incMat(0.75);
            }
            
            if (i>= 61 && i<=80) { // terminal stance
                myMap.s1.incMat(0.75);
                myMap.s2.incMat(0.75);
                myMap.s3.incMat(0.75);
                myMap.s4.incMat(1);
                
                myMap.s5.decMat(3);
                myMap.s6.decMat(3);
            }
            
            if (i>= 81 && i<100) { // pre-swing
                myMap.s1.incMat(0.25);
                myMap.s2.incMat(0.25);
                myMap.s3.incMat(0.25);
                myMap.s4.incMat(0.15);
                
                myMap.s5.decMat(0.75);
                myMap.s6.decMat(0.75);
            }
            
            myMap.s1.interpolate();
            myMap.s2.interpolate();
            myMap.s3.interpolate();
            myMap.s4.interpolate();
            myMap.s5.interpolate();
            myMap.s6.interpolate();
            
            Thread.sleep(50);
        }
        */
    }
}