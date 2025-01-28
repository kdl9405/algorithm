package boj;

import java.io.*;
import java.util.*;

/*
 * 최소비용 구하기 2
 * 
 */
public class BOJ11779 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        root = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            root[a].add(new bus(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while (end != start) {
            stack.push(before[end]);
            end = before[end];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(stack.size() + "\n");

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString());

    }

    static int n, m;
    static ArrayList<bus>[] root;
    static int[] before;
    static int[] distance;

    static void dijkstra(int start, int end) {

        boolean[] visit = new boolean[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        before = new int[n + 1];

        PriorityQueue<bus> pq = new PriorityQueue<>((a, b) -> {
            return a.cost - b.cost;
        });

        pq.offer(new bus(start, 0));
        while (!pq.isEmpty()) {

            bus now = pq.poll();

            if (distance[now.to] < now.cost) {
                continue;
            }
            if (end == now.to) {
                break;
            }

            if (visit[now.to]) {
                continue;
            }
            visit[now.to] = true;

            for (bus next : root[now.to]) {

                if (distance[next.to] > distance[now.to] + next.cost) {
                    distance[next.to] = distance[now.to] + next.cost;
                    before[next.to] = now.to;
                    pq.add(new bus(next.to, distance[next.to]));
                }
            }
        }

        System.out.println(distance[end]);

    }
}


class bus {

    int to;
    int cost;

    public bus(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}
