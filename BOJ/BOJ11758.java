package boj;

import java.io.*;
import java.util.*;

/*
 * CCW
 */

public class BOJ11758 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] x = new int[4];
        int[] y = new int[4];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        x[3] = x[0];
        y[3] = y[0];

        int a = 0, b = 0;

        for (int i = 0; i < 3; i++) {
            a += x[i] * y[i + 1];
            b += y[i] * x[i + 1];
        }

        int result = a - b;

        if (result > 0) {
            result = 1;
        } else if (result < 0) {
            result = -1;
        }


        System.out.println(result);

    }
}
