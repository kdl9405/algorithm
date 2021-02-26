package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/* 
    2+1 세일
*/
public class BJ11508 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[n];

        long total = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            total += arr[i];
        }

        br.close();

        Arrays.sort(arr, Collections.reverseOrder());

        if (n >= 2) {

            for (int i = 2; i < n; i += 3) {
                total -= arr[i];
            }
        }

        System.out.println(total);

    }

}