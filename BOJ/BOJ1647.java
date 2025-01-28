package boj;

import java.io.*;
import java.util.*;

/*
 * 도시 분할 계획
 * 
 * 1. 모든 비용을 계산해놓고 시작. => 필요없음 2. 비용이 작은 것 부터 길 연결 3. 연결된 마을의 부모 마을을 조회. 4. 부모 마을이 2개면 종료.? => 병합
 * 횟수로 조회 가능??
 * 
 */
public class BOJ1647 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        root = new int[N + 1];

        PriorityQueue<roadC> pq = new PriorityQueue<>((r1, r2) -> {
            return r1.cost - r2.cost;
        });

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            pq.add(new roadC(a, b, cost));
        }

        int totalCost = 0;


        while (!pq.isEmpty()) {

            roadC now = pq.poll();

            int a = findRoot(now.a);
            int b = findRoot(now.b);

            if (a == b) {
                continue;
            }

            root[b] = a;

            totalCost += now.cost;
            N--;

            if (N == 2) {
                break;
            }
        }

        System.out.println(totalCost);

    }

    static int N, M;
    static int[] root;

    static int findRoot(int n) {
        if (root[n] == 0) {
            return n;
        }

        return root[n] = findRoot(root[n]);
    }
}


class roadC {

    int a;
    int b;
    int cost;

    public roadC(int a, int b, int cost) {
        this.a = a;
        this.b = b;
        this.cost = cost;
    }
}
