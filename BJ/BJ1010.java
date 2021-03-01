package BJ;

import java.util.*;
import java.io.*;

/* 
    다리 놓기
*/
public class BJ1010 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        dp = new int[30][30];

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(findDP(n, m)).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    static int[][] dp;
    static int count;

    static int findDP(int n, int m){

        if (n == 0) {
            return 1;
        }

        if (n == m) {
            return 1;
        }
        
        if(dp[n][m] != 0){
            return dp[n][m];
        }

        
        for(int i = m-1; i>=n-1; i--){
            dp[n][m] += findDP(n-1, i);
        }
        
        return dp[n][m];
    }
}
