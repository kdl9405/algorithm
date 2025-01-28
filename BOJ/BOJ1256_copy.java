package boj;

/*
 * 사전
 * 
 * 메모리 초과
 */

import java.io.*;
import java.util.*;

public class BOJ1256_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        makeNum(N, M, "");

        if (list.size() < K) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(K - 1));
        }
    }

    static List<String> list = new ArrayList<>();

    static void makeNum(int a, int z, String number) {

        if (a == 0 && z == 0) {
            list.add(number);
            return;
        }

        if (a > 0) {
            makeNum(a - 1, z, number + "a");
        }

        if (z > 0) {
            makeNum(a, z - 1, number + "z");
        }
    }
}
