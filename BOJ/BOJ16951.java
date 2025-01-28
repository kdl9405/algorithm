package boj;

/*
 * 블록 놀이
 */

import java.io.*;
import java.util.*;

public class BOJ16951 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = n;

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                int x = (j - i) * k + a[i];
                if (x < 1) {
                    temp = n;
                    break;
                }
                if (a[j] != x) {
                    temp++;
                }
            }

            answer = Math.min(answer, temp);
        }

        System.out.println(answer);

    }
}
