/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        
package heapSort;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
/**
 *
 * @author rdonl
 */
public class heapSort {
    
    // The removeDupes method is from the website below. The rest is my own creation
    //https://www.knowprogram.com/java/remove-duplicates-in-array-java/
    public static String[] removeDupes(String[] dupes){
        int index = 1;
        
        for(int i = 1; i < dupes.length; i++){
            String word = dupes[i];
            for(int j = 0; j < index; j++){
                if(dupes[j].equals(word)){
                    break;
                }
                if(j == index-1){
                    dupes[index++] = word;
                    break;
                }
            }
        }
        return Arrays.copyOf(dupes, index);
    }
    /**
     * @param args the command line arguments
     */
    
    // Uses StringBuilder to put the whole file into an array
    // Puts the words into an array, then removes duplicates
    // Heapsorts the array, then prints it
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            heap story = new heap();
            BufferedReader br = new BufferedReader(new FileReader("tale.txt"));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            String dupWords[];
            String finWords[];
            while((line = br.readLine()) != null){
                stringBuilder.append(line  + " ");
            }
            dupWords = stringBuilder.toString().split(" ");
            finWords = removeDupes(dupWords);
            
            story.sort(finWords);
            story.show(finWords);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    
}
