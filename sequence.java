
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rdonl
 */
public class sequence {

    // This method was copied from: https://www.techiedelight.com/longest-increasing-subsequence-using-dynamic-programming/
    // Iterative function to find the length of the longest increasing subsequence
    // of a given array
    public static int LIS(int[] arr)
    {
        // base case
        if (arr == null || arr.length == 0) {
            return 0;
        }
 
        // array to store subproblem solution. `L[i]` stores the length
        // of the longest increasing subsequence that ends with `arr[i]`
        int[] L = new int[arr.length];
 
        // the longest increasing subsequence ending at `arr[0]` has length 1
        L[0] = 1;
 
        // start from the second array element
        for (int i = 1; i < arr.length; i++)
        {
            // do for each element in subarray `arr[0…i-1]`
            for (int j = 0; j < i; j++)
            {
                // find the longest increasing subsequence that ends with `arr[j]`
                // where `arr[j]` is less than the current element `arr[i]`
                if (arr[j] < arr[i] && L[j] > L[i]) {
                    L[i] = L[j];
                }
            }
            // include `arr[i]` in LIS
            L[i]++;
        }
 
        // return longest increasing subsequence (having maximum length)
        return Arrays.stream(L).max().getAsInt();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            File input = new File("lab10in.txt");
            Scanner scan = new Scanner(input);
            // Loops through the two line sections to get subsequences
            while(scan.hasNextLine() == true){
                int range = scan.nextInt();
                int sequence[] = new int[range];
                for(int i = 0; i < range; i++){
                    sequence[i] = scan.nextInt();
                }
                System.out.println("For sequence: " + Arrays.toString(sequence) + ", length of longest subsequence is " + LIS(sequence));               
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
    }
    
}
