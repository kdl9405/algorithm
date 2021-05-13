package BOJ;

import java.io.*;

/* 
    피보나치 수 3

    행렬제곰 활용!!
*/
public class BOJ2749 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        if (N == 1) {
            System.out.println(1);
        } else {
            long[][] answer = arrPow(N - 1);
            System.out.println(answer[0][0]);
        }

    }

    static int MOD = 1000000;
    static long[][] arr = { { 1, 1 }, { 1, 0 } };

    static long[][] arrPow(long n) {
        long[][] temp = new long[2][2];

        if (n == 1) {
            return arr;
        }

        long[][] m = arrPow(n / 2);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    temp[i][j] += m[i][k] * m[k][j];
                }
                temp[i][j] %= MOD;
            }
        }

        if (n % 2 == 1) {
            long[][] t = new long[2][2];

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 2; k++) {
                        t[i][j] += temp[i][k] * arr[k][j];
                    }
                    t[i][j] %= MOD;
                }
            }

            return t;
        }

        return temp;

    }
}

