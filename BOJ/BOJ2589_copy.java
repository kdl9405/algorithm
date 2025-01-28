package boj;

/*
 * 보물섬
 */

import java.io.*;
import java.util.*;

public class BOJ2589_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        distance = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'L') {
                    distance = Math.max(distance, BFS(i, j));
                }
            }
        }

        System.out.println(distance);

    }

    static int R, C, distance;
    static char[][] map;
    static int[][] visit;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int BFS(int r, int c) {

        visit = new int[R][C];

        int d = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r, c});
        visit[r][c] = 1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            d = Math.max(d, visit[now[0]][now[1]]);

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + move[i][0];
                int nc = now[1] + move[i][1];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                    continue;
                }

                if (map[nr][nc] == 'W' || visit[nr][nc] != 0) {
                    continue;
                }

                visit[nr][nc] = visit[now[0]][now[1]] + 1;
                queue.add(new int[] {nr, nc});

            }
        }

        return d - 1;
    }

}
