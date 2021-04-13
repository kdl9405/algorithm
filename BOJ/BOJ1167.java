package BOJ;

import java.io.*;
import java.util.*;

/* 
    트리의 지름

*/
public class BOJ1167 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int V = Integer.parseInt(br.readLine());

        nodes = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            nodes.add(new HashMap<>());
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            while (true) {
                int y = Integer.parseInt(st.nextToken());

                if (y == -1) {
                    break;
                }
                int d = Integer.parseInt(st.nextToken());

                nodes.get(x).put(y, d);
                nodes.get(y).put(x, d);
            }
        }

        visit = new boolean[V + 1];

        dfs(1, 0);
        Arrays.fill(visit, false);
        dfs(last, 0);

        System.out.println(max);

    }

    static ArrayList<HashMap<Integer, Integer>> nodes;
    static boolean[] visit;
    static int last;
    static int max;

    static void dfs(int current, int r) {

        visit[current] = true;

        for(Integer h : nodes.get(current).keySet()){
            if (!visit[h]) {
                dfs(h, r+nodes.get(current).get(h));
            }
        }

        if (max < r) {
            max = r;
            last = current;
        }

        visit[current] = false;
    }
}