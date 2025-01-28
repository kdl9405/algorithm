package boj;

import java.io.*;
import java.util.Arrays;

/**
 * BOJ1157
 */
public class BOJ1157_copy3 {
    public static void main(final String[] args) throws IOException {

        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = System.in.read();

        int[] alphabet = new int[26];

        while (Character.isDigit(c)) {

            if (c < 'A') {
                alphabet[c - 'a']++;
            } else {
                alphabet[c - 'A']++;
            }
        }

        int max = 0;
        char answer = '?';

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                answer = (char) (i + 'A');
            } else if (alphabet[i] == max) {
                answer = '?';
            }
        }

        System.out.println(answer);

    }
}
