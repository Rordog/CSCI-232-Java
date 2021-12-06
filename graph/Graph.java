/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.Arrays;

/**
 *
 * @author rdonl
 */

// Got the graph class from the website below.
// I wrote the driver to match the lab's requirements
// https://introcs.cs.princeton.edu/java/45graph/Graph.java.html

public class Graph {
    
    // symbol table: key = string vertex, value = set of neighboring vertices
    private static ST<String, SET<String>> st;

    // number of edges
    private int E;

    /**
     * Initializes an empty graph with no vertices or edges.
     */
    public Graph() {
        st = new ST<String, SET<String>>();
    }

   
   /**
     * Initializes a graph from the specified file, using the specified delimiter.
     *
     * @param filename the name of the file
     * @param delimiter the delimiter
     */
    public Graph(String filename, String delimiter) {
        st = new ST<String, SET<String>>();
        In in = new In(filename);
        while (in.hasNextLine()) {
            String line = in.readLine();
            String[] names = line.split(delimiter);
            for (int i = 1; i < names.length; i++) {
                addEdge(names[0], names[i]);
            }
        }
    }

   /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int V() {
        return st.size();
    }

   /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int E() {
        return E;
    }

    // throw an exception if v is not a vertex
    private void validateVertex(String v) {
        if (!hasVertex(v)) throw new IllegalArgumentException(v + " is not a vertex");
    }

   /**
     * Returns the degree of vertex v in this graph.
     *
     * @param  v the vertex
     * @return the degree of {@code v} in this graph
     * @throws IllegalArgumentException if {@code v} is not a vertex in this graph
     */
    public int degree(String v) {
        validateVertex(v);
        return st.get(v).size();
    }
    
   
   /**
     * Adds the edge v-w to this graph (if it is not already an edge).
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     */
    public void addEdge(String v, String w) {
        if (!hasVertex(v)) addVertex(v);
        if (!hasVertex(w)) addVertex(w);
        if (!hasEdge(v, w)) E++;
        st.get(v).add(w);
        st.get(w).add(v);
    }

   /**
     * Adds vertex v to this graph (if it is not already a vertex).
     *
     * @param  v the vertex
     */
    public void addVertex(String v) {
        if (!hasVertex(v)) st.put(v, new SET<String>());
    }


   /**
     * Returns the vertices in this graph.
     *
     * @return the set of vertices in this graph
     */
    public Iterable<String> vertices() {
        return st.keys();
    }

   /**
     * Returns the set of vertices adjacent to v in this graph.
     *
     * @param  v the vertex
     * @return the set of vertices adjacent to vertex {@code v} in this graph
     * @throws IllegalArgumentException if {@code v} is not a vertex in this graph
     */
    public Iterable<String> adjacentTo(String v) {
        validateVertex(v);
        return st.get(v);
    }

   /**
     * Returns true if v is a vertex in this graph.
     *
     * @param  v the vertex
     * @return {@code true} if {@code v} is a vertex in this graph,
     *         {@code false} otherwise
     */
    public boolean hasVertex(String v) {
        return st.contains(v);
    }

   /**
     * Returns true if v-w is an edge in this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @return {@code true} if {@code v-w} is a vertex in this graph,
     *         {@code false} otherwise
     * @throws IllegalArgumentException if either {@code v} or {@code w}
     *         is not a vertex in this graph
     */
    public boolean hasEdge(String v, String w) {
        validateVertex(v);
        validateVertex(w);
        return st.get(v).contains(w);
    }

   /**
     * Returns a string representation of this graph.
     *
     * @return string representation of this graph
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (String v : st) {
            s.append(v + ": ");
            for (String w : st.get(v)) {
                s.append(w + " ");
            }
            s.append('\n');
        }
        return s.toString();
    }    
    
    // I wrote my BFS on my own with no inspiration from outside sources
    public void BFS(String s){
        String[] diff1 = new String[10];
        String[] diff2 = new String[30];
        String[] diff3 = new String[20];
        int c = 0;
        diff1[9] = s;
        // Distance 1, states surrounding montana
        for(String i: st.get(s)){
            diff1[c] = i;
            c++;
        }
        // Distance 2, states surrounding those bordering montana
        c = 0;
        for(String j: diff1){
            if(j == null){
                continue;
            }
            for(String l: st.get(j)){
                // Prevents repeats states
                if(Arrays.toString(diff1).contains(l) || Arrays.toString(diff2).contains(l)){
                    continue;        
                }
                diff2[c] = l;
                c++;
                System.out.println(s + "-" + j + "-" + l);
            }
        }
        // Distance 3
        c = 0;
        for(String n: diff1){
            if(n == null){
                continue;
            }
            // Gets the distance 2 states
            for(String k: st.get(n)){
                if(k == null){
                    continue;
                }
                if(Arrays.toString(diff2).contains(k)){
                    for(String m: st.get(k)){
                        // Prevents repeat states
                        if(Arrays.toString(diff1).contains(m) || Arrays.toString(diff2).contains(m) || Arrays.toString(diff3).contains(m)){
                            continue;
                        }
                        diff3[c] = m;
                        c++;
                        System.out.println(s + "-" + n + "-" + k + "-" + m);
                    }  
                }
            }
        }        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Graph states = new Graph("inlab9.txt", " ");
        for (String v : states.vertices()) {
            System.out.print(v + ": ");
            for (String w : states.adjacentTo(v)) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        states.BFS("Montana");
    }    
}
