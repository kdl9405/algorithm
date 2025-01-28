package boj;

/*
 * 30
 */

import java.io.*;
import java.util.*;

public class BOJ10610 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] numbers = br.readLine().toCharArray();

        int sum = 0;
        boolean zero = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] - '0' == 0) {
                zero = true;
            } else {
                sum += (numbers[i] - '0');
            }
        }

        if (!zero || sum % 3 != 0) {
            System.out.println(-1);
        } else {
            Arrays.sort(numbers);
            StringBuilder sb = new StringBuilder();

            System.out.println(sb.append(new String(numbers)).reverse());
        }

    }
}
