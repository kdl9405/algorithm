package boj;

/*
 * 곡예 비행
 * 
 * 1. 해당 좌표까지 상승으로 얻을 수 있는 최대 값 2. + 해당 좌표부터 하강으로 얻을 수 있는 최대 값
 * 
 * 
 * 
 * !! 시간초과 !!
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ21923_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        up(N - 1, 0, board[N - 1][0]);

        System.out.println(max);

    }

    static int N, M;
    static int[][] board;
    static int max = -3000 * 10000;

    static void up(int r, int c, int p) {

        if (r > 0) {
            up(r - 1, c, p + board[r - 1][c]);
        }

        if (c < M - 1) {
            up(r, c + 1, p + board[r][c + 1]);
        }

        if (r < N - 1 && c < M) {
            down(r, c, p + board[r][c]);
        }

    }

    static void down(int r, int c, int p) {


        if (r == N - 1 && c == M - 1) {

            max = Math.max(max, p);
            return;
        }

        if (r < N - 1) {
            down(r + 1, c, p + board[r + 1][c]);
        }

        if (c < M - 1) {
            down(r, c + 1, p + board[r][c + 1]);
        }

    }

}
