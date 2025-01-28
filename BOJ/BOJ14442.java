package boj;

/*
 * 벽 부수고 이동하기 2
 */

import java.io.*;
import java.util.*;

public class BOJ14442 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][][] map = new int[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j][0] = line.charAt(j - 1) == '1' ? 1 : 0;
                map[i][j][1] = -1;
            }
        }

        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {1, 1, K});

        int distance = 1;
        while (!queue.isEmpty()) {

            distance++;

            int size = queue.size();
            while (size-- > 0) {
                int[] now = queue.poll();
                if (map[now[0]][now[1]][1] > now[2]) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int x = now[0] + move[i][0];
                    int y = now[1] + move[i][1];

                    if (x == N && y == M) {
                        System.out.println(distance);
                        return;
                    }

                    if (x > 0 && x <= N && y > 0 && y <= M) {

                        if (map[x][y][0] == 1) {
                            if (now[2] > 0 && map[x][y][1] < now[2] - 1) {
                                map[x][y][1] = now[2] - 1;
                                queue.add(new int[] {x, y, now[2] - 1});
                            }
                        } else {
                            if (map[x][y][1] < now[2]) {
                                map[x][y][1] = now[2];
                                queue.add(new int[] {x, y, now[2]});
                            }
                        }
                    }
                }

            }
        }

        System.out.println(-1);

    }

    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
}
