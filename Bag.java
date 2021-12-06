/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author rdonl
 * @param <Item>
 */
//https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Bag.java.html

public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of bag
    private Node<Item> last;     // end of bag
    private int n;               // number of elements in bag

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }

    /**
     * Initializes an empty bag.
     */
    public Bag() {

        first = null;
        last = null;
        n = 0;
    }

    /**
     * Returns true if this bag is empty.
     *
     * @return {@code true} if this bag is empty;
     *         {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this bag.
     *
     * @return the number of items in this bag
     */
    public int size() {
        return n;
    }

    /**
     * Adds the item to this bag.
     *
     * @param  item the item to add to this bag
     */
    public void add(Item item) {
        if(first == null){
            first = new Node<Item>();
            first.item = item;
            last = first;
            n++;
        }
        else{
            last.next = new Node<Item>();
            last = last.next;
            last.item = item;
            last.next = null;
            n++;
        }
    }


    /**
     * Returns an iterator that iterates over the items in this bag in arbitrary order.
     *
     * @return an iterator that iterates over the items in this bag in arbitrary order
     */
    public Iterator<Item> iterator()  {
        return new LinkedIterator(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }
        public boolean hasPrev() { return current != null;}

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
        public Item prev() {
            if(!hasPrev()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.prev;
            return item;
        }
        
    }

    /**
     * Unit tests the {@code Bag} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Bag<Integer> bag = new Bag<Integer>();
        int[] input = {1,2,3,4,5};
        for(int i = 0; i < input.length; i++){
            int item = input[i];
            bag.add(item);
        }      
        
        System.out.println("size of bag = " + bag.size());
        for (Integer s : bag) {
            System.out.println(s);
        }
    }

}
