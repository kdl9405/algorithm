package boj;

/*
 * 빵집
 */

import java.io.*;
import java.util.*;

public class BOJ3109 {

    public static void main(String[] args) throws IOException {

        new BOJ3109().solution();
    }

    void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                if (line.charAt(j) == 'x') {
                    map[i][j] = true;
                }
            }
        }

        count = 0;
        for (int i = 0; i < R; i++) {
            findRoute(i, 0);
        }

        System.out.println(count);

    }

    int R, C;
    boolean[][] map;
    int count;

    boolean findRoute(int r, int c) {

        if (r < 0 || r >= R || c < 0 || c >= C || map[r][c]) {
            return false;
        }

        map[r][c] = true;

        if (c == C - 1) {
            count++;
            return true;
        }

        for (int i = 0; i < 3; i++) {
            if (findRoute(r - 1 + i, c + 1)) {
                return true;
            }
        }

        return false;

    }

}
