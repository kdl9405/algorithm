package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ1065
 */
public class BOJ1065 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int number = 0;

        if (n < 100) {
            number = n;
        }

        else if (n >= 100) {

            number = 99;

            for (int i = 100; i <= n; i++) {

                if (Number(i) == true) {

                    number += 1;
                }

            }
        }

        System.out.println(number);

    }

    public static boolean Number(int n) {

        int a = n / 100;
        int b = n % 100 / 10;
        int c = n % 100 % 10;

        if (a - b == b - c)
            return true;

        else
            return false;

    }

}
