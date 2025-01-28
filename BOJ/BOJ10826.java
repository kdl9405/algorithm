package boj;

/**
 * 피보나치 수 4
 */

import java.io.*;
import java.math.BigInteger;

public class BOJ10826 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N >= 2) {
            BigInteger[] fibonacci = new BigInteger[N + 1];

            fibonacci[0] = BigInteger.valueOf(0L);
            fibonacci[1] = BigInteger.valueOf(1L);

            for (int i = 2; i <= N; i++) {
                fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
            }
            System.out.println(fibonacci[N]);

        } else {
            System.out.println(N);
        }

    }

}
