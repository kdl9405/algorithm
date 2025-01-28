
package boj;

/**
 * 
 * 사회망 서비스(SNS)
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ2533_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        init();

        findDP(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static int N;
    static List<List<Integer>> friends;
    static int[][] dp; // i번 친구가 얼리어답터인 경우 = 1 / 아닌 경우 = 0
    static boolean[] visit;

    static void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        friends = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            friends.add(new LinkedList<>());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        dp = new int[N + 1][2];
        visit = new boolean[N + 1];
    }

    static void findDP(int x) {

        visit[x] = true;
        dp[x][1] = 1;

        for (int friend : friends.get(x)) {
            if (visit[friend]) {
                continue;
            }

            findDP(friend);

            dp[x][0] += dp[friend][1];
            dp[x][1] += Math.min(dp[friend][0], dp[friend][1]);
        }

    }


}
