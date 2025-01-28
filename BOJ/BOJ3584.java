package boj;

/*
 * 가장 가까운 공통 조상
 */

import java.io.*;
import java.util.*;

public class BOJ3584 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] parent = new int[N + 1];

            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                parent[b] = a;
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean[] isParent = new boolean[N + 1];
            while (a != 0) {
                isParent[a] = true;
                a = parent[a];
            }

            while (true) {
                if (isParent[b]) {
                    sb.append(b).append("\n");
                    break;
                }

                b = parent[b];
            }

        }

        System.out.println(sb.toString().trim());

    }

}
