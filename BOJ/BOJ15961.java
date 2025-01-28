package boj;

import java.io.*;
import java.util.*;

/*
 * 회전 초밥
 */
public class BOJ15961 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        plate = new int[n];
        visit = new int[d + 1];
        for (int i = 0; i < n; i++) {
            plate[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(findMax(n, k, c));
    }

    static int[] plate;
    static int[] visit;

    static int findMax(int n, int k, int c) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < k; i++) {
            if (visit[plate[i]] == 0) {
                count++;
            }
            visit[plate[i]]++;
        }
        int j = k - 1;
        for (int i = 1; i < n; i++) {
            if (count >= max) {
                max = count;
                if (visit[c] == 0) {
                    max++;
                }
            }
            visit[plate[i - 1]]--;
            if (visit[plate[i - 1]] == 0) {
                count--;
            }

            j++;
            if (j == n) {
                j = 0;
            }
            if (visit[plate[j]] == 0) {
                count++;
            }
            visit[plate[j]]++;
        }


        return max;
    }
}
