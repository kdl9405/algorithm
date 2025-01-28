package boj;

/*
 * 빙산
 */

import java.io.*;
import java.util.*;

public class BOJ2573_copy {

    static int N, M;
    static int[][] map;
    static Queue<Iceberg> queue;
    static Queue<Iceberg> melt;
    static boolean[][] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        queue = new LinkedList<>();
        melt = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    queue.offer(new Iceberg(i, j, map[i][j]));
                }
            }
        }

        int year = 0;

        while (true) {

            int size = queue.size();
            int count = 0;

            visit = new boolean[N][M];
            count = 0;

            while (size-- > 0) {
                Iceberg ice = queue.poll();

                if (visit[ice.x][ice.y]) {
                    continue;
                }

                check(ice.x, ice.y);
                count++;


            }

            if (count >= 2) {
                break;
            }

            // 녹음
            while (!melt.isEmpty()) {
                Iceberg ice = melt.poll();

                map[ice.x][ice.y] = 0;
            }

            if (queue.isEmpty()) {
                year = 0;
                break;
            }


            year++;

        }

        System.out.println(year);

    }

    static void check(int x, int y) {

        visit[x][y] = true;

        int near = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }

            if (map[nx][ny] == 0) {
                near++;
            } else if (!visit[nx][ny]) {
                check(nx, ny);
            }
        }

        if (map[x][y] <= near) {
            melt.offer(new Iceberg(x, y, 0));
        } else {
            queue.offer(new Iceberg(x, y, map[x][y] - near));
            map[x][y] = map[x][y] - near;
        }

        return;

    }

    private static class Iceberg {

        int x;
        int y;
        int h;

        public Iceberg(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }

}
