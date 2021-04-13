package BOJ;

import java.io.*;
import java.util.*;

/* 
    팰린드롬 만들기
*/

public class BOJ1695 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n][n]; // i~j까지의 수열을 팰린드롬으로 만들 때 끼워넣을 수 

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findDP(0, n-1));

    }

    static int[] arr;
    static int[][] dp;

    static int findDP(int from, int to){

        if (from >=to) {
            return 0;
        }

        if (dp[from][to] != 0) {
            return dp[from][to];
        }   

        dp[from][to] = 200000;

        if (arr[from] == arr[to]) {
            dp[from][to] = findDP(from+1, to-1);
        }else{
            dp[from][to] = Math.min(findDP(from+1, to), findDP(from, to-1))+1;
        }



        return dp[from][to];
    }
}
