/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.LinkedList;
/**
 *
 * @author rdonl
 */
public class hashTable<Key, Value> {

    // Methods except main are from the following website. Get was modified by me for this lab
    // https://phpfog.com/how-to-create-a-hash-table-in-java-chaining-example/
    public static class HTObject {
        public String key;
        public Integer value;
    }
    
    public static final int ARR_SIZE = 5;
    private LinkedList<HTObject>[] arr = new LinkedList[ARR_SIZE];

    // Establishes the table
    public hashTable() {
        //init vals in array
        for(int i=0; i<ARR_SIZE; i++) {
            arr[i] = null;
        }
    }

    // Retrieves the hash value, hash code, and value of a key
    private HTObject getObj(String key) {
        if(key == null)
            return null;

        int index = key.hashCode() % ARR_SIZE;
        LinkedList<HTObject> items = arr[index];
        System.out.print("Hash value of " + key + " is: " + index);
        if(items == null)
            return null;

        for(HTObject item : items) {
            if(item.key.equals(key))
                return item;
        }

        return null;
    }

    // Prints the hash code and value of an item in the table
    // Has an error message if the input or its value is not present
    public void get(String key) {
        HTObject item = getObj(key);

        if(item == null)
            System.out.println(key + " or its value is not present in the system");
        else{
            System.out.println(" Hash code of " + key + " is: " + key.hashCode() + " Value: " + item.value);
        }
    }
    
    // Adds an item to the table with a value
    public void put(String key, Integer value) {
        int index = key.hashCode() % ARR_SIZE;
        LinkedList<HTObject> items = arr[index];
        
        // Creates a new linked list if it is empty
        if(items == null) {
            items = new LinkedList<HTObject>();

            HTObject item = new HTObject();
            item.key = key;
            item.value = value;

            items.add(item);

            arr[index] = items;
        }
        // Adds to the existing linked list
        else {
            for(HTObject item : items) {
                if(item.key.equals(key)) {
                    item.value = value;
                    return;
                }
            }

            HTObject item = new HTObject();
            item.key = key;
            item.value = value;

            items.add(item);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        hashTable<String, Integer> h = new hashTable<String,Integer>();
        String[] list = new String[]{"E", "A", "S", "Y", "Q", "U", "T", "I", "O", "N"};
        for (int i = 0; i < list.length; i++){
            h.put(list[i], i);
        }
        for (int i = 0; i < list.length; i++){
            h.get(list[i]);
        }
    }
    
}
