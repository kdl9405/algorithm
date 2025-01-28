package boj;

import java.io.*;
import java.util.*;

/*
 * 최소 스패닝 트리
 */

public class BOJ1197 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<line> pq = new PriorityQueue<>((a, b) -> {
            return a.c - b.c;
        });

        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new line(a, b, c));

        }

        long answer = 0;

        parent = new int[V + 1];

        while (!pq.isEmpty()) {

            line now = pq.poll();

            int x = findParent(now.a);
            int y = findParent(now.b);

            if (x != y) {
                parent[y] = x;
                answer += now.c;
            }
        }

        System.out.println(answer);



    }

    static int[] parent;
    static long INF = (100000 * 1000000);

    static int findParent(int x) {

        if (parent[x] == 0) {
            return parent[x] = x;
        }

        if (parent[x] == x) {
            return x;
        }
        return parent[x] = findParent(parent[x]);
    }
}


class line {
    int a;
    int b;
    int c;

    public line(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}
