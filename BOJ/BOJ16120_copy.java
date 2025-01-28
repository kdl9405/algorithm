package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * PPAP
 * 
 * 시간초과
 */

public class BOJ16120_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String p = br.readLine();

        while (p.length() > 4) {

            if (p.contains("PPAP")) {
                p = p.replaceAll("PPAP", "P");
            }
        }

        if (!p.equals("PPAP")) {
            System.out.println("NP");
        } else {
            System.out.println(p);
        }

    }
}
