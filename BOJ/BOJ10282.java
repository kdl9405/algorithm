package boj;

import java.io.*;
import java.util.*;

/*
 * 해킹
 * 
 * 시작지점부터 시작해서 가장 먼 시간의 지점을 찾음.
 * 
 */

public class BOJ10282 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<List<int[]>> link = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                link.add(new ArrayList<>());
            }

            while (d-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                link.get(b).add(new int[] {a, s});
            }

            int[] distance = new int[n + 1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[c] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
                return x[1] - y[1];
            });
            pq.add(new int[] {c, 0});

            while (!pq.isEmpty()) {
                int[] now = pq.poll();

                if (now[1] > distance[now[0]]) {
                    continue;
                }

                for (int[] next : link.get(now[0])) {
                    if (distance[next[0]] > distance[now[0]] + next[1]) {
                        distance[next[0]] = distance[now[0]] + next[1];
                        pq.offer(new int[] {next[0], distance[next[0]]});
                    }
                }
            }

            int max = 0;
            int cnt = n;
            for (int i = 1; i <= n; i++) {
                if (distance[i] == Integer.MAX_VALUE) {
                    cnt--;
                    continue;
                }
                max = Integer.max(max, distance[i]);
            }

            sb.append(cnt + " " + max + "\n");

        }

        System.out.println(sb.toString());
    }
}
