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
        
        FootMap myMap = new FootMap();
        
        myMap.s1.setPress(50);
        myMap.s2.setPress(50);
        myMap.s3.setPress(50);
        myMap.s4.setPress(50);
        myMap.s5.setPress(50);
        myMap.s6.setPress(50);
        
        double n1, n2, n3;
        double so1,so2;
        
        double l1,l2,l3;
        double r1,r2;
        
        //Vertical component
        //North
        n1 = myMap.s1.getPress();
        n2 = myMap.s2.getPress();
        n3 = myMap.s3.getPress();
        double nTot = n1+n2+n3;
        //South
        so1 = myMap.s5.getPress();
        so2 = myMap.s6.getPress();
        double sTot = so1+so2;
        
        double vTot = nTot + sTot;
        
        double vCentre;
        
        vCentre = 12*(nTot/vTot);
        
        System.out.println("Vertical Center of gravity is " + vCentre + " inches from the top.");
        
        //Horizontal Component
        l1 = myMap.s1.getPress();
        l2 = myMap.s4.getPress();
        l3 = myMap.s5.getPress();
        double lTot = l1+l2+l3;
        //South
        r1 = myMap.s3.getPress();
        r2 = myMap.s6.getPress();
        double rTot = r1+r2;
        
        double hTot = lTot + rTot;
        
        double hCentre;
        
        hCentre = 5*(lTot/hTot);
        
        System.out.println("Horizontal Center of gravity is " + hCentre + " inches from the right.");
        
        System.out.println("The centre of gravity is " + vCentre + " inches from the top and " + hCentre + " inches from the right.");
        
        myMap.makeMap();
        myMap.displayMap();
        
    }
}