package boj;

import java.io.*;
import java.util.*;

/*
 * 리모컨
 * 
 * 2. bfs
 */
public class BOJ1107_refactoring2 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ1107_refactoring2().solution();
    }

    void solution() throws NumberFormatException, IOException {

        init();

        System.out.println(BFS());

    }

    int N;
    boolean[] isBroken;

    void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        isBroken = new boolean[10];
        int M = Integer.parseInt(br.readLine());

        if (M == 0) {
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            isBroken[Integer.parseInt(st.nextToken())] = true;
        }
    }

    int BFS() {

        boolean[] visit = new boolean[1000000];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1] - b[1];
        });

        pq.add(new int[] {100, 0});
        visit[100] = true;

        int answer = 0;

        while (!pq.isEmpty()) {

            int[] now = pq.poll();

            if (now[0] == N) {
                answer = now[1];
                break;
            }

            if (now[0] + 1 <= N * 2 && !visit[now[0] + 1]) {
                visit[now[0] + 1] = true;

                if (isPossible(now[0] + 1)) {
                    pq.add(new int[] {now[0] + 1,
                            Math.min(now[1] + 1, Integer.toString(now[0] + 1).length())});

                } else {
                    pq.add(new int[] {now[0] + 1, now[1] + 1});

                }

            }

            if (now[0] - 1 >= 0 && !visit[now[0] - 1]) {
                visit[now[0] - 1] = true;

                if (isPossible(now[0] - 1)) {
                    pq.add(new int[] {now[0] - 1,
                            Math.min(now[1] + 1, Integer.toString(now[0] - 1).length())});

                } else {
                    pq.add(new int[] {now[0] - 1, now[1] + 1});
                }

            }
        }

        return answer;

    }

    boolean isPossible(int ch) {
        char[] arr = Integer.toString(ch).toCharArray();

        for (char c : arr) {
            if (isBroken[c - '0']) {
                return false;
            }
        }

        return true;
    }

}
