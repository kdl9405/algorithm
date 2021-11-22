package BOJ;

/* 
    2048 (Easy)

*/

import java.io.*;
import java.util.*;

public class BOJ12100 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (N == 1) {
            System.out.println(board[0][0]);
        } else {

            max = 0;
            findMax(0, board);

            System.out.println(max);
        }

    }

    static int N;
    static int max;

    static void findMax(int depth, int[][] board) {

        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
            return;
        }

        findMax(depth + 1, move(0, board));
        findMax(depth + 1, move(1, board));
        findMax(depth + 1, move(2, board));
        findMax(depth + 1, move(3, board));
    }

    static int[][] move(int d, int[][] board) {

        switch (d) {
        case 0:

            for (int i = 0; i < N; i++) {

                for (int j = 0; j < N - 1; j++) {
                    if (board[i][j] == 0 || board[i][j] == board[i][j + 1]) {
                        board[i][j] += board[i][j + 1];
                        board[i][j + 1] = 0;
                    }
                }
            }

            break;

        case 1:

            for (int i = 0; i < N; i++) {

                for (int j = N - 1; j > 0; j--) {
                    if (board[i][j] == 0 || board[i][j] == board[i][j-1]) {
                        board[i][j] += board[i][j - 1];
                        board[i][j - 1] = 0;
                    }
                }
            }

            break;
        case 2:

            for (int j = 0; j < N; j++) {

                for (int i = N - 1; i > 0; i--) {

                    if (board[i][j] == 0 || board[i - 1][j] == board[i][j]) {
                        board[i][j] += board[i - 1][j];
                        board[i - 1][j] = 0;
                    }
                }
            }

            break;
        case 3:

            for (int j = 0; j < N; j++) {

                for (int i = 0; i < N - 1; i++) {
                    if (board[i][j] == 0 || board[i][j] == board[i + 1][j]) {
                        board[i][j] += board[i + 1][j];
                        board[i + 1][j] = 0;
                    }

                }
            }

            break;
        }
        
        return board;
    }
}
