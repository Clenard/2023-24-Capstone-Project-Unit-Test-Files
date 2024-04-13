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
public class Sensor {
    private int s_id, h, w;
    private double press;
    double[][] pressMat;
    
    public Sensor(int id) {
        s_id = id;
    }
    
    public Sensor(int id, int h, int w, double p) {
        s_id = id;
        this.h = h;
        this.w = w;
        press = p;
    }
    
    public void setPress(double pressure) {
        press = pressure;
        
        if (press < 0) {
            pressMat[h/2][w/2] = 0;
        } else {
            pressMat[h/2][w/2] = press;
        }
    }
    
    public double getPress() {
        return press;
    }
    
    public int getID() {
        return s_id;
    }
    
    public int getHeight() {
        return h;
    }
    
    public int getWidth() {
        return w;
    }
    
    public double[][] makeMat() {
        pressMat = new double[h][w];
        pressMat[h/2][w/2] = press;
        return pressMat;
    }
    
    public double[][] getMat() {
        return pressMat;
    }
    
    public void incMat(double n) {
        press += n;
        
        if (press < 0) {
            press = 0;
        }
        pressMat[h/2][w/2] = press;
    }
    
    public void decMat(double n) {
        press -= n;
        
        if (press < 0) {
            press = 0;
        }
        
        pressMat[h/2][w/2] = press;
    }
    
    public void interpolate() {
        int iCount1=0, jCount1=0;
        int iCount2=0, jCount2=0;
        int iCount3=0, jCount3=0;
        int iCount4=0, jCount4=0;
        
        for (int i=(h/2); i<h; i++) {
            iCount1++;
            for (int j=(w/2); j<w; j++) {
                jCount1++;
                
                if (i==h/2 && j==w/2) {
                    continue;
                } 
                
                if (iCount1>jCount1) {
                    pressMat[i][j] = pressMat[h/2][w/2] - iCount1*3;
                    if (pressMat[i][j] < 0) {
                        pressMat[i][j] = 0;
                    }
                } else {
                    pressMat[i][j] = pressMat[h/2][w/2] - jCount1*3;
                    if (pressMat[i][j] < 0) {
                        pressMat[i][j] = 0;
                    }
                }
                
            }
            
            jCount1 = 0;
        }
        
        for (int i=(h/2); i>=0; i--) {
            iCount2++;
            for (int j=(w/2); j<w; j++) {
                jCount2++;
                
                if (i==h/2 && j==w/2) {
                    continue;
                } 
                
                if (iCount2>jCount2) {
                    pressMat[i][j] = pressMat[h/2][w/2] - iCount2*3;
                    if (pressMat[i][j] < 0) {
                        pressMat[i][j] = 0;
                    }
                } else {
                    pressMat[i][j] = pressMat[h/2][w/2] - jCount2*3;
                    if (pressMat[i][j] < 0) {
                        pressMat[i][j] = 0;
                    }
                }
                
            }
            jCount2 = 0;
        }
        
        for (int i=(h/2); i<h; i++) {
            iCount3++;
            for (int j=(w/2); j>=0; j--) {
                jCount3++;
                
                if (i==h/2 && j==w/2) {
                    continue;
                } 
                
                if (iCount3>jCount3) {
                    pressMat[i][j] = pressMat[h/2][w/2] - iCount3*3;
                    if (pressMat[i][j] < 0) {
                        pressMat[i][j] = 0;
                    }
                } else {
                    pressMat[i][j] = pressMat[h/2][w/2] - jCount3*3;
                    if (pressMat[i][j] < 0) {
                        pressMat[i][j] = 0;
                    }
                }
                
            }
            jCount3 = 0;
        }
        
        
        for (int i=(h/2); i>=0; i--) {
            iCount4++;
            for (int j=(w/2); j>=0; j--) {
                jCount4++;
                
                if (i==h/2 && j==w/2) {
                    continue;
                } 
                
                if (iCount4>jCount4) {
                    pressMat[i][j] = pressMat[h/2][w/2] - iCount4*3;
                    if (pressMat[i][j] < 0) {
                        pressMat[i][j] = 0;
                    }
                } else {
                    pressMat[i][j] = pressMat[h/2][w/2] - jCount4*3;
                    if (pressMat[i][j] < 0) {
                        pressMat[i][j] = 0;
                    }
                }
                
            }
            jCount4 = 0;
        }
        
    }
    
}