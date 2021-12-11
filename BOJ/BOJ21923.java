package BOJ;

/* 
    곡예 비행

    1. 해당 좌표까지 상승으로 얻을 수 있는 최대 값 
    2.  + 해당 좌표부터 하강으로 얻을 수 있는 최대 값

*/

import java.io.*;
import java.util.*;

public class BOJ21923 {

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

        upDP = new int[N][M];
        downDP = new int[N][M];

        upVisit = new boolean[N][M];
        downVisit = new boolean[N][M];

        int max = findDown(N-1, M-1);

        // for(int i = 0; i<N; i++){
        //     for(int j = 0; j<M; j++){
        //      //   max = Math.max(max,findUP(i, j) +findDown(i, j));
        //         System.out.println("!! " +findDown(i, j));
        //     }
        // }

        System.out.println(upDP[0][0] + " "+downDP[0][0]);

        System.out.println(max);

    }

    static int N, M;
    static int[][] board;
    static int INF = -40000000;
    static int[][] upDP;
    static int[][] downDP;
    static boolean[][] upVisit; 
    static boolean[][] downVisit;

    static int findUP(int r, int c) {

        // if (r > N - 1 || c < 0) {
        // return INF;
        // }

        if (upVisit[r][c]) {
            return upDP[r][c];
        }
        upVisit[r][c] = true;

        if (r == N - 1 && c == 0) {
            return upDP[r][c] = board[N - 1][0];
        }

        if (r == N - 1) {
            return upDP[r][c] = findUP(r, c - 1) + board[r][c];
        }

        if (c == 0) {
            return upDP[r][c] = findUP(r + 1, c) + board[r][c];
        }

        return upDP[r][c] = Math.max(findUP(r + 1, c), findUP(r, c - 1)) + board[r][c];
    }

    static int findDown(int r, int c) {

        // if (r < 0 || c < 0) {
        //     return INF;
        // }

        if (downVisit[r][c]) {
            return downDP[r][c];
        }

        downVisit[r][c] = true;

        if (r == 0 && c == 0) {
            return downDP[r][c] = findUP(0,0)+board[0][0];
        }

        if (r == 0) {
            return downDP[r][c] = Math.max(findUP(r, c), findDown(r, c - 1)) + board[r][c];
        }

        if (c == 0) {
            return downDP[r][c] = Math.max(findUP(r, c), findDown(r - 1, c)) + board[r][c];
        }
        

        return downDP[r][c] = Math.max(findUP(r, c), Math.max(findDown(r - 1, c), findDown(r, c - 1))) + board[r][c];

    }

}
