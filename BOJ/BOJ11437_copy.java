package boj;

/*
 * LCA
 */

import java.io.*;
import java.util.*;

public class BOJ11437_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        links = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            links.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            links.get(a).add(b);
            links.get(b).add(a);
        }

        parent = new int[N + 1];

        depth = new int[N + 1];
        defineParent(1, 1);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(LCA(a, b)).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

    static int N;
    static int[] depth;
    static List<List<Integer>> links;
    static int[] parent; // i의 깊이가 j인 조상

    static void defineParent(int c, int d) {

        depth[c] = d++;
        for (int next : links.get(c)) {
            if (depth[next] != 0) {
                continue;
            }
            defineParent(next, d);
            parent[next] = c;
        }

    }

    static int LCA(int a, int b) {
        int aD = depth[a];
        int bD = depth[b];

        if (aD > bD) {
            while (aD != bD) {
                aD--;
                a = parent[a];
            }
        } else if (aD < bD) {
            while (aD != bD) {
                bD--;
                b = parent[b];
            }
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

}
