package boj;

import java.util.*;
import java.io.*;

public class BOJ2630 {

    static int[][] arr;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check_color(0, 0, n);

        System.out.println(white);
        System.out.println(blue);

    }

    static void check_color(int x, int y, int len) {

        if (len == 1) {
            int color = arr[x][y];
            if (color == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        int color = arr[x][y];
        boolean check = true;

        loop: for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (arr[i][j] != color) {
                    check = false;
                    break loop;
                }
            }
        }

        if (check) {
            if (color == 1) {
                blue++;
            } else {
                white++;
            }
        } else {
            check_color(x, y, len / 2);
            check_color(x, y + len / 2, len / 2);
            check_color(x + len / 2, y, len / 2);
            check_color(x + len / 2, y + len / 2, len / 2);
        }

        return;
    }

}
