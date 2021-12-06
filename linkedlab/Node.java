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
// This is code that I had written for a different linkedList program that I adapted for this lab.
public class Node {
    private String word;
    private Node next;
    private Node prev;
    
    public Node(String w){ word = w;}
    public Node getNext(){return next;}
    public void setNext(Node temp) {next = temp;}
    public Node getPrev(){return prev;}
    public void setPrev(Node temp) { prev = temp;}
    public String getData(){return word;}
}