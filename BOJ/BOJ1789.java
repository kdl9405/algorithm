package boj;


/*
 * 수들의 합
 * 
 */

import java.io.*;

public class BOJ1789 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Long S = Long.parseLong(br.readLine());

        long sum = 0;
        long n = 0;
        while (true) {

            sum += n;

            if (sum > S) {
                break;
            }
            n++;
        }

        if (sum != S) {
            n--;
        }

        System.out.println(n);

    }
}
