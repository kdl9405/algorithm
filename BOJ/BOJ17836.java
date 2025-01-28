package boj;

/*
 * 공주님을 구해라!
 */

import java.io.*;
import java.util.*;

public class BOJ17836 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][][] visit = new boolean[N + 1][M + 1][2];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 1, 0});
        visit[1][1][0] = true;

        int t = 0;
        while (t++ < T) {

            int size = queue.size();
            while (size-- > 0) {
                int[] now = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int x = now[0] + dir[i][0];
                    int y = now[1] + dir[i][1];

                    if (x == N && y == M) {
                        System.out.println(t);
                        return;
                    }

                    if (x < 1 || x > N || y < 1 || y > M || visit[x][y][now[2]]) {
                        continue;
                    }

                    if (now[2] == 0 && map[x][y] == 1) {
                        continue;
                    }

                    if (map[x][y] == 2) {
                        now[2] = 1;
                    }

                    visit[x][y][now[2]] = true;

                    queue.add(new int[] {x, y, now[2]});
                }

            }
        }

        System.out.println("Fail");

    }

    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
}
