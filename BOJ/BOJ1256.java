package boj;

/*
 * 사전
 */

import java.io.*;
import java.util.*;

public class BOJ1256 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        count = new int[N + 1][M + 1];

        if (getCount(N, M) < K) {
            System.out.println(-1);
        } else {
            number = new StringBuilder();
            getNumber(N, M, K);
            System.out.println(number.toString());
        }

    }

    static int[][] count;
    static StringBuilder number;

    static int getCount(int a, int z) {

        if (a == 0 || z == 0) {
            return 1;
        }

        if (count[a][z] != 0) {
            return count[a][z];
        }

        return count[a][z] = Math.min(getCount(a - 1, z) + getCount(a, z - 1), 1000000001);
    }

    static void getNumber(int a, int z, int k) {
        if (a == 0) {
            while (z-- > 0) {
                number.append("z");
            }
            return;
        }

        if (z == 0) {
            while (a-- > 0) {
                number.append("a");
            }
            return;
        }

        int x = getCount(a - 1, z);

        if (k > x) {
            number.append("z");
            getNumber(a, z - 1, k - x);
        } else {
            number.append("a");
            getNumber(a - 1, z, k);
        }
    }
}
