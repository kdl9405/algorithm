package boj;

/*
 * 사이클 게임
 */

import java.io.*;
import java.util.*;

public class BOJ20040 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        setRoot(n);

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a = findRoot(a);
            b = findRoot(b);
            if (a == b) {
                System.out.println(i);
                return;
            }
            root[b] = a;
        }

        System.out.println(0);

    }

    static int[] root;

    static void setRoot(int n) {
        root = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
    }

    static int findRoot(int x) {
        if (root[x] == x) {
            return x;
        }

        return root[x] = findRoot(root[x]);
    }

}
