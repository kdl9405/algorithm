package boj;

import java.io.*;
import java.util.*;

/*
 * 최소비용 구하기
 */
public class BOJ1916 {

    static int INF = 200000000;
    static ArrayList<ArrayList<bus>> root;
    static int[] total_cost;
    static boolean[] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        root = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            root.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int fee = Integer.parseInt(st.nextToken());

            root.get(from).add(new bus(to, fee));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        total_cost = new int[N + 1];
        Arrays.fill(total_cost, INF);
        visit = new boolean[N + 1];

        System.out.println(dijkstra(start, end));

    }

    static int dijkstra(int start, int end) {

        total_cost[start] = 0;

        PriorityQueue<bus> pq = new PriorityQueue<>((b1, b2) -> {
            return b1.cost - b2.cost;
        });

        pq.add(new bus(start, 0));

        while (!pq.isEmpty()) {
            bus now = pq.poll();

            if (visit[now.next]) {
                continue;
            }

            visit[now.next] = true;

            if (now.next == end) {
                break;
            }

            for (bus nBus : root.get(now.next)) {

                int temp = total_cost[now.next] + nBus.cost;

                if (!visit[nBus.next] && total_cost[nBus.next] > temp) {
                    total_cost[nBus.next] = temp;
                    pq.add(new bus(nBus.next, temp));
                }
            }
        }

        return total_cost[end];
    }



}


class bus {
    int next;
    int cost;

    public bus(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }
}
