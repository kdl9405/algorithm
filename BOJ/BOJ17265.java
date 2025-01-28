package boj;

import java.io.*;

/*
 * 나의 인생에는 수학과 함께
 * 
 * // 완전탐색
 */
public class BOJ17265 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new String[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().split(" ");
        }

        dp = new int[N][N][2];

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        find(0, 0, Integer.parseInt(map[0][0]), ' ');

        System.out.println(max + " " + min);

    }

    static int N;
    static String[][] map;
    static int[][][] dp;

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    static int min, max;

    static void find(int x, int y, int v, char f) {

        if (x == N - 1 && y == N - 1) {
            min = Math.min(min, v);
            max = Math.max(max, v);

            return;
        }

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < N && ny < N) {

                if (map[nx][ny].charAt(0) == '+') {

                    find(nx, ny, v, '+');

                } else if (map[nx][ny].charAt(0) == '-') {
                    find(nx, ny, v, '-');

                } else if (map[nx][ny].charAt(0) == '*') {
                    find(nx, ny, v, '*');

                } else {

                    int num = Integer.parseInt(map[nx][ny]);

                    switch (f) {
                        case '+':

                            find(nx, ny, v + num, f);

                            break;

                        case '-':

                            find(nx, ny, v - num, f);

                            break;
                        case '*':

                            find(nx, ny, v * num, f);
                            break;

                    }

                }
            }
        }

        return;

    }
}
