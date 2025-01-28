package boj;

/*
 * 미로만들기
 */

import java.io.*;
import java.util.*;

public class BOJ2665_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        boolean[][] visit = new boolean[n][n];

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

            if (visit[now[0]][now[1]]) {
                continue;
            }

            visit[now[0]][now[1]] = true;

            for (int i = 0; i < 4; i++) {
                int x = now[0] + move[i][0];
                int y = now[1] + move[i][1];

                if (x < 0 || x >= n || y < 0 || y >= n) {
                    continue;
                }

                if (map[x][y] == '0') {
                    pq.add(new int[] {x, y, now[2] + 1});

                } else {
                    pq.add(new int[] {x, y, now[2]});

                }
            }
        }
    }

    public static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
}
