package boj;

import java.io.*;
import java.util.*;

/*
 * 운동
 */

public class BOJ1956 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] road = new int[V + 1][V + 1];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            road[a][b] = c;
        }

        int min = Integer.MAX_VALUE;

        for (int k = 1; k <= V; k++) {
            for (int a = 1; a <= V; a++) {

                if (k == a) {
                    continue;
                }

                for (int b = 1; b <= V; b++) {
                    if (road[a][k] != 0 && road[k][b] != 0) {
                        int cost = road[a][k] + road[k][b];

                        if (road[a][b] == 0 || road[a][b] > cost) {
                            road[a][b] = cost;
                        }
                    }
                }

                if (road[a][a] != 0) {
                    min = Math.min(min, road[a][a]);
                }
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}
