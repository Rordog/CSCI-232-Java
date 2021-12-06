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
public class linked {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // I wrote this section from scratch. 
        // It adds each element to the list, prints the list, then deletes the duplicates before printing again.
        // The program seems to be stuck looping through the delete method and I can't see why.
        LinkedList ll = new LinkedList();
        ll.insert("to");
        ll.insert("be");
        ll.insert("or");
        ll.insert("not");
        ll.insert("to");
        ll.insert("be");
        ll.print();
        ll.DeleteDups();
        ll.print();
    }
    
}
