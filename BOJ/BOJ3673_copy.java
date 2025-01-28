package boj;

import java.io.*;
import java.util.Arrays;

/*
 * 나눌 수 있는 부분 수열
 * 
 * // 시간초과
 * 
 */
public class BOJ3673_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (c-- > 0) {

            int[] option =
                    Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            long[] number =
                    Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            long[] sum = new long[option[1] + 1];

            for (int i = 0; i < option[1]; i++) {
                sum[i + 1] = sum[i] + number[i];
            }

            int count = 0;

            for (int i = 0; i < option[1]; i++) {
                for (int j = i + 1; j <= option[1]; j++) {
                    long temp = sum[j] - sum[i];

                    if (temp >= option[0] && temp % option[0] == 0) {
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");


        }

        System.out.println(sb.toString().trim());

    }


    static long[] sum;


}
