package programmers;

/* 
    스티커 모으기(2)

    no IDE
*/
public class pro220 {


    public int solution(int sticker[]) {
        int answer = 0;

        int len = sticker.length;

        if (len <= 2) {
            for (int s : sticker) {
                answer = Math.max(answer, s);
            }

            return answer;
        }

        dp = new int[sticker.length][2];

        dp[0][0] = sticker[0];
        dp[1][0] = Math.max(sticker[0], sticker[1]);
        dp[1][1] = sticker[1];

        answer = Math.max(findDP(len - 2, 0, sticker), findDP(len - 3, 1, sticker) + sticker[len - 1]);

        return answer;
    }

    static int[][] dp; // 맨 처음을 뜯는 경우, 뜯지 않는 경우.

    static int findDP(int n, int c, int[] sticker) {

        if (n <= 1) {
            return dp[n][c];
        }

        if (dp[n][c] != 0) {
            return dp[n][c];
        }

        return dp[n][c] = Math.max(findDP(n - 2, c, sticker) + sticker[n], findDP(n - 1, c, sticker));

    }

}
