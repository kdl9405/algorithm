package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1018 {

    static boolean[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        board = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {

                if (str.charAt(j) == 'W') {
                    board[i][j] = true;
                }
            }
        }



        int min = 64;
        for (int i = 0; i < m - 7; i++) {
            for (int j = 0; j < n - 7; j++) {

                int temp = boardcheck(i, j);

                if (temp < min) {
                    min = temp;
                }
            }
        }

        System.out.println(min);

    }

    public static int boardcheck(int x, int y) {
        int count = 0;

        boolean def = board[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (board[i][j] != def) {
                    count++;

                }

                def = (!def);
            }
            def = (!def);

        }

        count = Math.min(count, 64 - count);

        return count;
    }
}
