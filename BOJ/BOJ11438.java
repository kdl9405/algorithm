package BOJ;

/**
    LCA 2


    // 희소테이블??

 */

import java.io.*;
import java.util.*;

public class BOJ11438 {

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

        parent = new int[N + 1][21];
        depth = new int[N + 1];
        visit = new boolean[N + 1];

        defineParent(1, 1);
        setParentTable();

        // for (int i = 1; i <= N; i++) {
        // System.out.print(i + " : ");
        // for (int j = 0; j < 21; j++) {
        // System.out.print(parent[i][j] + " ");
        // }
        // System.out.println();
        // }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(findLCA(a, b)).append("\n");
        }

        System.out.println(sb.toString().trim());

    }

    static int N;
    static int[] depth;
    static List<List<Integer>> links;
    static int[][] parent; // i의 2^j번째 조상
    static boolean[] visit;

    static void defineParent(int c, int d) {
        visit[c] = true;
        depth[c] = d;

        for (int child : links.get(c)) {
            if (visit[child]) {
                continue;
            }

            parent[child][0] = c;
            defineParent(child, d + 1);
        }
    }

    static void setParentTable() {

        for (int p = 1; p < 21; p++) {
            for (int c = 1; c <= N; c++) {
                parent[c][p] = parent[parent[c][p - 1]][p - 1];
            }
        }
    }

    static int findLCA(int a, int b) {

        if (depth[a] > depth[b]) {
            int t = a;
            a = b;
            b = t;
        }

        for (int i = 20; i >= 0; i--) {
            if (depth[b] - depth[a] >= (1 << i)) {
                b = parent[b][i];
            }
        }

        if (a == b) {
            return a;
        }

        for (int i = 20; i >= 0; i--) {
            if (parent[a][i] == parent[b][i]) {
                continue;
            }

            a = parent[a][i];
            b = parent[b][i];
        }

        return parent[a][0];
    }
}