package boj;

import java.io.*;
import java.util.*;

/*
 * 별 찍기 - 11
 */
public class BOJ2448 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        board = new char[n][(n * 2) - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ' ');
        }

        draw(0, n - 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(new String(board[i]) + "\n");
        }

        System.out.println(sb.toString());


    }

    static char[][] board;

    static void draw(int x, int y, int n) {
        if (n == 3) {
            board[x][y] = '*';
            board[x + 1][y - 1] = board[x + 1][y + 1] = '*';
            board[x + 2][y - 2] = board[x + 2][y - 1] =
                    board[x + 2][y] = board[x + 2][y + 1] = board[x + 2][y + 2] = '*';
            return;
        }

        n /= 2;

        draw(x, y, n);
        draw(x + n, y - n, n);
        draw(x + n, y + n, n);
    }
}
