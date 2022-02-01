package BOJ;

/**

기타리스트

*/

import java.io.*;
import java.util.*;

public class BOJ1495_copy {

    public static void main(String[] args) throws IOException {

        new BOJ1495_copy().solution();
    }

    void solution() throws IOException {

        init();

        int answer = bottomUP();

        System.out.println(answer);

    }

    int N, S, M;
    int[] V;
    boolean[][] dp;

    void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        V = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;
    }

    int bottomUP() {

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= M; j++) {
                if (!dp[i - 1][j]) {
                    continue;
                }

                if (j + V[i] <= M) {
                    dp[i][j + V[i]] = true;
                }

                if (j - V[i] >= 0) {
                    dp[i][j - V[i]] = true;
                }
            }
        }

        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                return i;
            }
        }

        return -1;
    }

}