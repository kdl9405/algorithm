package BOJ;

/* 
    트리의 독립집합
*/

import java.io.*;
import java.util.*;

public class BOJ2213 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        init();

        findDP(1);

        StringBuilder answer = new StringBuilder();
        group = new ArrayList<>();
        visit = new boolean[n+1];
        if (dp[1][0]> dp[1][1]) { 
            answer.append(dp[1][0]).append("\n");           
            trace(1, false);
        }else{
            answer.append(dp[1][1]).append("\n");           
            trace(1, true);
        }

        Collections.sort(group);
        for(int v : group){
            answer.append(v).append(" ");
        }

        System.out.println(answer.toString().trim());

    }

    static int n;
    static int[] w;
    static Node[] G;
    static int[][] dp; // i의 독립 집합 여부에 따른 최대 가중치
    static boolean[] visit;
    static List<Integer> group;

    static void init() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        w = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        G = new Node[n + 1];

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            insert(a, b);
            insert(b, a);
        }

        dp = new int[n + 1][2];
        visit = new boolean[n + 1];
    }

    private static class Node {

        int num;
        Node parent;

        Node(int num, Node parent) {
            this.num = num;
            this.parent = parent;
        }
    }

    static void insert(int p, int c) {
        if (G[p] == null) {
            G[p] = new Node(c, null);
        } else {
            G[p] = new Node(c, G[p]);
        }
    }

    static void findDP(int x) {

        visit[x] = true;
        dp[x][1] = w[x];

        Node v = G[x];
        while (v != null) {

            if (visit[v.num]) {
                v = v.parent;
                continue;
            }

            findDP(v.num);

            dp[x][0] += Math.max(dp[v.num][0], dp[v.num][1]);
            dp[x][1] += dp[v.num][0];

            v = v.parent;
        }
    }

    static void trace(int x, boolean state) {

        visit[x] = true;

        if (state) {
            group.add(x);

            Node v = G[x];
            while (v != null) {

                if (visit[v.num]) {
                    v = v.parent;
                    continue;
                }

                trace(v.num, false);

                v = v.parent;
            }
           

        } else {

            Node v = G[x];
            while (v != null) {

                if (visit[v.num]) {
                    v = v.parent;
                    continue;
                }

                if (dp[v.num][1] > dp[v.num][0]) {
                    trace(v.num, true);
                } else {
                    trace(v.num, false);
                }

                v = v.parent;
            }

        }

    }

}