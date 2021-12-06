/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
/**
 *
 * @author rdonl
 */

// Establishes all variables. Written by me
// Word is added to the stack, stackCounter tracks the 
// index to maintain proper stack ordering
// Returned is the word that get popped
public class stack {

    Scanner input = new Scanner(System.in);    
    String array[] = new String[20];
    int stackCounter = 0;
    String word;
    String returned;
    
    /**
     * @param args the command line arguments
     */
   
// Iterates through the string while input has something left.
// Will pop if word is $ and will push on anything else
// Currently, I can't make the while loop end
// Written by me
    public void run(){
        System.out.println("Enter a string: ");
        
        while (input.hasNext() == true){
            word = input.next();
            
            if (word.equals("$")){                
                pop();
            }
            else {                
                push(word);
            }
        }
// After there is nothing left to input, the stack will print in LIFO order
        while (array[0] != null){
            pop();
        }
    }
 
// Reduces the counter so it isn't on an empty spot before printing that word and making that spot null
// Written by me
    private void pop(){
        //System.out.println(array[index--]);
        stackCounter--;
        returned = array[stackCounter];
        System.out.println("Popped word: " + returned);
        array[stackCounter] = null;  
    }

// Adds the next word in the next slot in the stack.
// Written by me
    private void push(String word){
        array[stackCounter] = word;
        stackCounter++;        
    }
        
// Driver to run the program and its methods. Written by me
    public static void main(String[] args) {       
        // TODO code application logic here
        stack run = new stack();
        run.run();
        
        
    }
    
}
