package boj;

import java.io.*;
import java.util.Stack;

/*
 * LCS 2
 */
public class BOJ9252 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int size = dp[A.length][B.length];
        System.out.println(size);

        if (size != 0) {

            Stack<Character> stack = new Stack<>();

            int j = B.length;
            int i = A.length;

            while (size > 0) {
                if (dp[i][j] == dp[i - 1][j]) {
                    i--;
                } else if (dp[i][j] == dp[i][j - 1]) {
                    j--;
                } else {
                    stack.push(A[i - 1]);
                    i--;
                    j--;
                    size--;
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            System.out.println(sb.toString());

        }

    }
}
