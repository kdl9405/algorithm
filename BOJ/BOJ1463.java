package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {

    static int[] dp;

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        System.out.println(countDP(n));

        
    }

    static int countDP (int n){

        if (n == 1) {
            return 0;
        }
        if (n == 2 || n == 3) {
            return 1;
        }
        
        if (dp[n] == 0) {

            dp[n] = Integer.MAX_VALUE;

            if (n % 2 == 0) {
                dp[n] = Math.min(countDP(n/2), dp[n]);
            }

            if (n % 3 == 0) {
                dp[n] = Math.min(countDP(n/3), dp[n]);
            }

            dp[n] = Math.min(dp[n], countDP(n-1));

            dp[n] +=1;

        }
       
        return dp[n];
    }
}
