package boj;

/*
 * 자리배정
 */

import java.io.*;
import java.util.*;

public class BOJ10157 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        if (K > C * R) {
            System.out.println(0);
            return;
        }

        int x = 1;
        int y = 1;

        boolean[][] visit = new boolean[R + 1][C + 1];

        int d = 0;
        while (K-- > 1) {

            visit[y][x] = true;

            int nx = x + move[d][1];
            int ny = y + move[d][0];

            if (ny > R || ny < 1 || nx > C || nx < 1 || visit[ny][nx]) {
                d = (d + 1) % 4;
                nx = x + move[d][1];
                ny = y + move[d][0];
            }

            x = nx;
            y = ny;
        }

        System.out.println(x + " " + y);
    }

    static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
}
