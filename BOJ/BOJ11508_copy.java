package BOJ;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/* 
    2+1 세일
    메모리 초과
*/
public class BOJ11508_copy {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Integer[] arr = new Integer[n];

        long total = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(sc.nextLine());
            total += arr[i];
        }


        Arrays.sort(arr, Collections.reverseOrder());

        if (n >= 2) {

            for (int i = 2; i < n; i += 3) {
                total -= arr[i];
            }

        }

        System.out.println(total);

    }

}