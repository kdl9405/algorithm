package BOJ;

/* 
    LCA
*/

import java.io.*;
import java.util.*;

public class BOJ11437_copy4 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

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

        parent = new int[N + 1][N + 1];
        depth = new int[N + 1];
        parent[1][1] = 1;
        depth[1] = 1;

        defineParent(1);

        // for (int i = 1; i <= N; i++) {
        //     System.out.print(i + "  :  ");
        //     for (int j = 1; j <= N; j++) {
        //         System.out.print(parent[i][j] + "  ");
        //     }
        //     System.out.println();
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

    static List<List<Integer>> links;
    static int[][] parent;
    static int[] depth;

    static void defineParent(int p) {

        int d = depth[p];

        for (int c : links.get(p)) {
            if (depth[c] != 0) {
                continue;
            }
            parent[c] = Arrays.copyOf(parent[p], parent[p].length);
            parent[c][d] = p;
            depth[c] = d + 1;

            defineParent(c);
        }
    }

    static int findLCA(int a, int b) {

        if (depth[a] > depth[b]) {
            a = parent[a][depth[b]];
        }

        if (depth[b] > depth[a]) {
            b = parent[b][depth[a]];
        }

        int d = depth[a];

        while (d-- > 0) {

            if (parent[a][d] == parent[b][d]) {
                return parent[a][d];
            }
        }
        return 1;
    }

    // static int findParent(int c, int d) {

    // if (parent[c][d] != 0) {
    // return parent[c][d];
    // }

    // return parent[c][d] = findParent(findParent(c, d-1), );

    // }

    // private static class Node{
    // int child;
    // Node parent;

    // Node(int child, Node parent){
    // this.child = child;
    // this.parent = parent;
    // }
    // }
}
