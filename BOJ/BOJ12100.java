package boj;

/*
 * 2048 (Easy)
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ12100 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
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
            findMax(0);

            System.out.println(max);
        }


    }

    static int N;
    static int max;
    static int[][] board;

    static void findMax(int depth) {

        if (depth == 5) {

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    max = Math.max(max, board[i][j]);

                }
            }

            return;
        }

        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            copy[i] = board[i].clone();
        }

        for (int i = 0; i < 4; i++) {
            move(i);
            findMax(depth + 1);

            for (int j = 0; j < N; j++) {
                board[j] = copy[j].clone();
            }
        }

    }

    static int[][] move(int d) {

        switch (d) {
            case 0:

                for (int i = 0; i < N; i++) {

                    int index = 0;
                    int block = 0;

                    for (int j = 0; j < N; j++) {

                        if (board[i][j] == 0) {
                            continue;
                        }

                        if (board[i][j] == block) {
                            board[i][index - 1] = block * 2;
                            block = 0;
                            board[i][j] = 0;
                        } else {
                            block = board[i][j];
                            board[i][j] = 0;
                            board[i][index] = block;
                            index++;
                        }

                        // if (board[i][j] == 0 || board[i][j] == board[i][j + 1]) {
                        // board[i][j] += board[i][j + 1];
                        // board[i][j + 1] = 0;
                        // }
                    }
                }

                break;

            case 1:

                for (int i = 0; i < N; i++) {

                    int index = N - 1;
                    int block = 0;

                    for (int j = N - 1; j >= 0; j--) {

                        if (board[i][j] == 0) {
                            continue;
                        }

                        if (board[i][j] == block) {
                            board[i][index + 1] = block * 2;
                            block = 0;
                            board[i][j] = 0;
                        } else {
                            block = board[i][j];
                            board[i][j] = 0;
                            board[i][index] = block;
                            index--;
                        }

                        // if (board[i][j] == 0 || board[i][j] == board[i][j - 1]) {
                        // board[i][j] += board[i][j - 1];
                        // board[i][j - 1] = 0;
                        // }
                    }
                }

                break;
            case 2:

                for (int j = 0; j < N; j++) {

                    int index = N - 1;
                    int block = 0;

                    for (int i = N - 1; i >= 0; i--) {

                        if (board[i][j] == 0) {
                            continue;
                        }

                        if (board[i][j] == block) {
                            board[index + 1][j] = block * 2;
                            block = 0;
                            board[i][j] = 0;
                        } else {
                            block = board[i][j];
                            board[i][j] = 0;
                            board[index][j] = block;
                            index--;
                        }


                        // if (board[i][j] == 0 || board[i - 1][j] == board[i][j]) {
                        // board[i][j] += board[i - 1][j];
                        // board[i - 1][j] = 0;
                        // }
                    }
                }

                break;
            case 3:

                for (int j = 0; j < N; j++) {

                    int index = 0;
                    int block = 0;

                    for (int i = 0; i < N; i++) {

                        if (board[i][j] == 0) {
                            continue;
                        }

                        if (board[i][j] == block) {
                            board[index - 1][j] = block * 2;
                            block = 0;
                            board[i][j] = 0;
                        } else {
                            block = board[i][j];
                            board[i][j] = 0;
                            board[index][j] = block;
                            index++;
                        }

                        // if (board[i][j] == 0 || board[i][j] == board[i + 1][j]) {
                        // board[i][j] += board[i + 1][j];
                        // board[i + 1][j] = 0;
                        // }

                    }
                }

                break;
        }

        return board;
    }

}
