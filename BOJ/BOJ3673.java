package boj;

import java.io.*;
import java.util.Arrays;

/*
 * 나눌 수 있는 부분 수열
 * 
 */
public class BOJ3673 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (c-- > 0) {

            int[] option =
                    Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int d = option[0];
            int n = option[1];

            long[] number =
                    Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            long sum = 0;
            long[] mod = new long[d];

            for (int i = 0; i < n; i++) {
                sum += number[i];
                mod[(int) (sum % d)]++;
            }

            long count = mod[0];

            for (int i = 0; i < d; i++) {
                count += (mod[i] * (mod[i] - 1) / 2);
            }

            sb.append(count).append("\n");


        }

        System.out.println(sb.toString().trim());

    }


}
