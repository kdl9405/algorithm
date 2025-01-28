package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9020 {

    public static boolean primeN[];

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            int n = Integer.parseInt(br.readLine());

            primeN = new boolean[n + 1];

            check_prime();

            int j = 2;
            int A = 0, tA = 0;
            int B = Integer.MAX_VALUE, tB = Integer.MAX_VALUE;

            while (j <= n - j) {

                if (primeN[j] == false && primeN[n - j] == false) {

                    tA = j;
                    tB = n - j;

                    if ((tB - tA) < (B - A)) {

                        A = tA;
                        B = tB;
                    }
                }

                j++;

            }
            System.out.println(A + " " + B);

        }
    }

    public static void check_prime() {

        primeN[0] = true;
        primeN[1] = true;

        for (int i = 2; i <= Math.sqrt(primeN.length); i++) {

            if (primeN[i]) {
                continue;
            }

            for (int j = i * i; j < primeN.length; j += i) {
                primeN[j] = true;
            }

        }

    }
}
