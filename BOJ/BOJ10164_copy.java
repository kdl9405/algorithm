package BOJ;

/* 
    자상의 경로
*/

import java.io.*;
import java.util.*;

public class BOJ10164_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        factorial = new long[N + M];

        if (K == 0) {

            System.out.println(findFactorial(N + M - 2) / (findFactorial(N - 1) * findFactorial(M - 1)));

        } else {
            int r1 = (K - 1) / M + 1;
            int c1 = K - (M * (r1 - 1));
            int r2 = N + 1 - r1;
            int c2 = M + 1 - c1;

            long before = findFactorial(r1 + c1 - 2) / (findFactorial(r1 - 1) * findFactorial(c1 - 1));
            long after = findFactorial(r2 + c2 - 2) / (findFactorial(r2 - 1) * findFactorial(c2 - 1));

            System.out.println(before * after);

        }

    }

    static long[] factorial;

    static long findFactorial(int n) {

        if (n <= 0) {
            return 1;
        }

        if (factorial[n] != 0) {
            return factorial[n];
        }

        return factorial[n] = findFactorial(n - 1) * n;
    }

}
