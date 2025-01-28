package boj;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 로프
 */

public class BOJ2217 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Integer[] arr = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        int max = 0;

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i] * (arr.length - i));
        }

        System.out.println(max);

    }
}
