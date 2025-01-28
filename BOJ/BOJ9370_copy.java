package boj;

/*
 * 미확인 도착지
 * 
 * 1. 각 교차로 간의 최단거리를 2차원 배열로 정의하고 산출. 2. ([s][g] + [g][h] + [h][d] <= [s][d]) || ([s][h] + [h][g] +
 * [g][d] <= [s][d]) 면 출력.
 * 
 * => 시간초과 => 최단거리를 구하는 부분.. 최적화...
 */

import java.io.*;
import java.util.*;

public class BOJ9370_copy {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            int[][] roads = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(roads[i], 5000001);
            }

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                roads[a][b] = d;
                roads[b][a] = d;
            }

            List<Integer> dest = new ArrayList<>();
            while (t-- > 0) {
                dest.add(Integer.parseInt(br.readLine()));
            }

            Collections.sort(dest);

            for (int k = 1; k <= n; k++) {
                for (int x = 1; x <= n; x++) {
                    if (x == k) {
                        continue;
                    }
                    for (int y = 1; y <= n; y++) {
                        if (y == x) {
                            continue;
                        }

                        if (roads[x][y] > roads[x][k] + roads[k][y]) {
                            roads[x][y] = roads[x][k] + roads[k][y];
                            roads[y][x] = roads[x][k] + roads[k][y];
                        }
                    }
                }
            }

            StringBuilder temp = new StringBuilder();
            for (int d : dest) {

                if ((roads[s][g] + roads[g][h] + roads[h][d] <= roads[s][d])
                        || (roads[s][h] + roads[h][g] + roads[g][d] <= roads[s][d])) {
                    temp.append(d + " ");

                }

            }

            sb.append(temp.toString().trim() + "\n");

        }

        System.out.println(sb.toString().trim());
    }
}
