package boj;


import java.util.*;
import java.io.*;

public class BOJ1780 {

    static int[][] arr;
    static int a = 0;
    static int b = 0;
    static int c = 0;

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

        check_arr(0, 0, n);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    }

    static void check_arr(int x, int y, int len) {

        int color = arr[x][y];

        if (len == 1) {
            switch (color) {
                case -1:
                    a++;
                    break;
                case 0:
                    b++;
                    break;
                case 1:
                    c++;
                    break;
            }
            return;
        }

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
            switch (color) {
                case -1:
                    a++;
                    break;
                case 0:
                    b++;
                    break;
                case 1:
                    c++;
                    break;
            }
        } else {
            len = len / 3;
            check_arr(x, y, len);
            check_arr(x, y + len, len);
            check_arr(x, y + (2 * len), len);

            check_arr(x + len, y, len);
            check_arr(x + len, y + len, len);
            check_arr(x + len, y + (2 * len), len);

            check_arr(x + (2 * len), y, len);
            check_arr(x + (2 * len), y + len, len);
            check_arr(x + (2 * len), y + (2 * len), len);

        }

    }

}
