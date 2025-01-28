package boj;

import java.io.*;
import java.util.*;

/*
 * 빗물
 */
public class BOJ14719 { // left을 찾고 right을 찾아 가운데 값을 계산

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[w];
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = 0;

        for (int i = 1; i < w - 1; i++) {

            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > left) {
                    left = arr[j];
                }
            }

            for (int j = i + 1; j < w; j++) {
                if (arr[j] > right) {
                    right = arr[j];
                }
            }

            int x = Math.min(left, right);
            if (arr[i] < x) {
                total += (x - arr[i]);
            }
        }

        System.out.println(total);

    }
}
