package boj;

/*
 * 사다리 조작
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ15684 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H + 1][N + 1]; // 0 : 선없음 , 1 : 왼쪽으로 연결, 2 : 오른쪽으로 연결
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = 2;
            board[a][b + 1] = 1;

        }

        for (int i = 0; i <= 3; i++) {
            dfs(1, 0, i);

            if (count != 5) {
                break;
            }
        }

        if (count == 5) {
            count = -1;
        }

        System.out.println(count);

    }

    static int N, M, H;
    static int[][] board;
    static int count = 5;

    static void dfs(int h, int c, int line) {

        System.out.println(h + " " + c + " " + line);

        if (c >= count) {
            return;
        }

        if (c == line) {
            if (check()) {

                count = Math.min(count, c);
            }
            return;
        }


        for (int i = h; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (board[i][j] == 0 && board[i][j + 1] == 0) {
                    board[i][j] = 2;
                    board[i][j + 1] = 1;
                    dfs(i, c + 1, line);
                    board[i][j] = 0;
                    board[i][j + 1] = 0;
                }
            }
        }

    }

    static boolean check() {

        for (int i = 1; i <= N; i++) {

            int w = i;
            for (int h = 1; h <= H; h++) {
                if (board[h][w] == 2) {
                    w++;
                } else if (board[h][w] == 1) {
                    w--;
                }
            }
            if (w != i) {
                return false;
            }
        }

        return true;
    }

}
