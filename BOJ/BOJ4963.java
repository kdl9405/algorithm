package BOJ;

import java.io.*;
import java.util.*;

/* 
    섬의 개수

    BFS 192ms
*/

public class BOJ4963 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            visit = new boolean[h][w];

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        count++;
                        bfs(i, j);
                    }
                }
            }

            sb.append(count).append("\n");

        }
        System.out.println(sb.toString().trim());

    }

    static int w, h;
    static int[][] map;
    static boolean[][] visit;
    static int[][] d = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

    static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { x, y });
        visit[x][y] = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int q = 0; q < size; q++) {
                int[] now = queue.poll();

                for (int i = 0; i < 8; i++) {
                    int nx = now[0] + d[i][0];
                    int ny = now[1] + d[i][1];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w) {
                        if (map[nx][ny] == 1 && !visit[nx][ny]) {
                            visit[nx][ny] = true;
                            queue.offer(new int[] { nx, ny });
                        }
                    }
                }
            }
        }
    }
}
