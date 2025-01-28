package boj;

/*
 * 다리 만들기
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ2146 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        numbering();

        int distance = bridge();

        System.out.println(distance);

    }

    static int N;
    static int[][] map;
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> queue;

    static void findIsland(int r, int c, int num) {

        map[r][c] = num;
        queue.add(new int[] {r, c, num});

        for (int i = 0; i < 4; i++) {
            int nr = r + d[i][0];
            int nc = c + d[i][1];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 1) {
                continue;
            }

            findIsland(nr, nc, num);
        }

    }

    static void numbering() {
        queue = new LinkedList<>();

        int num = 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    findIsland(i, j, num++);
                }
            }
        }
    }

    static int bridge() {

        int[][] visit = new int[N][N];

        int count = 0;

        loop: while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] now = queue.poll();


                for (int i = 0; i < 4; i++) {
                    int nr = now[0] + d[i][0];
                    int nc = now[1] + d[i][1];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                        continue;
                    }

                    if (map[nr][nc] == now[2]) {
                        continue;
                    }
                    if ((visit[nr][nc] | (1 << now[2])) == visit[nr][nc]) {
                        continue;
                    }
                    visit[nr][nc] |= 1 << now[2];

                    if (map[nr][nc] != 0) {
                        break loop;
                    }
                    queue.add(new int[] {nr, nc, now[2]});
                }
            }

            count++;
        }

        return count;
    }
}
