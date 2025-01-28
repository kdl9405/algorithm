package boj;

import java.io.*;
import java.util.*;

/*
 * 플로이드 2
 */
public class BOJ11780 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] roads = new int[n + 1][n + 1];
        int[][] routes = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(roads[i], INF);
            Arrays.fill(routes[i], -1);
        }

        int m = Integer.parseInt(br.readLine());

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (roads[a][b] > c) {
                roads[a][b] = c;
                routes[a][b] = b;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (roads[i][j] > roads[i][k] + roads[k][j]) {
                        roads[i][j] = roads[i][k] + roads[k][j];
                        routes[i][j] = routes[i][k];
                    }
                }
            }
        }

        StringBuilder distance = new StringBuilder();
        StringBuilder route = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j || roads[i][j] == INF) {
                    distance.append(0 + " ");
                    route.append(0 + "\n");
                } else {
                    distance.append(roads[i][j] + " ");

                    List<Integer> list = new ArrayList<>();

                    int before = i;
                    while (before != j) {
                        list.add(before);
                        before = routes[before][j];
                    }
                    list.add(j);

                    route.append(list.size() + " ");

                    for (int k : list) {
                        route.append(k + " ");
                    }
                    route.append("\n");

                }
            }
            distance.append("\n");
        }

        System.out.println(distance.toString().trim());

        System.out.println(route.toString().trim());
    }

    static int INF = 10000001;
}
