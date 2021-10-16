package BOJ;

import java.io.*;
import java.util.*;

/* 
    Σ
*/
public class BOJ13172 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        long result = 0;

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            int gcd = GCD(S, N);

            N /= gcd;
            S /= gcd;

            result += ((long) S * findInverse(N)) % MOD;
            result %= MOD;

        }

        System.out.println(result);
    }

    static int MOD = 1000000007;

    static int GCD(int a, int b) {

        while (b != 0) {

            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    static long findInverse(int b) {

        return findPow(b, MOD - 2);

    }

    static long findPow(int b, int x) {

        if (x == 1) {
            return b;
        }

        // if (x%2 == 1) {
        //     return b*findPow(b, x-1) % MOD;
        // }

        long temp = findPow(b, x / 2);
        if (x % 2 == 1) {
            return ((temp * temp) % MOD) * b % MOD;
        }
        return temp * temp % MOD;

    }
}
