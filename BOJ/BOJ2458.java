package BOJ;

/* 
    키 순서

*/

import java.io.*;
import java.util.*;

public class BOJ2458 {

    public static void main(String[] args) throws IOException {

        new BOJ2458().solution();
    }

    void solution() throws IOException {

        init();

        floyd();

        System.out.println(getCount());
    }

    int N, M;
    int[][] info;
    int INF = 1000;

    void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        info = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(info[i], INF);
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            info[a][b] = 1;
        }
    }

    void floyd() {

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (info[i][j] > info[i][k] + info[k][j]) {
                        info[i][j] = info[i][k] + info[k][j];
                    }
                }
            }
        }
    }

    int getCount() {

        int count = 0;

        for (int i = 1; i <= N; i++) {

            boolean isPossible = true;
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                }
                if (info[i][j] == INF && info[j][i] == INF) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                count++;
            }
        }

        return count;
    }
}
