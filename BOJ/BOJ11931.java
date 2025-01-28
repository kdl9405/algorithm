package boj;

/**
 * 수 정렬하기 4
 */

import java.io.*;
import java.util.*;

public class BOJ11931 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        StringBuilder answer = new StringBuilder();

        for (int i = N - 1; i >= 0; i--) {
            answer.append(arr[i]).append("\n");
        }

        System.out.println(answer.toString().trim());
    }
}
