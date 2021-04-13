package BOJ;

import java.util.*;
import java.io.*;

public class BOJ7576 {

    static int[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean check = false;
        loop: for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    check = true;
                    break loop;
                }
            }
        }
        if (!check) {
            System.out.println(0);
            System.out.close();
        }

        int day = 0;

        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    queue.offer(new Integer[] { i, j });
                }
            }
        }

        Queue<Integer[]> cloneQ = new LinkedList<>();

        while (true) {

            if (queue.isEmpty()) {
                break;
            }

            cloneQ = new LinkedList<>();

            while (!queue.isEmpty()) {
                int x = queue.peek()[0];
                int y = queue.peek()[1];
                queue.poll();

                visit[x][y] = true;

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (map[nx][ny] == 0) {
                            map[nx][ny] = 1;
                            cloneQ.offer(new Integer[] {nx,ny});
                        }
                    }
                }
            }
           
            day++;
            queue.addAll(cloneQ);

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    day = 0;
                }
            }
        }

        System.out.println(day - 1);

    }
}
