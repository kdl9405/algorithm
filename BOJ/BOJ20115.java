package boj;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 에너지 드링크
 */

public class BOJ20115 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Double[] arr = new Double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        Double sum = arr[0];

        for (int i = 1; i < n; i++) {
            sum += (arr[i] / 2);
        }

        System.out.println(sum);

    }
}
