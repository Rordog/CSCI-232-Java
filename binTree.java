/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rdonl
 */
public class binTree {
    
    // BST was take from https://www.netjstech.com/2019/03/binary-tree-implementation-in-java-insertion-traversal.html#BinarytreeInsertItr
    // Everything until height methods are from this website
    private Node root;
    private int height2 = 0;
    
    binTree(){
        root = null;
    }
    
    private class Node{
        char value;
        Node left;
        Node right;
        Node(char value){
            this.value = value;
            left = null;
            right = null;
        }
        public void printNode(){
            System.out.print(value + " ");
        }
    }
    
    public void insert(char value){
        // Height is initially 1 to include the root
        root = insert(root, value, 1);        
    }
    // I adapted this method to accept the compareChar and compute height
    public Node insert(Node node, char value, int height){
        // Sets height2 attribte to height if height is greater than current height
        // Creates new node at the ending position of the method
        if(node == null){
            if(height > height2){
                height2 = height;
            }
            return new Node(value);
        }
        int compareChar = Character.compare(value, node.value);
        // Send the value left if value is less than current node
        if(compareChar < 0){
            height++;
            node.left = insert(node.left, value, height);
        }
        // Sends the value right if value is greater than current node
        else if(compareChar > 0){
            height++;
            node.right = insert(node.right, value, height);
        }
        return node;
    }
    // Left Root Right
    public void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            node.printNode();
            inOrder(node.right);
        }
    }
    // Root Left Right
    public void preOrder(Node node){
        if(node != null){
            node.printNode();
            preOrder(node.left);
            preOrder(node.right);
        }
    }
    // Left Right Root
    public void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            node.printNode();
        }
    }
       
    // The height methods are written by me
    public int height1(Node root){
        if(root == null){
            return 0;
        }
        int left = height1(root.left);
        int right = height1(root.right);
        return Math.max(left, right) + 1;
    }
    // Returns the height data attribute    
    public int height2(){          
        return height2;
    }   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        binTree bst = new binTree();
        bst.insert('E');
        bst.insert('A');
        bst.insert('S');
        bst.insert('Y');
        bst.insert('Q');
        bst.insert('U');
        bst.insert('E');
        bst.insert('S');
        bst.insert('T');
        bst.insert('I');
        bst.insert('O');
        bst.insert('N');
        System.out.println("In Order Traversal");
        bst.inOrder(bst.root);
        System.out.println();
        System.out.println("Pre Order Traversal");
        bst.preOrder(bst.root);
        System.out.println();
        System.out.println("Post Order Traversal");
        bst.postOrder(bst.root);
        System.out.println();
        int height1 = bst.height1(bst.root);
        System.out.println("Height (Recursive): " + height1);
        System.out.println("Height (Non-Recursive): " + bst.height2);
    }
    
}
