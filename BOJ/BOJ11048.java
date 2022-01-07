package BOJ;

/* 
    이동하기
*/

import java.io.*;
import java.util.*;

public class BOJ11048 {

    public static void main(String[] args) throws IOException {

        inputAndDp();

        System.out.println(dp[N][M]);

    }

    static int N, M;
    static int[][] dp;

    static void inputAndDp() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] += Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1]));
            }
        }

    }
}
