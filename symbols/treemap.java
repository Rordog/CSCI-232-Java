/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbols;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *  
 * @author rdonl
 */
public class treemap implements Comparable<treemap>{

    // Standard abstract override that Java gave me
    @Override
    public int compareTo(treemap o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Everything after this point was written by me
    // Establishes Treemap
    private static TreeMap<Integer, Integer> map = new TreeMap<>();
    
    // Interacts with the driver and starts the program
    treemap() {
        readFile("lab3in.txt");   
    }
    
    // Add the key value set to the treemap
    private static void put(int key, int value) {
        map.put(key, value);
    }
    
    // Looks through treemap for requested key value set
    private static void get(int key){
        System.out.println("Key " + key + " was found with value " + map.get(key));
    }
    
    // Deletes set at chosen key value
    private static void delete(int key){
        map.remove(key);
    }
    
    // Finds the largest Key/Value set
    private static void max(){
        System.out.println("Max Key/Value Pair: " + map.lastKey() + " " + map.get(map.lastKey()));        
    }
    
    // Finds the smallest Key/Value set
    private static void min(){
        System.out.println("Min Key/Value Pair: " + map.firstKey() + " " + map.get(map.firstKey()));
    }
    
    // Prints all data sets in the treemap
    private static void printAll(){
        System.out.println(map.entrySet());
    }
    
    // Finds the second smallest Key/Value set
    private static void floor(){
        System.out.println("Second smallest Key/Value Pair: " + map.higherKey(map.firstKey()) + " " + map.get(map.higherKey(map.firstKey())));        
    }
    
    // Finds the second largest Key/Value set
    private static void ceiling(){
        System.out.println("Second largest Key/Value Pair: " + map.lowerKey(map.lastKey()) + " " + map.get(map.lowerKey(map.lastKey())));        
    }
    
    // Class driver that calls all other class methods
    private void readFile(String fileName){
       try{
           // Reads the file and add the data sets to treemap
           Scanner fin = new Scanner(new File(fileName));
           while(fin.hasNext()){
               treemap.put(fin.nextInt(), fin.nextInt());
           }
           treemap.get(5);
           treemap.delete(5);
           treemap.printAll();
           treemap.min();
           treemap.max();
           treemap.ceiling();
           treemap.floor();
       }
       catch (FileNotFoundException e){
            System.out.println(e);
       }
    }
    
    
    
}
