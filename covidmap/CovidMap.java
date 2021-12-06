/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidmap;
import java.io.File;

/**
 *
 * @author rdonl
 */
public class CovidMap {

    /**
     * @param args the command line arguments
     */
    
    /** 
     * @param args 
     * Main will get the file through a scanner
     * The file will be sent to the minPQ class using a method likely named makePQ
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        File data = new File("covid_data_world.csv");
        minPQ cm = new minPQ();
        cm.makePQ(data);
        
        
    }
    
}
