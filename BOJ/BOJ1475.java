package boj;

/*
 * 방 번호
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ1475 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] num = br.readLine().toCharArray();

        int[] count = new int[9];

        for (char n : num) {

            if (n == '9') {
                count[6]++;
            } else {
                count[n - '0']++;
            }
        }

        if (count[6] % 2 == 1) {
            count[6] = count[6] / 2 + 1;
        } else {
            count[6] /= 2;
        }

        Arrays.sort(count);

        System.out.println(count[8]);
    }
}
