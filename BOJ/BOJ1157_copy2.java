package BOJ;

import java.io.*;
import java.util.Arrays;

/**
 * BOJ1157
 */
public class BOJ1157_copy2 {
    public static void main(final String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] S = br.readLine().toCharArray();

        int[][] alphabet = new int[26][2];
        for (int i = 0; i <= 25; i++) {
            alphabet[i][0] = i + 'A';
        }

        for (char c : S) {

            if (Character.isLowerCase(c)) {
                alphabet[c - 'a'][1]++;
            }else{
                alphabet[c - 'A'][1]++;
            }
        }

        Arrays.sort(alphabet, (a, b) -> {
            return b[1] - a[1];
        });

        if (alphabet[0][1] == alphabet[1][1]) {
            System.out.println("?");
        } else {
            System.out.println((char) alphabet[0][0]);
        }

    }
}