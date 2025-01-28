package boj;

/*
 * A와 B
 * 
 */

import java.io.*;

public class BOJ12904 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());

        while (T.length() > S.length()) {

            if (T.charAt(T.length() - 1) == 'A') {
                T = new StringBuilder(T.substring(0, T.length() - 1));
            } else {
                T = new StringBuilder(T.substring(0, T.length() - 1));
                T = T.reverse();
            }
        }

        if (T.toString().equals(S)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

    }
}
