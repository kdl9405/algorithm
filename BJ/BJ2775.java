package BJ;

import java.io.*;

/**
 * BJ2775
 */
public class BJ2775 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int k = 0,n =0;
        for (int i = 0; i < t; i++) {

            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());

            System.out.println(count(k, n));
        }

    }

    public static int count(int k, int n) {

        if (k == 0) {
            return n;
        } else if (n == 1) {
            return 1;
        } else {
            return count(k, n - 1) + count(k - 1, n);
        }

    }

}