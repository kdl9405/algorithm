package boj;

import java.io.*;
import java.util.*;

public class BOJ14940 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        distance = new int[n][m];

        int x = -1;
        int y = -1;

        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], -1);

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (x == -1) {
                    if (map[i][j] == 2) {
                        x = i;
                        y = j;
                    }
                }

                if (map[i][j] == 0) {
                    distance[i][j] = 0;
                }
            }
        }

        fillDistanceMap(x, y);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result.append(distance[i][j]);
                if (j < m - 1) {
                    result.append(" ");
                }
            }
            result.append("\n");
        }

        System.out.println(result.toString());
    }

    static int n, m;
    static int[][] map;
    static int[][] distance;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void fillDistanceMap(int x, int y) {

        Queue<int[]> queue = new ArrayDeque<>();
        distance[x][y] = 0;
        queue.add(new int[] {x, y});

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            for (int[] d : dir) {
                int nx = current[0] + d[0];
                int ny = current[1] + d[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 0
                        && distance[nx][ny] == -1) {
                    distance[nx][ny] = distance[current[0]][current[1]] + 1;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
}
