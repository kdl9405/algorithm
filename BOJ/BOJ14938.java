package boj;

import java.io.*;
import java.util.*;

/*
 * 서강그라운드
 */

public class BOJ14938 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        t = new int[n + 1];
        roads = new ArrayList<>();
        roads.add(new HashMap<>());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            t[i] = Integer.parseInt(st.nextToken());

            roads.add(new HashMap<>());
        }

        while (r-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            roads.get(a).put(b, l);
            roads.get(b).put(a, l);
        }

        max = 0;

        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            max = Math.max(max, getItem(i, 0));
        }

        System.out.println(max);
    }

    static int max;
    static int n, m, r;
    static int[] t;
    static List<HashMap<Integer, Integer>> roads;

    static boolean[] visit;

    static int getItem(int x, int d) {

        int count = t[x];

        visit[x] = true;

        for (int next : roads.get(x).keySet()) {

            if (!visit[next]) {
                if (d + roads.get(x).get(next) <= m) {
                    visit[next] = true;
                    count += getItem(next, d + roads.get(x).get(next));
                }
            }

        }

        return count;

    }
}
