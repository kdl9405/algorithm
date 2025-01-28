package boj;

import java.io.*;
import java.util.*;

/**
 * 비밀 모임
 */
public class BOJ13424 {

    static int INF = 5000000;
    static int N, M;
    static int[][] dist;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dist = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                Arrays.fill(dist[i], INF);
                dist[i][i] = 0;
            }

            while (M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                dist[a][b] = d;
                dist[b][a] = d;
            }

            int K = Integer.parseInt(br.readLine());
            int[] friends = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                friends[i] = Integer.parseInt(st.nextToken());
            }


            Floyd_Warshall();

            int room = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {
                int d = 0;
                for (int friend : friends) {
                    d += dist[i][friend];
                }

                if (min > d) {
                    min = d;
                    room = i;
                }
            }

            sb.append(room + "\n");
        }

        System.out.println(sb.toString().trim());

    }

    static void Floyd_Warshall() {

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return;

    }

}
