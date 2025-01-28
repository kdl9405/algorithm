package boj;

import java.io.*;
import java.util.Arrays;

/*
 * 나눌 수 있는 부분 수열
 * 
 * // 메모리 초과
 * 
 */
public class BOJ3673_copy2 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (c-- > 0) {

            int[] option =
                    Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            long[] number =
                    Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

            sum = new long[option[1]][option[1]];

            for (int i = 0; i < option[1]; i++) {
                sum[i][i] = number[i];
            }

            int count = 0;

            for (int i = 0; i < option[1]; i++) {
                for (int j = i; j < option[1]; j++) {
                    long s = findSum(i, j);
                    if (s >= option[0] && s % option[0] == 0) {
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb.toString().trim());

    }


    static long[][] sum;

    static long findSum(int start, int end) {

        if (sum[start][end] != 0) {
            return sum[start][end];
        }

        return sum[start][end] = findSum(start, end - 1) + sum[end][end];

    }

}
