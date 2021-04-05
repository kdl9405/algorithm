package kakao;

import java.io.*;
import java.util.*;

public class pro3 {

    public static void main(String[] args) {
        int n = 6;
        int[] passenger = { 1, 1, 1, 1, 1 };
        int[][] train = { { 5, 1 }, { 3, 5 } };

        int[] answer = solution(n, passenger, train);

        System.out.println(answer[0] + " " + answer[1]);
    }

    static int[] dp;

    public static int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = new int[2];

        Arrays.sort(train, (t1, t2) -> {
            if (Math.min(t1[0], t1[1]) == Math.min(t2[0], t2[1])) {
                return (t1[0]+t1[1]) - (t2[0]+t2[1]);
            }
            return Math.min(t1[0], t1[1]) - Math.min(t2[0], t2[1]);
        });

        dp = new int[n + 1];
        dp[1] = passenger[0];

        for (int[] road : train) {

            if (dp[road[0]] == 0) {
                dp[road[0]] = (dp[road[1]] + passenger[road[0] - 1]);
            } else {
                dp[road[1]] = (dp[road[0]] + passenger[road[1] - 1]);
            }

        }

        for (int i = 1; i <= n; i++) {
            if (dp[i] >= answer[1]) {
                answer[1] = dp[i];
                answer[0] = i;
            }
        }

        return answer;
    }
}
