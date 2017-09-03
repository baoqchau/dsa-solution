import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class equalStack {

    public static int maxStacksHeight(int[][] stacks, int[] counts, int[] sums){
        if (sums[0] == sums[1] && sums[1] == sums[2])
            return sums[0];
        int smallestPossibleSum;
        int selectedStack;
        int[] subCounts = new int[3];
        int i;
        while (true) {
           smallestPossibleSum = sums[0];
           selectedStack = 0;
           for (i=1; i<3; i++){
               if (sums[i] < smallestPossibleSum){
                   selectedStack = i;
                   smallestPossibleSum = sums[i];
               }
           }
           for (i=0; i<3; i++){
               if (selectedStack != i){
                   while (sums[i] > smallestPossibleSum && sums[i] > 0 && subCounts[i] < counts[i]){
                       sums[i] -= stacks[i][subCounts[i]];
                       subCounts[i]++;
                   }
               }
           }
           if (sums[0] == sums[1] && sums[1] == sums[2])
               return sums[0];
            else if (sums[0] == 0 || sums[1] == 0 || sums[2] == 0)
                return 0;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] counts = new int[3];
        counts[0] = in.nextInt();
        counts[1] = in.nextInt();
        counts[2] = in.nextInt();
        int[][] stacks = new int[3][];
        stacks[0] = new int[counts[0]];
        stacks[1] = new int[counts[1]];
        stacks[2] = new int[counts[2]];
        int[] sums = new int[3];
        for(int h1_i=0; h1_i < counts[0]; h1_i++){
            stacks[0][h1_i] = in.nextInt();
            sums[0] += stacks[0][h1_i];
        }
        for(int h2_i=0; h2_i < counts[1]; h2_i++){
            stacks[1][h2_i] = in.nextInt();
            sums[1] += stacks[1][h2_i];
        }
        for(int h3_i=0; h3_i < counts[2]; h3_i++){
            stacks[2][h3_i] = in.nextInt();
            sums[2] += stacks[2][h3_i];
        }
        System.out.println(maxStacksHeight(stacks, counts, sums));
    }
}
