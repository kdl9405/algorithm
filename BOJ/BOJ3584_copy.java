package boj;

/*
 * 가장 가까운 공통 조상
 */

import java.io.*;
import java.util.*;

public class BOJ3584_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            depth = new int[N + 1];
            boolean[] isNotRoot = new boolean[N + 1];

            children = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                children.add(new ArrayList<>());
            }

            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                children.get(a).add(b);
                isNotRoot[b] = true;

            }

            int rootIdx = 0;
            for (int i = 1; i <= N; i++) {
                if (!isNotRoot[i]) {
                    rootIdx = i;
                    break;
                }
            }

            setParent(rootIdx, 0, 1);

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(LCA(a, b)).append("\n");

        }

        System.out.println(sb.toString().trim());

    }

    static int N;
    static List<List<Integer>> children;
    static int[] parent;
    static int[] depth;

    static void setParent(int c, int p, int d) {
        depth[c] = d;
        parent[c] = p;

        for (int child : children.get(c)) {
            if (child != p) {
                setParent(child, c, d + 1);
            }
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
