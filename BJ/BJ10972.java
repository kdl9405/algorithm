package BJ;

import java.io.*;
import java.util.*;

/* 
    다음 순열
*/
public class BJ10972 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int max = 0;
        boolean change = false;
        for (int i = arr.length - 1; i > 0; i--) {
            max = Math.max(max, arr[i]);
            if (arr[i - 1] < max) {
                change = true;
                int index = i;
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] > arr[i - 1] && max > arr[j]) {
                        max = arr[j];
                        index = j;
                    }
                }

                int temp = arr[i - 1];
                arr[i - 1] = max;
                arr[index] = temp;

                Arrays.sort(arr, i, arr.length);

                break;
            }
        }

        if (change) {
            StringBuilder sb = new StringBuilder();
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            System.out.println(sb.toString().trim());
        } else {
            System.out.println(-1);
        }

    }
}
