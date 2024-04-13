/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package capstonedemo;

import java.io.File;
import java.io.FileWriter;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Clenard
 */
public class FootMap {
    
    public Sensor s1 = new Sensor(1, 2, 2, 50);
    public Sensor s2 = new Sensor(2, 2, 2, 50);
    public Sensor s3 = new Sensor(3, 4, 4, 50);
    public Sensor s4 = new Sensor(4, 2, 2, 50);
    public Sensor s5 = new Sensor(5, 2, 2, 50);
    public Sensor s6 = new Sensor(6, 3, 2, 0);
    
    double[][] footMap = new double[47][66];
    
    
    double[][] pressMat1 = s1.getMat();
    double[][] pressMat2 = s2.getMat();
    double[][] pressMat3 = s3.getMat();
    double[][] pressMat4 = s4.getMat();
    double[][] pressMat5 = s5.getMat();
    double[][] pressMat6 = s6.getMat();
        
    public FootMap() {
        
    }
    
    public double[][] makeMap2() {
        
        s1.fillMat(99);
        s2.fillMat(99);
        s3.fillMat(99);
        s4.fillMat(99);
        s5.fillMat(99);
        
        pressMat1 = s1.getMat();
        pressMat2 = s2.getMat();
        pressMat3 = s3.getMat();
        pressMat4 = s4.getMat();
        pressMat5 = s5.getMat();
        
        for (int i=0; i<2; i++) {
            for (int j=0; j<2; j++) {
                footMap[i+13][j+10] = pressMat1[i][j];
                footMap[i+11][j+17] = pressMat2[i][j];
                footMap[i+37][j+10] = pressMat4[i][j];
                footMap[i+37][j+15] = pressMat5[i][j];
                
                footMap[i+11][j+47] = pressMat1[i][j];
                footMap[i+13][j+55] = pressMat2[i][j];
                footMap[i+37][j+49] = pressMat4[i][j];
                footMap[i+37][j+54] = pressMat5[i][j];
            }
        }
        
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                footMap[i+24][j+10] = pressMat3[i][j];
                
                footMap[i+24][j+52] = pressMat3[i][j];
            }
        }
        
        return footMap;
    }
    
    
    public double[][] incMap() {
        
        for (int i=0; i<footMap.length; i++) {
            for (int j=0; j<footMap[i].length; j++) {
                footMap[i][j] += 1;
            }
        }
        
        return footMap;
    }
    
    public void initializeMap() throws IOException {
       
        //Reading the image
        File file;
        file = new File("C:/Users/Clenard/Documents/NetBeansProjects/CapstoneDemo/src/capstonedemo/footmap.png"); // change file location to file location of image
        BufferedImage img = ImageIO.read(file);
        for (int i = 4; i < img.getHeight()-9; i++) {
            for (int j = 17; j < img.getWidth()-17; j++) {
                //Retrieving contents of a pixel
                int pixel = img.getRGB(j,i);
                footMap[i-4][j-17] = (double) pixel;
            }
        }
      
        for (int i = 0; i < footMap.length; i++) {
            for (int j = 0; j < footMap[i].length; j++) {
                if (footMap[i][j] != -1)
                footMap[i][j] = 50;
            }
        }
    }
    
    public double[][] makeMap() {
        
        for (int i=0; i<footMap.length; i++) {
            for (int j=0; j<footMap[i].length; j++) {
                footMap[i][j] = 50;
            }
        }
        
        // array 1
        System.arraycopy(pressMat1[0], 0, footMap[2], 3, s1.getWidth());
        System.arraycopy(pressMat1[1], 0, footMap[3], 2, s1.getWidth());
        System.arraycopy(pressMat1[2], 0, footMap[4], 2, s1.getWidth());
        
        // array 2
        System.arraycopy(pressMat2[0], 0, footMap[2], 6, s2.getWidth());
        System.arraycopy(pressMat2[1], 0, footMap[3], 5, s2.getWidth());
        System.arraycopy(pressMat2[2], 0, footMap[4], 5, s2.getWidth());
        
        // array 3
        System.arraycopy(pressMat3[0], 0, footMap[2], 8, s3.getWidth() - 1);
        System.arraycopy(pressMat3[1], 0, footMap[3], 7, s3.getWidth());
        System.arraycopy(pressMat3[2], 0, footMap[4], 7, s3.getWidth() - 1);
        
        // array 4
        System.arraycopy(pressMat4[0], 0, footMap[5], 3, s4.getWidth());
        System.arraycopy(pressMat4[1], 0, footMap[6], 3, s4.getWidth());
        System.arraycopy(pressMat4[2], 0, footMap[7], 3, s4.getWidth());
        System.arraycopy(pressMat4[3], 0, footMap[8], 3, s4.getWidth());
        System.arraycopy(pressMat4[4], 0, footMap[9], 3, s4.getWidth());
        //System.arraycopy(pressMat4[5], 0, footMap[8], 3, s4.getWidth());
        
        // array 5
        System.arraycopy(pressMat5[0], 0, footMap[10], 3, s5.getWidth());
        System.arraycopy(pressMat5[1], 0, footMap[11], 3, s5.getWidth());
        System.arraycopy(pressMat5[2], 0, footMap[12], 4, s5.getWidth());
        
        // array 6
        System.arraycopy(pressMat6[0], 0, footMap[10], 5, s6.getWidth());
        System.arraycopy(pressMat6[1], 0, footMap[11], 5, s6.getWidth());
        System.arraycopy(pressMat6[2], 0, footMap[12], 6, s6.getWidth() - 1);
        
        
        return footMap;
    }
    
    public double[][] upMap() {
        
        pressMat1 = s1.getMat();
        pressMat2 = s2.getMat();
        pressMat3 = s3.getMat();
        pressMat4 = s4.getMat();
        pressMat5 = s5.getMat();
        pressMat6 = s6.getMat();
        
        // array 1
        System.arraycopy(pressMat1[0], 0, footMap[2], 3, s1.getWidth());
        System.arraycopy(pressMat1[1], 0, footMap[3], 2, s1.getWidth());
        System.arraycopy(pressMat1[2], 0, footMap[4], 2, s1.getWidth());
        
        // array 2
        System.arraycopy(pressMat2[0], 0, footMap[2], 6, s2.getWidth());
        System.arraycopy(pressMat2[1], 0, footMap[3], 5, s2.getWidth());
        System.arraycopy(pressMat2[2], 0, footMap[4], 5, s2.getWidth());
        
        // array 3
        System.arraycopy(pressMat3[0], 0, footMap[2], 8, s3.getWidth() - 1);
        System.arraycopy(pressMat3[1], 0, footMap[3], 7, s3.getWidth());
        System.arraycopy(pressMat3[2], 0, footMap[4], 7, s3.getWidth() - 1);
        
        // array 4
        System.arraycopy(pressMat4[0], 0, footMap[5], 3, s4.getWidth());
        System.arraycopy(pressMat4[1], 0, footMap[6], 3, s4.getWidth());
        System.arraycopy(pressMat4[2], 0, footMap[7], 3, s4.getWidth());
        System.arraycopy(pressMat4[3], 0, footMap[8], 3, s4.getWidth());
        System.arraycopy(pressMat4[4], 0, footMap[9], 3, s4.getWidth());
        //System.arraycopy(pressMat4[5], 0, footMap[8], 3, s4.getWidth());
        
        // array 5
        System.arraycopy(pressMat5[0], 0, footMap[10], 3, s5.getWidth());
        System.arraycopy(pressMat5[1], 0, footMap[11], 3, s5.getWidth());
        System.arraycopy(pressMat5[2], 0, footMap[12], 4, s5.getWidth());
        
        // array 6
        System.arraycopy(pressMat6[0], 0, footMap[10], 5, s6.getWidth());
        System.arraycopy(pressMat6[1], 0, footMap[11], 5, s6.getWidth());
        System.arraycopy(pressMat6[2], 0, footMap[12], 6, s6.getWidth() - 1);
        
        
        return footMap;
    }
    
    public void displayMap() {
        for (int i=0; i<footMap.length; i++) {
            for (int j=0; j<footMap[i].length; j++) {
                System.out.print((int) footMap[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}