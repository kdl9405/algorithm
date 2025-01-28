package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20437 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {

            char[] str = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());

            int[] alphabet = new int[26];

            int l = 0, r = 1;

            for (; l < str.length; l++) {
                alphabet[str[l] - 'a']++;


            }

        }
    }
}
