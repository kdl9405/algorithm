package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 잠수함식별
 */

public class BOJ2671 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();



        if (s.matches("^(100+1+|01)+$")) {
            System.out.println("SUBMARINE");
        } else {
            System.out.println("NOISE");
        }

    }
}
