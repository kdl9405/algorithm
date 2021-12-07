package BOJ;

import java.io.*;
import java.util.Arrays;

/* 
    일곱 난쟁이
*/
public class BOJ2309_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        hobits = new int[9];
        for (int i = 0; i < 9; i++) {
            hobits[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(hobits);

        real = new int[7];
        find = false;

        check(0, 0);

        StringBuilder sb = new StringBuilder();
        for (int r : real) {
            sb.append(r + "\n");
        }
        System.out.println(sb.toString().trim());
    }

    static int[] hobits;
    static int[] real;
    static boolean find;

    static void check(int idx, int depth) {

        if (idx - depth > 2) {
            return;
        }

        if (depth == 7) {

            int sum = 0;
            for (int r : real) {
                sum += r;
            }

            if (sum == 100) {
                find = true;
               
            }
            return;
        }

        if (idx == 9) {
            return;
        }

        check(idx + 1, depth);

        if (find) {
            return;
        }

        real[depth] = hobits[idx];
        check(idx + 1, depth + 1);
    }
}
