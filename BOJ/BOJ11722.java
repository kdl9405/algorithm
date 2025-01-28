package boj;

/*
 * 가장 긴 감소하는 부분 수열
 * 
 * 메모라이즈
 */

import java.io.*;
import java.util.*;

public class BOJ11722 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[j] <= A[i]) {
                    dp[j] = A[i];
                    System.out.println("break " + j);
                    break;
                }
            }

            for (int x = 0; x < N; x++) {
                System.out.print(dp[x] + " ");

            }
            System.out.println();
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            System.out.println(dp[i]);
            if (dp[i] > 0) {
                max++;
            }
        }

        System.out.println(max);

    }
}
