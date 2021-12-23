package BOJ;

/* 
    욕심쟁이 판다

*/

import java.io.*;
import java.util.*;

public class BOJ1397 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        forest = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                answer = Math.max(answer, dfs(i, j));

            }
        }

        System.out.println(answer);

    }

    static int N, answer;
    static int[][] forest;
    static int[][] dp;
    static int[][] move = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    static int dfs(int i, int j) {

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int cnt = 0;

        for (int d = 0; d < 4; d++) {
            int x = i + move[d][0];
            int y = j + move[d][1];

            if (x<0 || x>=N || y<0 || y>=N || forest[i][j] >= forest[x][y]) {
                continue;
            }

            cnt = Math.max(cnt, dfs(x, y));
        }

        return dp[i][j] = cnt+1;
    }

}
