package basic;

import java.util.*;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        dp = new int[n+1];

        System.out.println(findFibo(n));
    }

    static int[] dp;

    static int findFibo(int n){
        
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = findFibo(n-1) + findFibo(n-2);
        return dp[n];
    }

}
