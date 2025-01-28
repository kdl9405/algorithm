package boj;

/**
 * 빙고
 */

import java.io.*;
import java.util.*;

public class BOJ2578 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        point = new int[26][2];
        board = new boolean[6][6];

        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                point[num][0] = i;
                point[num][1] = j;
            }
        }

        bingoLine = 0;
        int cnt = 0;
        int answer = 0;
        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                cnt++;
                int num = Integer.parseInt(st.nextToken());

                if (bingoLine < 3) {
                    board[point[num][0]][point[num][1]] = true;
                    if (isBingo(point[num][0], point[num][1])) {
                        answer = cnt;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static int[][] point;
    static boolean[][] board;
    static int bingoLine;

    static boolean isBingo(int x, int y) {

        if (board[x][1] && board[x][2] && board[x][3] && board[x][4] && board[x][5]) {
            bingoLine++;
        }

        if (board[1][y] && board[2][y] && board[3][y] && board[4][y] && board[5][y]) {
            bingoLine++;
        }

        if (x == y && board[1][1] && board[2][2] && board[3][3] && board[4][4] && board[5][5]) {
            bingoLine++;
        }

        if (x + y == 6 && board[1][5] && board[2][4] && board[3][3] && board[4][2] && board[5][1]) {
            bingoLine++;
        }

        return bingoLine >= 3 ? true : false;
    }
}
