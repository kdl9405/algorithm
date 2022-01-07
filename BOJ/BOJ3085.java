package BOJ;

/* 
    사탕 게임
*/

import java.io.*;

public class BOJ3085 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        init();

        change();

        System.out.println(answer);

    }

    static int N, answer;
    static char[][] board;

    static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }

    static void change() {

        answer = 0;

        for (int i = 0; i < N; i++) {
            int c = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    c++;
                    if (c > answer) {
                        answer = c;
                    }
                } else {
                    c = 1;
                }
            }
        }
        for (int j = 0; j < N; j++) {
            int c = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i-1][j]) {
                    c++;
                    if (c > answer) {
                        answer = c;
                    }
                } else {
                    c = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (j < N - 1 && (board[i][j] != board[i][j + 1])) {
                    countCandy(i, j, i, j + 1);
                }

                if (i < N - 1 && (board[i][j] != board[i + 1][j])) {
                    countCandy(i, j, i + 1, j);

                }
            }
        }
    }

    static void countCandy(int x1, int y1, int x2, int y2) {

        int count = 1;
        int nx = x1;
        int ny = y1;
        while (--nx >= 0) {
            if (board[nx][ny] != board[x2][y2] || (nx == x2) && (ny == y2)) {
                break;
            }
            count++;
        }
        nx = x1;
        while (++nx < N) {
            if (board[nx][ny] != board[x2][y2] || (nx == x2) && (ny == y2)) {
                break;
            }
            count++;
        }
        answer = Math.max(answer, count);

        count = 1;
        nx = x1;
        while (--ny >= 0) {
            if (board[nx][ny] != board[x2][y2] || (nx == x2) && (ny == y2)) {
                break;
            }
            count++;
        }
        ny = y1;
        while (++ny < N) {
            if (board[nx][ny] != board[x2][y2] || (nx == x2) && (ny == y2)) {
                break;
            }
            count++;
        }
        answer = Math.max(answer, count);

        count = 1;
        nx = x2;
        ny = y2;
        while (--nx >= 0) {
            if (board[nx][ny] != board[x1][y1] || (nx == x1) && (ny == y1)) {
                break;
            }
            count++;
        }
        nx = x2;
        while (++nx < N) {
            if (board[nx][ny] != board[x1][y1] || (nx == x1) && (ny == y1)) {
                break;
            }
            count++;
        }
        answer = Math.max(answer, count);

        count = 1;
        nx = x2;
        while (--ny >= 0) {
            if (board[nx][ny] != board[x1][y1] || (nx == x1) && (ny == y1)) {
                break;
            }
            count++;
        }
        ny = y2;
        while (++ny < N) {
            if (board[nx][ny] != board[x1][y1] || (nx == x1) && (ny == y1)) {
                break;
            }
            count++;
        }
        answer = Math.max(answer, count);

    }

}
