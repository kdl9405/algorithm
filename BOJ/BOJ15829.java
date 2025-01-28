package boj;

import java.io.*;

/*
 * Hashing
 */
public class BOJ15829 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int r = 31;
        int M = 1234567891;
        String s = br.readLine();

        long sum = 0;
        double y = 1;

        for (int i = 0; i < L; i++) {
            int x = s.charAt(i) - 'a' + 1;

            sum += (x * y);
            y = (y * r) % M;


        }

        System.out.println(sum % M);
    }

}
