package boj;

/*
 * 불!
 */

import java.io.*;
import java.util.*;

public class BOJ4179 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];

        Queue<int[]> jihun = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();
        boolean[][] visit = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();

            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'J') {
                    jihun.add(new int[] {i, j});
                    map[i][j] = '.';
                    visit[i][j] = true;
                } else if (map[i][j] == 'F') {
                    fire.add(new int[] {i, j});
                }
            }
        }

        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};


        int count = 0;
        loop: while (true) {

            count++;

            int size = fire.size();

            while (size-- > 0) {
                int[] f = fire.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = f[0] + move[i][0];
                    int nc = f[1] + move[i][1];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] != '.') {
                        continue;
                    }

                    map[nr][nc] = 'F';
                    fire.add(new int[] {nr, nc});
                }
            }

            size = jihun.size();
            while (size-- > 0) {
                int[] j = jihun.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = j[0] + move[i][0];
                    int nc = j[1] + move[i][1];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                        System.out.println(count);
                        break loop;
                    }

                    if (visit[nr][nc] || map[nr][nc] != '.') {
                        continue;
                    }

                    visit[nr][nc] = true;
                    jihun.add(new int[] {nr, nc});

                }
            }

            if (jihun.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                break;
            }

        }

    }
}
