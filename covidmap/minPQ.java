/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidmap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 *
 * @author rdonl
 * 
 */
public class minPQ {
    
    private String[][] pq = new String[6][3];
    
    /**
     * add will put the current set of data into the queue with the key of cases in a day
     * it adds the key/value pair into the queue and doesn't return anything
     * It tests the new cases of the array being added against the current values of new cases
     * in the priority queue already
     * It starts by checking against the current largest and working its way through the rest of the queue
     * @param dayEntry is the current lines worth of entries from the arraylist entries
     */
    public void addEntry(String[] dayEntry){
        // Checks against the current highest in the pq
        if(Integer.parseInt(dayEntry[4]) > Integer.parseInt(pq[4][0])){
            for(int i = 1; i > -1; i--){
                for(int j = 0; j < 6; j++){
                    pq[j][i+1] = pq[j][i];
                }
            }
            for(int i = 0; i < 6; i++){
                pq[i][0] = dayEntry[i];
            }
        }
        // Checks against the second highest
        else if(Integer.parseInt(dayEntry[4]) > Integer.parseInt(pq[4][1])){
            for(int i = 0; i < 6; i++){
                pq[i][2] = pq[i][1];
            }
            for(int i = 0; i < 6; i++){
                pq[i][1] = dayEntry[i];
            }
        }
        // Checks against the last in the pq
        else if(Integer.parseInt(dayEntry[4]) > Integer.parseInt(pq[4][2])){
            for(int i = 0; i < 6; i++){
                pq[i][2] = dayEntry[i];
            }
        }
    }
    /**
     * removeMax will return the largest and adjust the queue to remove the current max
     * and set the second largest to largest and third largest to second largest 
     * and the smallest to null
     * @return max
     * the return statement allows the max pair to be sent to the binary tree
     */
    public String[] removeMax(){
        String[] max = new String[6];
        for(int i = 0; i < 6; i++){
            max[i] = pq[i][0];
        }
        return max;
    }
    // Returns the second in pq
    public String[] secondMax(){
        String[] max2 = new String[6];
        for(int i = 0; i < 6; i++){
            max2[i] = pq[i][1];
        }
        return max2;
    }
    // Returns the last in pq
    public String[] thirdMax(){
        String[] max3 = new String[6];
        for(int i = 0; i < 6; i++){
            max3[i] = pq[i][2];
        }
        return max3;
    }
    
    /**
     * makePQ will get the file from main and start by sending the 
     * data from one country into a min pq
     * makePQ will call all the other methods in the class (add, removeMax)
     * it will send the top 3 case days of each country into the binary search tree
     * 
     * the key/value pairs of this class are the cases in a day for the key, 
     * and the rest of the data for that day as the value
     * 
     * The two arraylists (entries and countryNames) contain the full entries for a day and the country names respectively
     * 
     * @param file is the input file from main
     */
    public void makePQ(File file){
        
        try{           
            ArrayList<String[]> entries = new ArrayList<>();            
            ArrayList<String> countryNames = new ArrayList<>();
            String[] lineInArray;
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine() == true){
                lineInArray = scan.nextLine().split(",");
                entries.add(lineInArray);
                countryNames.add(lineInArray[1]);
            }              
            // Removes the first line which contains the headers
            entries.remove(0);
            /* lineNumber tracks the current line so once the file changes to a different country, 
               the priority queue will empty the current country's top 3 days and it will start the next country
               After emptying the queue, the country names is set to the next one and the cycle repeats for the rest of the entries
            */
            int lineNumber = 1;
            String name = countryNames.get(0);
            binTree tree = new binTree();
            while (lineNumber < countryNames.size()-2){ 
                //System.out.println(countryNames.size());
                
                pq[4][0] = "0";
                pq[4][1] = "0";
                pq[4][2] = "0";
                while (countryNames.get(lineNumber).equals(name) && lineNumber < 106114){
                    addEntry(entries.get(lineNumber));
                    //System.out.println(lineNumber);
                    lineNumber++;
                } 
                
                tree.put(removeMax());
                tree.put(secondMax());
                tree.put(thirdMax());             
                
                name = countryNames.get(lineNumber);
            }
            tree.print();
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
}
