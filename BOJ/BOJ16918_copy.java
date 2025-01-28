package boj;

/**
 * 봄버맨
 */

import java.io.*;
import java.util.*;

public class BOJ16918_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (line[j] == 'O') {
                    map[i][j] = true;
                }
            }
        }

        StringBuilder answer = new StringBuilder();

        if (N % 2 == 0) {

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    answer.append("O");
                }
                answer.append("\n");
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

                        map[i][j] = false;
                        bomb[i][j] = false;

                        for (int d = 0; d < 4; d++) {
                            int r = i + dir[d][0];
                            int c = j + dir[d][1];

                            if (r >= 0 && r < R && c >= 0 && c < C) {
                                map[r][c] = false;
                            }
                        }
                    }
                }

                if (T++ >= N) {
                    break;
                }

                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j]) {
                            bomb[i][j] = true;
                        } else {
                            map[i][j] = true;
                        }
                    }
                }
            }

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    answer.append(map[i][j] ? "O" : '.');
                }
                answer.append("\n");
            }
        }

        System.out.println(answer.toString());
    }

    static boolean[][] map;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

}
