package boj;

/*
 * 이항 계수 3
 */

import java.io.*;
import java.util.*;

public class BOJ11401 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long x = factoiral(N);
        long y = factoiral(K) * factoiral(N - K) % INF;

        System.out.println(x * pow(y, INF - 2) % INF);

    }

    static long INF = 1000000007;

    static long factoiral(long n) {
        long f = 1L;

        while (n > 1) {
            f = (f * n) % INF;
            n--;
        }

        return f;
    }

    static long pow(long base, long expo) {
        if (expo == 1) {
            return base % INF;
        }

        long t = pow(base, expo / 2);

        if (expo % 2 == 1) {
            return (t * t % INF) * base % INF;
        }
        return t * t % INF;
    }
}
