package BOJ;

/* 
    오르막 수

*/

import java.io.*;
import java.util.*;

public class BOJ11057 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N+2][10];

        System.out.println(findDp(N+1, 0));
    }

    static int[][] dp;

    static int findDp(int n, int s){

        if (n == 1) {
            return 1;
        }

        if (dp[n][s] != 0) {
            return dp[n][s];
        }

        for(int i = s; i<=9; i++){
            dp[n][s] = (dp[n][s] +  findDp(n-1, i)) % 10007;
        }

        return dp[n][s] % 10007;
    }
}
