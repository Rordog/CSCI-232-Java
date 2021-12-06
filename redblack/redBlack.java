/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redblack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author rdonl
 */
public class redBlack {
    // This code is written by me
    public static void main(String[] args) {
    try{
        rbtree bst = new rbtree();
        BufferedReader br = new BufferedReader(new FileReader("inrbt.txt"));
        String line;
        int i = 0;
        String[] words;
        while((line = br.readLine()) != null){
            // Adds the keys to the tree
            while(i < 6){                                  
                line = line.substring(0, line.length()-1);
                words = line.split(" ");
                bst.insert(words[1],words[0]);
                i++;
                line = br.readLine();
                bst.printTree();
            }
            // Sends the integer values to their associated keys
            while(i < 8){    
                line = line.substring(0, line.length()-1);
                words = line.split("=");
                words[0] = words[0].trim();
                words[1] = words[1].trim();
                bst.addValue(words[0], Integer.parseInt(words[1]));
                i++;
                line = br.readLine();
            }
            // Sends the float values to their associated keys
            while(i < 10){
                line = line.substring(0, line.length()-1);
                words = line.split("=");
                words[0] = words[0].trim();
                words[1] = words[1].trim();
                bst.addValue(words[0], Float.parseFloat(words[1]));
                i++;
                line = br.readLine();
            }
        }
        
        bst.inorder();
        bst.printTree();
    
    }
    catch (IOException e){
        System.out.println(e);
    }
  }
}
