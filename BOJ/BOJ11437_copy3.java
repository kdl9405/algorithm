package BOJ;

/* 
    LCA


    1`. 누가 조상인지 모른다..  단순히 그냥 연결관계인지만 알 수 있을 뿐.
*/

import java.io.*;
import java.util.*;

public class BOJ11437_copy3 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        depth = new int[N + 1];
        parent = new int[N + 1];

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            add(a, b);
            add(b, a);
        }

        visit = new boolean[N + 1];
        makeTree(1, 1);

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

    static Node[] tree;
    static int[] depth;
    static int[] parent;
    static boolean[] visit;

    private static class Node {

        int num;
        Node child;

        Node(int num, Node child) {
            this.num = num;
            this.child = child;
        }
    }

    private static void add(int parent, int child) {

        if (tree[parent] == null) {
            tree[parent] = new Node(child, tree[0]);
        } else {
            tree[parent] = new Node(child, tree[parent]);
        }

    }

    private static int makeTree(int num, int d) {

        if (num == 0) {
            return d;
        }

        visit[num] = true;

        int x = d;

        for (Node e = tree[num]; e != null; e = e.child) {

            if (visit[e.num]) {
                continue;
            }

            makeTree(e.num, d + 1);
            parent[e.num] = num;

        }

        return depth[num] = x;

    }

    private static int findLCA(int a, int b) {

        while (depth[a] > depth[b]) {
            a = parent[a];
        }
        while (depth[b] > depth[a]) {
            b = parent[b];
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

}
