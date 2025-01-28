package boj;

import java.io.*;

/*
 * 공통 부분 문자열
 */
public class BOJ5582 {
    public static void main(String[] args) throws IOException {

        new BOJ5582().solution();
    }

    void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int[][] dp = new int[A.length + 1][B.length + 1];

        int maxLength = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {

                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;

                    maxLength = Math.max(maxLength, dp[i + 1][j + 1]);
                }
            }
        }

        System.out.println(maxLength);
    }
}
