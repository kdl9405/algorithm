package boj;

/*
 * 제곱 ㄴㄴ 수
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ1016 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int dif = (int) (max - min);
        int limit = (int) Math.sqrt(max);

        boolean[] check = new boolean[dif + 1];

        for (long i = 2; i <= limit; i++) {

            long num = i * i;

            long j;
            if (min % num == 0) {
                j = min / num;
            } else {
                j = min / num + 1;
            }

            for (; j * num <= max; j++) {
                check[(int) (j * num - min)] = true;
            }

        }

        int count = 0;
        for (int i = 0; i <= dif; i++) {

            if (!check[i]) {
                count++;
            }
        }
        System.out.println(count);
    }
}

/*
 * 1 ~ 10
 * 
 * 1 X 2 X 3 X 4 4로 나눠짐 5 X 6 X 7 X 8 4로 나눠짐 9 9로 나눠짐 10 X
 * 
 * 
 * 
 */
