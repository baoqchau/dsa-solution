/**
 * Created by bao on 9/12/17.
 * Problem: Sherlock and the Beast on Hackerrank
 * https://www.hackerrank.com/challenges/sherlock-and-the-beast
 */
import java.util.*;

public class sherlockAndTheBeast {

    static void solveProblem(int n) {
        if (n < 3) {
            System.out.println(-1);
        }
        else if (n % 3 == 0) {
            for (int i=0; i<n; i++) {
                System.out.print(5);
            }
            System.out.println();
        }
        else {
            int numOf3 = 0, numOf5;
            numOf5 = n;
            int i;
            while (numOf5 % 3 != 0) {
                numOf5--;
            }
            while (numOf5 >= 3) {
                if ((n - numOf5) % 5 ==0) {
                    numOf3 = n - numOf5;
                    break;
                }
                numOf5 -= 3;
            }
            if (numOf3 ==0) {
                if (n % 5 ==0) {
                    for (i=0; i<n; i++)
                        System.out.print(3);
                    System.out.println();
                }
                else
                    System.out.println(-1);
            }
            else {
                for (i=0; i < numOf5; i++)
                    System.out.print(5);
                for (i=0; i < numOf3; i++)
                    System.out.print(3);
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n;
        for (int i=0; i<t; i++) {
            n = sc.nextInt();
            solveProblem(n);
        }
    }
}
