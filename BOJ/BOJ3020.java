package boj;

/*
 * 개똥벌레
 */

import java.io.*;
import java.util.*;

public class BOJ3020 {

    public static void main(String[] args) throws IOException {

        new BOJ3020().solution();
    }

    void solution() throws IOException {

        initAndSum();

        int min = N;
        int count = 0;
        for (int i = 1; i <= H; i++) {
            if (prefixSum[i] < min) {
                min = prefixSum[i];
                count = 1;
            } else if (prefixSum[i] == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);

    }

    int N, H;
    int[] prefixSum;

    void initAndSum() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        prefixSum = new int[H + 1];

        for (int i = 0; i < N; i++) {

            int size = Integer.parseInt(br.readLine());

            if (i % 2 == 0) {
                prefixSum[1]++;
                prefixSum[size + 1]--;
            } else {
                prefixSum[H + 1 - size]++;
            }
        }

        for (int i = 2; i <= H; i++) {
            prefixSum[i] += prefixSum[i - 1];
        }
    }
}
