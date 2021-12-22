package BOJ;

/* 
    외판원 순회 

*/

import java.io.*;
import java.util.*;

public class BOJ2098 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        dp = new int[N][(1 << N)];

        INF = 20000000;
        Arrays.fill(dp[0], INF);
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(travel(0, 1));

    }

    static int N, INF;
    static int[][] map;
    static int[][] dp; // i도시에 있고, j비트에 포함된 도시들을 방문했을 때, 남은 도시 방문의 최소비용

    static int travel(int now, int visit) {

        if (visit == (1 << N) - 1) {
            if (map[now][0] == 0) {
                return INF;
            }
            return map[now][0];
        }
        
        if (dp[now][visit] != INF) {
            return dp[now][visit];
        }

        for (int i = 0; i < N; i++) {
            if (map[now][i] == 0 || (visit & (1 << i)) != 0) {
                continue;
            }

            dp[now][visit] = Math.min(dp[now][visit], travel(i, visit | (1 << i)) + map[now][i]);
        }

        return dp[now][visit];
    }
}
