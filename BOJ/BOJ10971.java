package boj;

/*
 * 외판원 순회 2
 */

import java.io.*;
import java.util.*;

public class BOJ10971 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        minCost = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            travel(i, i, 0, 0);
        }

        System.out.println(minCost);

    }

    static int N;
    static int[][] map;
    static int minCost;

    static void travel(int start, int now, int visit, int cost) {

        if (cost > minCost) {
            return;
        }

        if (visit == (1 << N) - 1 && start == now) {
            minCost = Math.min(minCost, cost);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (map[now][i] == 0 || (visit | (1 << i)) == visit) {
                continue;
            }

            travel(start, i, visit | (1 << i), cost + map[now][i]);
        }

        return;
    }
}
