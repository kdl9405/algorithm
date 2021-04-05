package kakao;

import java.io.*;
import java.util.*;

public class pro3_copy {

    public static void main(String[] args) {
        int n = 6;
        int[] passenger = { 1,1,1,1,1};
        int[][] train = { { 5, 1 }, { 5, 3 }};

        int[] answer = solution(n, passenger, train);

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
