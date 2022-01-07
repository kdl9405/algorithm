package BOJ;

/* 
    이동하기
*/

import java.io.*;
import java.util.*;

public class BOJ11048_copy {

    public static void main(String[] args) throws IOException {

        init();

        System.out.println(findDP(N, M));

    }

    static int N, M;
    static int[][] maze;
    static int[][] dp;

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 1; j <= M; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    static int findDP(int r, int c) {

        if (r <= 0 || r > N || c <= 0 || c > M) {
            return 0;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        return dp[r][c] = maze[r][c] + (Math.max(findDP(r - 1, c), Math.max(findDP(r, c - 1), findDP(r - 1, c - 1))));
    }
}
