package BOJ;

import java.io.*;
import java.util.*;

/* 
    그림
*/

public class BOJ1926 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split(" ");
        }

        int count = 0;
        max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j].equals("1") && !visit[i][j]) {
                    count++;
                    BFS(i, j);
                }
            }
        }
          

        System.out.println(count + "\n" + max);

    }

    static int N, M;
    static String[][] map;
    static boolean[][] visit;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static int max;

    static void BFS(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });
        visit[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny].equals("1") && !visit[nx][ny]) {
                        visit[nx][ny] = true;
                        queue.add(new int[] { nx, ny });
                        count++;
                    }
                }
            }
        }

        max = Integer.max(max, count);

    }
}
