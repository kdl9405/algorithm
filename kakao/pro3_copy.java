package kakao;

import java.io.*;
import java.util.*;

public class pro3_copy {

    public static void main(String[] args) {
        int n = 11;
        int[] passenger = { 1, 7, 3, 5, 5, 1, 1, 1, 1, 10 };
        int[][] train = { { 1, 2 }, { 3, 2 }, { 5, 1 }, { 4, 5 }, { 1, 6 }, { 6, 7 }, { 7, 8 }, { 8, 9 }, { 10, 1 } };

        long beforeTime = System.currentTimeMillis();

        int[] answer = solution(n, passenger, train);

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); // 두 시간에 차 계산
        System.out.println("시간차이(ms) : " + secDiffTime);

        System.out.println(answer[0] + " " + answer[1]);
    }

    static ArrayList<Integer>[] road;
    static int[] dp;
    static boolean[] visit;
    static int[] answer;

    public static int[] solution(int n, int[] passenger, int[][] train) {
        answer = new int[2];

        road = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            road[i] = new ArrayList<>();
        }

        dp = new int[n + 1];
        visit = new boolean[n + 1];

        for (int[] r : train) {
            road[r[0]].add(r[1]);
            road[r[1]].add(r[0]);
        }

        fillDP(1, passenger);

        for(int i = 0; i<dp.length; i++){
            System.out.println(i+" "+dp[i]);
        }

        return answer;
    }

    static void fillDP(int p, int[] passenger) {
        visit[p] = true;

        dp[p] += passenger[p - 1];

        for (int next : road[p]) {
            if (visit[next]) {
                continue;
            }
            dp[next] += dp[p];
            fillDP(next, passenger);
        }

        if (dp[p] >= answer[1]) {
            answer[1] = dp[p];
            answer[0] = p;
        }
    }
}
