package programmers;

/*
 * 코딩테스트 연습 연습문제 카운트 다운
 */
public class pro288 {


    public int[] solution(int target) {

        int[][] dp = new int[target + 1][2];
        for (int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= target; i++) {

            for (int s = 1; s <= 20; s++) {
                update(dp, i, s, 1);
            }
            update(dp, i, 50, 1);

            for (int s = 1; s <= 20; s++) {
                update(dp, i, s * 2, 0);
                update(dp, i, s * 3, 0);
            }
        }

        return dp[target];

    }

    private void update(int[][] dp, int current, int score, int sb) {
        if (current < score)
            return;

        int next = current - score;

        if (dp[next][0] != Integer.MAX_VALUE) {

            int newCount = dp[next][0] + 1;
            int newSb = dp[next][1] + sb;

            if (newCount < dp[current][0]) {
                dp[current][0] = newCount;
                dp[current][1] = newSb;
            } else if (newCount == dp[current][0] && dp[current][1] < newSb) {
                dp[current][1] = newSb;
            }
        }

    }
}
