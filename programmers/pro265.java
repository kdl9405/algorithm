package programmers;

public class pro265 {

    public long solution(int[] sequence) {
        int N = sequence.length;
        long[][] dp = new long[N + 1][2];
        long answer = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            dp[i + 1][0] = ((i % 2 == 0 ? 1 : -1) * sequence[i]);
            dp[i + 1][1] = ((i % 2 == 0 ? -1 : 1) * sequence[i]);
            if (dp[i][0] > 0) {
                dp[i + 1][0] += dp[i][0];
            }
            if (dp[i][1] > 0) {
                dp[i + 1][1] += dp[i][1];
            }
            answer = Math.max(answer, Math.max(dp[i + 1][0], dp[i + 1][1]));
        }
        return answer;
    }
}
