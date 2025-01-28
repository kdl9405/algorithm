package boj;

import java.io.*;
import java.util.*;


/*
 * 줄세우기
 */

public class BOJ2631 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n]; // i번째 막지막일 때, 만들 수 있는 증가하는 순열의 크기
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(n - max);

    }
}
