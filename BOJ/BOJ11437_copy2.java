package BOJ;

/* 
    LCA
*/

import java.io.*;
import java.util.*;

public class BOJ11437_copy2 {

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

        max = (int) Math.ceil(Math.log(N) / Math.log(2));

        parent = new int[N + 1][max];

        depth = new int[N + 1];
        defineParent(1, 0, 0);

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

    static int N, max;
    static int[] depth;
    static List<List<Integer>> links;
    static int[][] parent; // i의 깊이가 j인 조상

    static void defineParent(int c, int d, int p) {

        depth[c] = d;
        parent[c][0] = p;

        for (int next : links.get(c)) {
            if (depth[next] != 0) {
                continue;
            }
            defineParent(next, d + 1, c);
        }

    }

    static int LCA(int a, int b) {

        System.out.println("LCA  " + a + " " + b);

        if (depth[a] > depth[b]) {
            int t = a;
            a = b;
            b = t;
        }

        for (int i = max; i >= 0; i--) {
            if (depth[b] >= depth[a] + (1 << i)) {
                b = parent[b][i];
            }
        }

        System.out.println("depth" + " " + depth[a] + " " + depth[b]);

        if (a == b) {
            return a;
        }

        for (int i = max; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];

    }

}
