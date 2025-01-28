package boj;

import java.io.*;
import java.util.*;

/*
 * 최소비용 구하기 2
 * 
 * 메모리 초과
 */
public class BOJ11779_copy {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        cost = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            cost.add(new ArrayList<>());
        }

        d = new int[n + 1];

        StringTokenizer st;
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            cost.get(a).add(new int[] {b, c});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(d[end]);

        int count = 1;

        StringBuilder sb = new StringBuilder();
        sb.append(end + " ");

        while (root[end] != 0) {
            sb.append(root[end] + " ");
            end = root[end];
            count++;
        }

        System.out.println(count);
        System.out.println(sb.reverse().toString().trim());

    }

    static int n;
    static List<List<int[]>> cost;
    static int[] d;
    static int[] root;

    static void dijkstra(int start) {

        boolean[] visit = new boolean[n + 1];
        root = new int[n + 1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        pq.add(new int[] {start, 0});

        while (!pq.isEmpty()) {

            int[] now = pq.poll();

            if (visit[now[0]]) {
                continue;
            }
            visit[now[0]] = true;

            if (d[now[0]] != 0 && d[now[0]] < now[1]) {
                break;
            }

            for (int[] next : cost.get(now[0])) {

                if (d[next[0]] != 0 && d[next[0]] < d[now[0]] + next[1]) {
                    continue;
                }

                d[next[0]] = d[now[0]] + next[1];
                pq.add(new int[] {next[0], d[next[0]]});
                root[next[0]] = now[0];

            }

        }
    }
}
