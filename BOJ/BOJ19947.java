package BOJ;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 투자의 귀재 배주형
 */
public class BOJ19947 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        dp = new int[Y + 1];
        dp[0] = H;

        System.out.println(findDP(Y));
    }

    static int[] dp;

    static int findDP(int y) {

        if (dp[y] != 0) {
            return dp[y];
        }

        int temp = (int) (findDP(y-1) * 1.05);

        if (y >= 3) {
            temp = Math.max(temp, (int) (findDP(y-3) * 1.20));
        }

        if (y >= 5) {
            temp = Math.max(temp, (int) (findDP(y-5) * 1.35));
        }

        return dp[y] = temp;
    }
}