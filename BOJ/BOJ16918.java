package BOJ;

/**
 * 봄버맨
 */

import java.io.*;
import java.util.*;

public class BOJ16918 {

    public static void main(String[] args) throws IOException {

        new BOJ16918().solution();
   }

    void solution() throws IOException {

        init();

        simulation();

        System.out.println(answer.toString());

    }

    int R, C, N;
    char[][] map;
    int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    StringBuilder answer = new StringBuilder();

    void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

    }

    void simulation() {

        if (N % 2 == 0) {

            Arrays.fill(map[0], 'O');
            String line = new String(map[0]);

            for (int i = 0; i < R; i++) {
                answer.append(line).append("\n");
            }

        } else {

            boolean[][] bomb = new boolean[R][C];

            int T = 0;
            while (T++ < N) {

                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {

                        if (!bomb[i][j]) {
                            continue;
                        }

                        map[i][j] = '.';
                        bomb[i][j] = false;

                        for (int d = 0; d < 4; d++) {
                            int r = i + dir[d][0];
                            int c = j + dir[d][1];

                            if (r >= 0 && r < R && c >= 0 && c < C) {
                                map[r][c] = '.';
                            }
                        }
                    }
                }

                if (T++ >= N) {
                    break;
                }

                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == 'O') {
                            bomb[i][j] = true;
                        } else {
                            map[i][j] = 'O';
                        }
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                answer.append(new String(map[i])).append("\n");
            }
        }

    }
}