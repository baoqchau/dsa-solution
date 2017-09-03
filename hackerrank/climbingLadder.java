/**
 * Created by bao on 9/3/17.
 */
import java.util.*;

public class climbingLadder {

    // customize binary search to find position in array where number k is between 2 numbers
    static int binarySearch(int start, int end, int[] a, int k) {
        if (a.length == 1)
            return 0;
        int mid = (start+end)/2;
        if ((a[mid] >=k) && (k >= a[mid+1])) {
            return mid;
        }
        else {
            if (mid == 0) {
                return 0;
            }
            else if  (mid == a.length -2 && end == a.length-1) {
                return a.length-1;
            }
            else {
                if (a[mid] < k) {
                    return binarySearch(start, mid, a, k);
                }
                else {
                    return binarySearch(mid, end, a, k);
                }
            }
        }
    }

    static void climbLadder(int[] scores, int[] alice, int[] ranks, int n, int m){
        int i,scorePos, actualScorePos = 0;
        for (i=0; i< m; i++) {
            scorePos = binarySearch(0, n-1, scores, alice[i]);
            if (scorePos == 0) {
                if (alice[i] >= scores[scorePos])
                    actualScorePos = 1;
                else
                    actualScorePos = ranks[scorePos]+1;
            }
            else {
                if (scores[scorePos] > alice[i]) {
                    actualScorePos = ranks[scorePos]+1;
                }
                else
                    actualScorePos = ranks[scorePos];
            }
            System.out.println(actualScorePos);
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        int[] ranks = new int[n];
        ranks[0] = 1;
        for(int scores_i=0; scores_i < n; scores_i++){
            scores[scores_i] = in.nextInt();
            if (scores_i >0){
                if (scores[scores_i] == scores[scores_i-1])
                    ranks[scores_i] = ranks[scores_i-1];
                else
                    ranks[scores_i] = ranks[scores_i-1] + 1;
            }
        }
        int m = in.nextInt();
        int[] alice = new int[m];
        for(int alice_i=0; alice_i < m; alice_i++){
            alice[alice_i] = in.nextInt();
        }
        climbLadder(scores, alice, ranks,n, m);
    }
}
