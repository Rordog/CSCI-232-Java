/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redblack;

/**
 *
 * @author rdonl
 */
public class rbtree {
    
    // Got the code below and in the Node from the website listed. I have edited it some to match the goal of the tree
    //https://www.programiz.com/dsa/red-black-tree
    private Node root;
    private Node TNULL;

    // Creates a null node and the root
    public rbtree() {
        TNULL = new Node();
        TNULL.color = 0;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    // Put the key into the tree as a node
    public void insert(String key, String type) {
        Node node = new Node();
        node.parent = null;
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = 1;
        node.type = type;

        Node y = null;
        Node x = this.root;

        while (x != TNULL) {
            y = x;
            if (node.data.compareTo(x.data) == -1) {
                x = x.left;
            } 
            else {
                x = x.right;
            }     
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } 
        else if (node.data.compareTo(y.data) == -1) {
            y.left = node;
        } 
        else {
            y.right = node;
        }

        if (node.parent == null) {
            node.color = 0;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }
        
        fixInsert(node);
    }
    // Balance the node after insertion
    // Changes colors of node to follow RB Tree rules
    private void fixInsert(Node k) {
        Node u;
        while (k.parent.color == 1) {
            if (k.parent == k.parent.parent.right) {
                u = k.parent.parent.left;
                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } 
                else {
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    leftRotate(k.parent.parent);
                }
            }
            else {
                u = k.parent.parent.right;

                if (u.color == 1) {
                    u.color = 0;
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    k = k.parent.parent;
                } 
                else {
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }
                    k.parent.color = 0;
                    k.parent.parent.color = 1;
                    rightRotate(k.parent.parent);
                }
            }
            if (k == root) {
                break;
            }
        }
        root.color = 0;
    }
    
    // Rotates the current to the left
    public void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != TNULL) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } 
        else if (x == x.parent.left) {
            x.parent.left = y;
        } 
        else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Rotates the current node to the right
    public void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNULL) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } 
        else if (x == x.parent.right) {
            x.parent.right = y;
        } 
        else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }
    
    // Adds an int value to the node
    public void addValue(String k, int num) {
        addValue(this.root, k, num);
    }
    
    // Finds the key that is searched for and attaches the int to its value
    private void addValue(Node node, String key, int num) {
        if(node == TNULL){
            return;
        }
        if (key.equals(node.data)) {
            node.intvalue = num;
            return;
        }

        if (key.compareTo(node.data) == -1) {
            addValue(node.left, key, num);
        }
        addValue(node.right, key, num);
    }
    
    // Adds the float value to a node
    public void addValue(String k, float num) {
        addValue(this.root, k, num);
    }
    
    // Finds the key that is searched for and attaches the float to its value
    private void addValue(Node node, String key, float num) {
        if(node == TNULL){
            return;
        }
        if (key.equals(node.data)) {
            node.floatvalue = num;
            return;
        }

        if (key.compareTo(node.data) == -1) {
            addValue(node.left, key, num);
        }
        addValue(node.right, key, num);
    }
    
    public void inorder() {
        inOrderHelper(this.root);
    }
    
    // Prints the tree following in order traversal
    private void inOrderHelper(Node node) {
        if (node != TNULL) {
            inOrderHelper(node.left);
            String printColor;
            if(node.color == 1){
                printColor = "Red";
            }
            else{
                printColor = "Black";
            }
            if(node.type.equals("int")){
                System.out.println(node.data + " " + node.type + " " + node.intvalue + " " + printColor);
            }
            else{
                System.out.println(node.data + " " + node.type + " " + node.floatvalue + " " + printColor);
            }
            inOrderHelper(node.right);
        }
    }
    public void printTree() {
        printHelper(this.root, "", true);
    }
    private void printHelper(Node root, String indent, boolean last) {
        if (root != TNULL) {
            System.out.print(indent);
            if (last) {
                System.out.print("R----");
                indent += "   ";
            } 
            else {
                System.out.print("L----");
                indent += "|  ";
            }

            String sColor = root.color == 1 ? "RED" : "BLACK";
            System.out.println(root.data + "(" + sColor + ")");
            printHelper(root.left, indent, false);
            printHelper(root.right, indent, true);
        }
    }
}

