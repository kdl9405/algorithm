package BOJ;

import java.io.*;
import java.util.*;

/* 
    치즈
*/
public class BOJ2638 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];
        cheese = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {

                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    paper[i][j] = 2;
                    cheese.add(new int[] { i, j });
                }
            }
        }

        int time = 0;
        while (!cheese.isEmpty()) {

            checkAir();

            int size = cheese.size();
            while (size-- > 0) {
                int[] now = cheese.poll();
                int side = 0;
                for (int i = 0; i < 4; i++) {
                    int x = now[0] + dx[i];
                    int y = now[1] + dy[i];

                    if (x >= 0 && x < n && y >= 0 && y < m) {
                        if (paper[x][y]+1 == paper[now[0]][now[1]]) {
                            side++;
                        }
                    }
                }
                if (side < 2) {
                    paper[now[0]][now[1]]++;
                    cheese.add(now);
                }
            }

            time++;

            // StringBuilder sb = new StringBuilder();
            // for (int i = 0; i < n; i++) {
            //     for (int j = 0; j < m; j++) {
            //         sb.append(paper[i][j] + " ");
            //     }
            //     sb.append("\n");
            // }
            // System.out.println(sb.toString());

        }

        System.out.println(time);

    }

    static int n, m;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int[][] paper;
    static Queue<int[]> cheese;

    static void checkAir() {
        int t = ++paper[0][0];

        boolean[][] visit = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        visit[0][0] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if (x >= 0 && x < n && y >= 0 && y < m) {
                    if (paper[x][y] <= t && !visit[x][y]) {
                        paper[x][y] = t;
                        visit[x][y] = true;
                        queue.offer(new int[] { x, y });
                    }
                }
            }
        }
        return;
    }

}
