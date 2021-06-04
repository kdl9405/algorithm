package BOJ;

import java.io.*;
import java.util.*;

/* 
    가르침 
*/
public class BOJ1062 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int alphabet = 0;

        String init = "antic";
        for (int i = 0; i < 5; i++) {
            alphabet |= (1 << (init.charAt(i) - 'a'));
        }

        words = new int[n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            int bit = alphabet;
            for (int j = 4; j < s.length() - 4; j++) {
                bit |= (1 << s.charAt(j) - 'a');
            }
            words[i] = bit;
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

        teachAlphabet(0, 0, alphabet);

        System.out.println(max);


    }

    static int n, k, max;
    static int[] words;

    private static void teachAlphabet(int index, int depth, int bit) {
        if (depth == k) {

            int count = 0;
            int test = bit;
            for (int word : words) {
                int check = (test | word);
                if (check == test) {
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
            teachAlphabet(i + 1, depth + 1, (bit | 1 << i));
        }

    }
}
