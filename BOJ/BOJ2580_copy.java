package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
 * 스도쿠 시간초과
 */

public class BOJ2580_copy {

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

        while (true) {
            int count = 0;

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (arr[i][j] == 0) {
                        count++;

                        if (checkRow(i, j) || checkCol(i, j) || checkRect(i, j)) {
                            count--;

                            System.out.println(
                                    i + " " + j + " = " + arr[i][j] + "  count = " + count);

                        }


                    }


                }
            }

            if (count == 0) {
                break;
            }
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    static int[][] arr;

    static boolean checkRow(int i, int j) {

        boolean[] used = new boolean[10];
        for (int x = 0; x < 9; x++) {

            if (arr[i][x] == 0 && x != j) {
                return false;
            } else {
                used[arr[i][x]] = true;
            }
        }

        for (int x = 1; x < 10; x++) {
            if (!used[x]) {
                arr[i][j] = x;
                break;
            }
        }
        return true;
    }

    static boolean checkCol(int i, int j) {

        boolean[] used = new boolean[10];
        for (int x = 0; x < 9; x++) {
            if (arr[x][j] == 0 && x != i) {
                return false;
            } else {
                used[arr[x][j]] = true;
            }
        }

        for (int x = 1; x < 10; x++) {
            if (!used[x]) {
                arr[i][j] = x;
                break;
            }
        }
        return true;
    }

    static boolean checkRect(int i, int j) {

        int r = (i / 3) * 3;
        int c = (j / 3) * 3;

        boolean[] used = new boolean[10];
        for (int x = r; x < r + 3; x++) {
            for (int y = c; y < c + 3; y++) {
                if (x == i && y == j) {
                    continue;
                }
                if (arr[x][y] == 0) {
                    return false;
                }

                used[arr[x][y]] = true;
            }
        }

        for (int x = 1; x < 10; x++) {
            if (!used[x]) {
                arr[i][j] = x;
                break;
            }
        }

        return true;
    }
}
