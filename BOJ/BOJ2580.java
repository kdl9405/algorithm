package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 스도쿠
 * 
 */

public class BOJ2580 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9][9];

        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        fillArr(0, 0);

    }

    static int[][] arr;

    static void fillArr(int i, int j) {

        if (j == 9) {
            fillArr(i + 1, 0);
            return;
        }
        if (i == 9) {

            StringBuilder sb = new StringBuilder();
            for (int a = 0; a < 9; a++) {
                for (int b = 0; b < 9; b++) {
                    sb.append(arr[a][b] + " ");
                    // System.out.print(arr[a][b] + " ");
                }
                sb.append("\n");
                // System.out.println("");
            }

            System.out.println(sb);

            System.exit(0);

        }

        if (arr[i][j] == 0) {
            for (int x = 1; x < 10; x++) {
                if (checkRow(i, j, x) && checkCol(i, j, x) && checkRect(i, j, x)) {
                    arr[i][j] = x;
                    fillArr(i, j + 1);
                }
            }
            arr[i][j] = 0;
            return;
        }

        fillArr(i, j + 1);
    }

    static boolean checkRow(int i, int j, int x) {

        for (int a = 0; a < 9; a++) {
            if (a == j) {
                continue;
            }
            if (arr[i][a] == x) {
                return false;
            }
        }
        return true;
    }

    static boolean checkCol(int i, int j, int x) {

        for (int a = 0; a < 9; a++) {
            if (a == i) {
                continue;
            }
            if (arr[a][j] == x) {
                return false;
            }
        }
        return true;
    }

    static boolean checkRect(int i, int j, int x) {

        int r = (i / 3) * 3;
        int c = (j / 3) * 3;

        for (int a = r; a < r + 3; a++) {
            for (int b = c; b < c + 3; b++) {
                if (a == i && b == j) {
                    continue;
                }
                if (arr[a][b] == x) {
                    return false;
                }

            }
        }

        return true;
    }
}
