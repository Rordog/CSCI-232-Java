/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author rdonl
 */
public class climate {

    /**
     * @param args the command line arguments
     * The main method will create three red-black trees. 
     * One for each anomaly: temperature, sea level, and co2 concentration
     * It will read three files, one for each tree and get the nodes from the files
     * The node class will contain variables for the different types of keys and the date
     * The key for each of the trees will be the anomaly value 
     * and the value will be the date
     * It will sort the inputs by the value of the key
     * After sorting all three trees, it will send the highest and lowest nodes of each tree to a separate output file
     */
    public static void main(String[] args) {
        // TODO code application logic here
        rbtree temp = new rbtree();
        rbtree co2 = new rbtree();
        rbtree sea = new rbtree();
        
        String[] line;
        try{
            // Adds values to the temperature tree
            File tempData = new File("temperature_anomaly.csv");
            Scanner scanTemp = new Scanner(tempData);
            while(scanTemp.hasNextLine() == true){
                line = scanTemp.nextLine().split(",");
                if(line[0].equals("World")){
                    temp.put(Double.parseDouble(line[3])*1.8, line[2]);
                }
                
            } 
            // Adds values to the co2 tree
            File co2Data = new File("co2.csv");
            Scanner scanCO2 = new Scanner(co2Data);
            while(scanCO2.hasNextLine() == true){
                line = scanCO2.nextLine().split(",");
                if(line[0].equals("World")){
                    co2.put(Double.parseDouble(line[3]), line[2]);
                }
            }
            // Adds values to the sea level tree
            File seaData = new File("sea_level.csv");
            Scanner scanSea = new Scanner (seaData);
            while(scanSea.hasNextLine() == true){
                line = scanSea.nextLine().split(",");
                if(line[0].equals("World")){
                    sea.put(Float.parseFloat(line[3]), line[2]);
                }
            }
            
            // Prints the data to the output file
            PrintStream output = new PrintStream ("ocean.txt");
            output.println("Dates of lowest and highest temperatures, sea levels, and CO2 average concentrations");
            output.println("The lowest temperature is: " + temp.min() + " on " + temp.getValue(temp.min()));
            output.println("The highest temperature is: " + temp.max() + " on " + temp.getValue(temp.max()));
            output.println("The lowest sea level is: " + sea.min() + " on " + sea.getValue(sea.min()));
            output.println("The highest sea level is: " + sea.max() + " on " + sea.getValue(sea.max()));
            output.println("The lowest CO2 concentration is: " + co2.min() + " on " + co2.getValue(co2.min()));
            output.println("The highest CO2 concentration is: " + co2.max() + " on " + co2.getValue(co2.max()));
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
        
    }
    
}
