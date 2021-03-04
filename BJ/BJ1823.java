package BJ;

import java.io.*;
import java.util.*;

/* 
    수확 
*/

public class BJ1823 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n+1][n+1];

        System.out.println(findDP(1, n));
       
    }

    static int n;
    static int[] arr;   
    static int[][] dp; // i에서 j가 남아있을 때의 최대 수확량

    static int findDP(int start, int end){
        
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        int index = n-(end-start);

        dp[start][end] = Math.max(findDP(start+1, end)+(arr[start]*index), findDP(start, end-1)+(arr[end]*index));

        return dp[start][end];
    }
   

}
