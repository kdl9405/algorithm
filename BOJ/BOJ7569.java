package boj;

import java.io.*;
import java.util.*;

public class BOJ7569 {

    static int[][][] tomato;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        tomato = new int[h][n][m];

        boolean check = false;

        Queue<Integer[]> queue = new LinkedList<>();

        for (int z = 0; z < h; z++) {
            for (int x = 0; x < n; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < m; y++) {
                    tomato[z][x][y] = Integer.parseInt(st.nextToken());
                    if (tomato[z][x][y] == 1) {
                        queue.offer(new Integer[] {z, x, y});
                    }
                    if (tomato[z][x][y] == 0) {
                        check = true;
                    }
                }
            }
        }

        if (!check) {
            System.out.println(0);
            System.out.close();
        }

        int day = 0;

        Queue<Integer[]> cloneQ = new LinkedList<>();

        while (true) {

            if (queue.isEmpty()) {
                break;
            }

            cloneQ = new LinkedList<>();

            while (!queue.isEmpty()) {
                Integer[] point = queue.poll();
                int x = point[1];
                int y = point[2];
                int z = point[0];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (tomato[z][nx][ny] == 0) {
                            tomato[z][nx][ny] = 1;
                            cloneQ.offer(new Integer[] {z, nx, ny});
                        }
                    }
                }
                if (z - 1 >= 0 && tomato[z - 1][x][y] == 0) {
                    tomato[z - 1][x][y] = 1;
                    cloneQ.offer(new Integer[] {z - 1, x, y});
                }
                if (z + 1 < h && tomato[z + 1][x][y] == 0) {
                    tomato[z + 1][x][y] = 1;
                    cloneQ.offer(new Integer[] {z + 1, x, y});
                }
            }
            day++;

            queue.addAll(cloneQ);

        }



        for (int z = 0; z < h; z++) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (tomato[z][x][y] == 0) {
                        System.out.println(-1);
                        System.out.close();
                    }
                }
            }

        }

        System.out.println(day - 1);
    }
}
