package BOJ;

/* 
    알고스팟


*/

import java.io.*;
import java.util.*;

public class BOJ1261_copy {

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
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        queue.add(new int[] { 0, 0, 0 });

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            if (now[0] == N - 1 && now[1] == M - 1) {
                System.out.println(now[2]);
                break;
            }

            for (int i = 0; i < 4; i++) {

                int x = now[0] + move[i][0];
                int y = now[1] + move[i][1];

                while (true) {
                    if (x < 0 || x >= N || y < 0 || y >= M) {
                        break;
                    }
                    if (visit[x][y]) {
                        break;
                    }

                    visit[x][y] = true;

                    if (maze[x][y] == '1') {
                        queue.add(new int[] { x, y, now[2] + 1 });
                        break;
                    } else {
                        queue.add(new int[] { x, y, now[2] });
                    }

                    x += move[i][0];
                    y += move[i][1];

                }
            }

        }

    }

    static int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
}
