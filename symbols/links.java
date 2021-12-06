/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symbols;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author rdonl
 */
public class links implements Comparable<links>{
    
    // Standard abstract override that Java gave me
    @Override
    public int compareTo(links o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Everything after this point was written by me
    private static Node first = null;
    
    // Establishes the Node class that creates the linked list
    private static class Node{
        private int key;
        private int value;
        private Node next;
        
        public Node(int key, int value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    
    // Interacts with the driver and starts the program
    links() {
        readFile("lab3in.txt");
    }
    
    // Add the key value set to the list
    private static void put(int key, int value){
        
        for(Node x = first; x != null; x = x.next){
            if(key == x.key){
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
    }
    
    // Looks through list for requested key value set
    private static void get(int key){
        for (Node x = first; x != null; x = x.next){
            if (key == x.key){
                System.out.println("Key 5 was found with value " + x.value);
            }
        }
    }
    
    // Deletes set at chosen key value
    private static void delete(int key){
        if(key == first.key){
            first = first.next;
        }
        for (Node x = first; x.next != null; x = x.next){
            if(key == x.key){
                x.next = x.next.next;
            }
        }
    }
    
    // Finds the largest Key/Value set
    private static void max(){
        int maxKey = 0;
        int maxValue = 0;
        for (Node x = first; x != null; x = x.next){
            if(x.key > maxKey){
                maxKey = x.key;
                maxValue = x.value;
            }
        }
        System.out.println("Max Key/Value Pair: " + maxKey + " " + maxValue);
    }
    
    // Finds the smallest Key/Value set
    private static void min(){
        int minKey = 0;
        int minValue = 0;
        for (Node x = first; x != null; x = x.next){
            if(minKey == 0){
                minKey = x.key;
            }
            if(x.key < minKey){
                minKey = x.key;
                minValue = x.value;
            }
        }
        System.out.println("Min Key/Value Pair: " + minKey + " " + minValue);
    }
    
    // Prints all data sets in the list
    private static void printAll(){
        for (Node x = first; x != null; x = x.next){
            System.out.println(x.key + " " + x.value);
        }
    }
    
    // Finds the second smallest Key/Value set
    private static void floor(){
        int minKey = 0;        
        int nextMinKey = 0;
        int nextMinValue = 0;
        
        // This loop gets the minKey so that the second smallest can be found in the next loop
        for (Node x = first; x != null; x = x.next){
            if(minKey == 0){
                minKey = x.key;
            }
            if(x.key < minKey){
                minKey = x.key;
            }
        }
        for (Node x = first; x != null; x = x.next){
            if(nextMinKey == 0){
                nextMinKey = x.key;
            }
            if(x.key < nextMinKey && x.key > minKey){
                nextMinKey = x.key;
                nextMinValue = x.value;
            }
        }
        System.out.println("Second smallest Key/Value Pair: " + nextMinKey + " " + nextMinValue);
    }
    
    // Finds the second largest Key/Value set
    private static void ceiling(){
        int maxKey = 0;
        
        int nextMaxKey = 0;
        int nextMaxValue = 0;
        
        // This loop gets the maxKey so that the second largest can be found in the next loop
        for (Node x = first; x != null; x = x.next){
            if(x.key > maxKey){
                maxKey = x.key;
                
            }
        }
        for (Node x = first; x != null; x = x.next){
            if(x.key > nextMaxKey && x.key < maxKey){
                nextMaxKey = x.key;
                nextMaxValue = x.value;
            }
        }
        System.out.println("Second largest Key/Value Pair: " + nextMaxKey + " " + nextMaxValue);
    }
    
    // Class driver that calls all other class methods
    public void readFile(String fileName){
        try{
            // Reads the file and add the data sets to the list
            Scanner fin = new Scanner(new File(fileName));
            while(fin.hasNext()){
                links.put(fin.nextInt(), fin.nextInt());
            }
            links.get(5);
            links.delete(5);
            links.printAll();
            links.min();
            links.max();
            links.ceiling();
            links.floor();
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

}

