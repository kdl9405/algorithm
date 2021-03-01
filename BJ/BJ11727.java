package BJ;

import java.io.*;
import java.util.*;

/**
 * 2×n 타일링 2
 */
public class BJ11727 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1]; 
        dp[0] = 1;
        dp[1] = 1;

        if (n>1) {
            for(int i = 2; i<=n; i++){
                dp[i] = (dp[i-1] + 2*(dp[i-2]))%10007;
            }
        }

        System.out.println(dp[n]);
    }
    
}