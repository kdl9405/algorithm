package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ2839
 */
public class BOJ2839 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 0;

        while (true) {
            if (n % 5 == 0) {
                System.out.println(n / 5 + result);
                break;
            } else if (n <= 0) {
                System.out.println(-1);
                break;
            }
            n = n - 3;
            result++;
        }


    }


}

