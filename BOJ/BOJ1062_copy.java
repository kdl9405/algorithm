package boj;

import java.io.*;
import java.util.*;

/*
 * 가르침
 * 
 * 
 */
public class BOJ1062_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }

        k -= 5;
        max = 0;

        int alphabet = 0;

        String init = "antic";
        for (int i = 0; i < 5; i++) {
            alphabet |= (1 << (init.charAt(i) - 'a'));
        }

        teachAlphabet(0, 0, alphabet);

        System.out.println(max);

    }

    static int n, k, max;
    static String[] words;

    static void teachAlphabet(int index, int depth, int bit) {

        if (depth == k) {
            int count = 0;
            for (String word : words) {
                boolean possible = true;

                for (int i = 4; i < word.length() - 4; i++) {

                    if ((bit & (1 << (word.charAt(i) - 'a'))) == 0) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    count++;
                }
            }

            max = Integer.max(max, count);
            return;
        }

        for (int i = index; i < 26; i++) {
            if ((bit & (1 << i)) != 0) {
                continue;
            }
            teachAlphabet(i + 1, depth + 1, bit | (1 << i));
        }
        return;
    }
}
