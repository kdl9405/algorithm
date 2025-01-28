package boj;

import java.io.*;
import java.util.*;

/*
 * 다각형의 면적
 */
public class BOJ2166 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long[][] points = new long[N + 1][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        points[N][0] = points[0][0];
        points[N][1] = points[0][1];

        long x = 0;
        long y = 0;

        for (int i = 0; i < N; i++) {
            x += (points[i][0] * points[i + 1][1]);
            y += (points[i][1] * points[i + 1][0]);
        }

        double answer = Math.abs(x - y);
        answer /= 2.0;

        System.out.println(String.format("%.1f", answer));
    }
}
