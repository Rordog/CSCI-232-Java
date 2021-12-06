/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlab;

/**
 *
 * @author rdonl
 */

// All methods in this class except the deletedups is from a previous
// linkedlist program I made and have adapted to match this lab.
public class LinkedList {
    private Node first;
    private Node last;

//Establishes the linkedlist and the first node.    
    LinkedList(){
        first = null;
    }

// Adds each node to the list
    public void insert(String x){
        Node temp = new Node(x);
        temp.setNext(first);
        if(first == null){first = temp;}
        else{last.setNext(temp);}
        last = temp;
        
    }
// Prints the entire list once  
    public void print(){
        Node temp = first;
        int c = 0;
        while (temp != null){ 
            if (temp == first){
                c++;
                if (c < 2){
                    System.out.println(temp.getData());
                    temp = temp.getNext();
                }
                else{
                    break;
                }
            }
            else{
                System.out.println(temp.getData());
                temp = temp.getNext();
            }
        }
    }

//This method was created from scratch for this lab by me
/*
    It is supposed to have current be the word that the list is being checked against.
    Index would move through the list and compare it to current. Both would stop their
    current loop once they reach the end of the list.
*/    
    public void DeleteDups(){
        Node current = first;
        Node index = null;
       
        if (first == null){
            return;
        }
        else {
            while (current != null){
                
                index = current.getNext();
                
                while (index != null){
                    if (current.getData() == index.getData()){
                        index.setNext(index.getNext());
                    }
                    else{
                        index = index.getNext();
                    }
                    
                }
                current = current.getNext();
            }
        }
    }
    
}
