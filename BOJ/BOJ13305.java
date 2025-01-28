package boj;

/*
 * 주유소
 */

import java.io.*;
import java.util.*;

public class BOJ13305 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] distance = new long[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        int[] price = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int min = price[0];
        long total = distance[0] * price[0];

        for (int i = 1; i < N - 1; i++) {
            min = Math.min(price[i], min);

            total += (distance[i] * min);
        }

        System.out.println(total);

    }
}
