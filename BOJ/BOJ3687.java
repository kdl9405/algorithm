package BOJ;

import java.util.*;
import java.io.*;

/* 
    성냥개비

    // max = 자리수를 가장 많게!!
    // min = 자리수를 가장 적게!!
*/

public class BOJ3687 {

    static int[] minArr = { 0, 0, 1, 7, 4, 2, 0, 8, 10 };
    static long[] min_DP;
    static String max;
    static long min;

    public static void main(String[] args) throws IOException {

        char a = '0';
        char b = '1';

        System.out.println(b-'0');


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        min_DP = new long[101];
        min_DP[6] = 6;
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            // 최소값

            min = findMin(n);

            max = findMax(n);

            sb.append(min + " " + max + "\n");
        }

        System.out.println(sb.toString());
    }

    static long findMin(int n) {

        if (min_DP[n] != 0) {
            return min_DP[n];
        }

        if (n < 9) {
            return min_DP[n] = minArr[n];
        }

        min_DP[n] = findMin(n - 2) * 10 + minArr[2];

        for (int i = 3; i < 8 && n - i >= 2; i++) {
            min_DP[n] = Math.min(min_DP[n], findMin(n - i) * 10 + minArr[i]);
        }

        return min_DP[n];
    }

    static String findMax(int n) {

        StringBuilder temp = new StringBuilder();

        if (n % 2 == 0) {
            temp.append(1);
        } else {
            temp.append(7);
        }

        n /= 2;
        while (n-- > 1) {
            temp.append(1);
        }

        return temp.toString();
    }

}
