/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidmap;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
/**
 *
 * @author rdonl
 * 
 */


public class binTree {
    
    private PrintStream output;
    private Node root = null;
    private static class Node{
        int key;
        String[] value;
        Node left;
        Node right;    
        public Node(int key, String[] value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
        public String[] displayData(){
            //System.out.println(Arrays.toString(value));
            return value;
        }
    }
    
    /**
     * put will get the key/value pairs from the minPQ and add them to the tree
     * they'll be sorted by case day values
     * it will not return anything. it just adds to the tree
     * 
     * the key/value pairs of this class are the cases in a day for the key, 
     * and the rest of the data for that day as the value
     */

        /*
        The put statement is from the website below in the section "Binary tree insertion Java program - Iterative"
        https://www.netjstech.com/2019/03/binary-tree-implementation-in-java-insertion-traversal.html#BinarytreeInsertItr
        */  
        
    public void put(String[] entry){
        if(entry[1] == null){
            return;
        }
        root = put(root, entry);
    }
    public Node put(Node node, String[] entry){
        if(node == null){
            return new Node(Integer.parseInt(entry[4]), entry);
        }
        if(Integer.parseInt(entry[4]) < node.key){
            node.left = put(node.left, entry);
        }
        else if(Integer.parseInt(entry[4]) > node.key){
            node.right = put(node.right, entry);
        }
        else if(Integer.parseInt(entry[4]) == node.key){
            return new Node(Integer.parseInt(entry[4]), entry);
        }
        return node;
    }
    /**
     * prints key/value pairs in order of min to max
     * it will be sent to an output file instead of print to the console
     */
    public void print(){
        try{
            output = new PrintStream("Covid_Output.txt");
            output.println("Top 3 New Case Days of Every Country");
            output.println("Categories: Continent - Country - Date - Total Cases - New Cases - Population");
            inOrder(root);
            output.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
    private void inOrder(Node node){
        // The recursive structure is from https://java2blog.com/binary-tree-inorder-traversal-in-java/#Recursive_solution
        // The line to write to file is my own.
        
        if(node == null){
            return;
        }
        
        //System.out.println(Arrays.toString(node.left.value));
        inOrder(node.left);
        output.println(Arrays.toString(node.displayData()));
        inOrder(node.right);
        
    }
}
