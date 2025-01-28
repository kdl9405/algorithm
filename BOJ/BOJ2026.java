package boj;

/*
 * 링
 */

import java.io.*;
import java.util.*;

public class BOJ2026 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while (N-- > 1) {
            int ring = Integer.parseInt(st.nextToken());

            int g = gcd(first, ring);

            sb.append((first / g) + "/" + (ring / g) + "\n");
        }

        System.out.println(sb.toString().trim());

    }

    static int gcd(int a, int b) {

        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }

        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

}
