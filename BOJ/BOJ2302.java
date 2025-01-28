package boj;

/*
 * 극장 좌석
 * 
 */

import java.io.*;

public class BOJ2302 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        int answer = 1;
        int left = 0;
        while (M-- > 0) {
            int vip = Integer.parseInt(br.readLine());

            answer *= (dp[vip - left - 1]);
            left = vip;
        }

        answer *= (dp[N - left]);

        System.out.println(answer);

    }

}
