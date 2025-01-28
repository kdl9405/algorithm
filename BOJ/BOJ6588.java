package boj;

/*
 * 골드바흐의 추측
 */

import java.io.*;

public class BOJ6588 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        notPrime = new boolean[1000001];

        findPrime();

        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                break;
            }

            boolean check = false;
            for (int i = 2; i <= n / 2; i++) {

                if (!notPrime[i] && !notPrime[n - i]) {
                    check = true;
                    sb.append(n + " = " + i + " + " + (n - i) + "\n");
                    break;
                }
            }

            if (!check) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }

        System.out.println(sb.toString().trim());
    }

    static boolean[] notPrime;

    static void findPrime() {

        for (int i = 2; i <= 1000000; i++) {

            for (int j = 2; i * j <= 1000000; j++) {
                notPrime[i * j] = true;
            }
        }
        return;
    }
}
