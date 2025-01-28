package boj;

/*
 * 미로만들기
 */

import java.io.*;
import java.util.*;

public class BOJ2665 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == '0') {
                    map[i][j] = true;
                }
            }
        }

        int[][] visit = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], n * n + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        pq.add(new int[] {0, 0, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[0] == n - 1 && now[1] == n - 1) {
                System.out.println(now[2]);
                break;
            }

            if (visit[now[0]][now[1]] <= now[2]) {
                continue;
            }

            visit[now[0]][now[1]] = now[2];

            for (int i = 0; i < 4; i++) {
                int x = now[0] + move[i][0];
                int y = now[1] + move[i][1];

                if (x < 0 || x >= n || y < 0 || y >= n) {
                    continue;
                }

                if (map[x][y]) {
                    if (visit[x][y] > now[2] + 1) {
                        pq.add(new int[] {x, y, now[2] + 1});
                    }
                } else {
                    if (visit[x][y] > now[2]) {
                        pq.add(new int[] {x, y, now[2]});
                    }
                }
            }
        }
    }

    public static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
}
