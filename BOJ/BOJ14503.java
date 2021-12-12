package BOJ;

/* 
    로봇 청소기

 */

import java.io.*;
import java.util.*;

public class BOJ14503 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] clean = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 1;

        loop: while (true) {

            clean[r][c] = true;

            for (int i = 3; i >= 0; i--) {
                int nr = r + dr[(d + i) % 4];
                int nc = c + dc[(d + i) % 4];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    continue;
                }
                if (clean[nr][nc] || map[nr][nc] == 1) {
                    continue;
                }

                r = nr;
                c = nc;
                d = (d + i) % 4;
                count++;
                continue loop;
            }

            r -= dr[d];
            c -= dc[d];

            if (r < 0 || r>=N || c<0 || c>=M || map[r][c] == 1) {
                break;
            }

        }

        System.out.println(count);

    }

    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
}
