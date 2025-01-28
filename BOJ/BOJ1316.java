package boj;

import java.io.*;

/**
 * BOJ1316
 */
public class BOJ1316 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < T; i++) {

            int[] alphabet = new int[26];

            String str = br.readLine();

            String[] A = new String[str.length()];
            A = str.split("");

            for (int j = 0; j < A.length; j++) {

                if (j == 0) {
                    char c = A[j].charAt(0);
                    alphabet[(int) c - 97] += 1;

                } else if (j > 0) {
                    if (!A[j - 1].equals(A[j])) {
                        char c = A[j].charAt(0);

                        alphabet[(int) c - 97] += 1;

                    }
                }

            }

            int y = 0;
            for (int x = 0; x < 26; x++) {
                if (alphabet[x] < 2) {
                    y += 1;
                } else if (alphabet[x] > 1) {

                    break;
                }

            }

            if (y == 26) {
                count += 1;
            }

        }

        System.out.println(count);

    }
}
