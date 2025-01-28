package boj;

/*
 * 알고스팟
 */

import java.io.*;
import java.util.*;

public class BOJ1261 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] maze = new char[N][M];

        for (int i = 0; i < N; i++) {
            maze[i] = br.readLine().toCharArray();
        }

        boolean[][] visit = new boolean[N][M];
        visit[0][0] = true;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {0, 0, 0});

        while (!deque.isEmpty()) {

            int[] now = deque.pollFirst();

            if (now[0] == N - 1 && now[1] == M - 1) {
                System.out.println(now[2]);
                break;
            }

            for (int i = 0; i < 4; i++) {

                int x = now[0] + move[i][0];
                int y = now[1] + move[i][1];

                if (x < 0 || x >= N || y < 0 || y >= M || visit[x][y]) {
                    continue;

                }

                visit[x][y] = true;
                if (maze[x][y] == '1') {
                    deque.addLast(new int[] {x, y, now[2] + 1});
                } else {
                    deque.addFirst(new int[] {x, y, now[2]});
                }

            }

        }

    }

    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
}
