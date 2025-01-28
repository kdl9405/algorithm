package boj;

/*
 * 네트워크 연결
 */

import java.io.*;
import java.util.*;

public class BOJ1922 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        network = new int[N + 1];

        pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new int[] {a, b, c});
        }

        System.out.println(linkNetwork());

    }

    static int N;
    static int[] network;
    static PriorityQueue<int[]> pq;

    static int findNetwork(int x) {
        if (network[x] == 0) {
            return x;
        }

        return network[x] = findNetwork(network[x]);
    }

    static int linkNetwork() {
        int cost = 0;

        int cnt = 0;

        while (!pq.isEmpty()) {
            int[] link = pq.poll();

            int a = findNetwork(link[0]);
            int b = findNetwork(link[1]);

            if (a == b) {
                continue;
            }

            cost += link[2];
            network[b] = a;
            cnt++;
            if (cnt == N - 1) {
                break;
            }
        }

        return cost;
    }
}
