


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 *
 * @author rdonl
 */
public class hash {

    // Makes a hashmap to check for duplicate characters
    // Adds each character to the map and increases the integer value by 1 every time it adds a specifc character to the map
    // Checks if there are any values greater than 1, if so returns false
    public boolean duped(char[] letters){
        Map<Character, Integer> solo = new HashMap<>();
        Character result = 't';
        for(int i = 0; i < letters.length; i++){
            if(solo.containsKey(letters[i])){
                solo.put(letters[i], solo.get(letters[i]) + 1);
            }
            else{
                solo.put(letters[i], 1);
            }
        }
        for(Integer value: solo.values()){
            if(value > 1){
                result = 'f';
            }
        }
        if(result.equals('f')){
            return false;
        }
        else{
            return true;
        }
    }
    /**
     * @param args the command line arguments
     */
    // Reads in the file and gets each line
    // Changes each line into a char array before sending it to check for duplicates and printing true or false if there aren't any
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            BufferedReader br = new BufferedReader(new FileReader("inhash.txt"));
            String line;
            char[] letters;
            hash set = new hash();
            while((line  = br.readLine()) != null){
                letters = line.toCharArray();
                System.out.println(set.duped(letters));
            }
            
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
    
}
