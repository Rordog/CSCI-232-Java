/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heapSort;
import java.io.FileNotFoundException;
import java.io.PrintStream;
/**
 *
 * @author rdonl
 */
public class heap {
    
    // All methods in the heap class were copies from the book's code
    //https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Heap.java.html
    
    private PrintStream output;
    // Places item in heapSort order
    public static void sort(Comparable[] pq){
        int n = pq.length;
        
        for(int k = n/2; k >= 1; k--){
            sink(pq, k, n);
        }
        
        int k = n;
        while (k > 1){
            exch(pq, 1, k--);
            sink(pq, 1, k);
        }
    }
    
    // Pushes a value down the heap
    private static void sink(Comparable[] pq, int k, int n){
        while(2*k <= n){
            int j = 2*k;
            if(j < n && less(pq, j, j+1)){
                j++;
            }
            if(!less(pq, k ,j)){
                break;
            }
            exch(pq, k, j);
            k = j;
        }
    }
    
    // Checks if a value is less than another
    private static boolean less(Comparable[] pq, int i, int j){
        return pq[i-1].compareTo(pq[j-1]) < 0;
    }
    
    // Swaps two values in the heap
    private static void exch(Object[] pq, int i, int j){
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
    
    // Prints the heap
    public void show(Comparable[] a){
        try{
            output = new PrintStream("output.txt");
            for(int i = 0; i < a.length; i++){
                output.println(a[i]);
            }
            int wordCount = a.length;
            output.println("The number of unique words is " + wordCount);
            output.close();
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
    
}
