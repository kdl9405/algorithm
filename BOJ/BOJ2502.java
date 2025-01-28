package boj;

/*
 * 떡 먹는 호랑이
 */


import java.io.*;
import java.util.*;

public class BOJ2502 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[D + 1][2];

        dp[1][0] = 1;
        dp[2][1] = 1;

        for (int i = 3; i <= D; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        for (int i = 1; i <= K; i++) {
            if ((K - (dp[D][0] * i)) % dp[D][1] == 0) {

                System.out.println(i);
                System.out.println((K - (dp[D][0] * i)) / dp[D][1]);
                break;
            }
        }
    }
}
