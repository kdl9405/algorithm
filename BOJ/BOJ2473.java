package boj;

import java.io.*;
import java.util.*;

/*
 * 세 용액
 */

public class BOJ2473 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] result = new long[3];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        long sum = 0;


        for (int i = 0; i < n - 2; i++) {

            long pick = arr[i];
            int left = i + 1;
            int right = n - 1;


            while (left < right) {

                sum = pick + arr[left] + arr[right];

                if (min > Math.abs(sum)) {
                    min = Math.abs(sum);
                    result[0] = pick;
                    result[1] = arr[left];
                    result[2] = arr[right];
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }

}
