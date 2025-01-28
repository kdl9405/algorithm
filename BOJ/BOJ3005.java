package boj;

/*
 * 크로스워드 퍼즐 쳐다보기
 */

import java.io.*;
import java.util.*;

public class BOJ3005 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        words = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {

                if (j == 0 || board[i][j - 1] == '#') {
                    findInRow(i, j, new StringBuilder());
                }

                if (i == 0 || board[i - 1][j] == '#') {
                    findInCol(i, j, new StringBuilder());
                }
            }
        }

        Collections.sort(words);

        System.out.println(words.get(0));

    }

    static int R, C;
    static char[][] board;
    static List<String> words;

    static void findInRow(int x, int y, StringBuilder sb) {

        while (true) {
            if (y == C || board[x][y] == '#') {
                break;
            }
            sb.append(board[x][y]);
            y++;
        }

        if (sb.length() > 1) {
            words.add(sb.toString());
        }

        return;
    }

    static void findInCol(int x, int y, StringBuilder sb) {

        while (true) {
            if (x == R || board[x][y] == '#') {
                break;
            }
            sb.append(board[x][y]);
            x++;
        }

        if (sb.length() > 1) {
            words.add(sb.toString());
        }
        return;
    }

}
