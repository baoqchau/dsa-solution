// Problem: Find maximum sub array with given sum
// Solution: http://www.techiedelight.com/find-maximum-length-sub-array-having-given-sum/
import java.util.*;

class maxSubArrayWithGivenSum {

    static void findSubArrayWithGivenSum(int[] a, int k){
        Hashtable<Integer, Integer> sumPos = new Hashtable<Integer, Integer>();
        int lengthSubArray = 0; //length of subarray
        sumPos.put(0, -1); //in case subarray start at 0
        int newLastPos = 0, i, sum = 0;
        for (i=0; i< a.length; i++) {
           sum += a[i];
           if (!sumPos.containsKey(sum)){
               sumPos.put(sum, i);
           }
           if (sumPos.containsKey(sum - k) && (lengthSubArray < i- sumPos.get(sum -k))) {
               lengthSubArray = i - sumPos.get(sum-k).intValue();
               newLastPos = i;
           }
        }
        System.out.println("Max sub array have length " + lengthSubArray);
        for (i= newLastPos-lengthSubArray+1; i<= newLastPos; i++)
            System.out.println(a[i]);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i< n; i++)
            arr[i] = sc.nextInt();
        findSubArrayWithGivenSum(arr, k);
    }
}