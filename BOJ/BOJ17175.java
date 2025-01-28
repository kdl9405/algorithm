package boj;

/*
 * 피보나치는 지겨웡~
 */

import java.io.*;

public class BOJ17175 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[51];

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = (1 + arr[i - 2] + arr[i - 1]) % 1000000007;
        }

        System.out.println(arr[n]);
    }

}
