package boj;

/**
 * 
 * 게임 개발
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ1516_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ1516_copy().solution();

    }

    void solution() throws NumberFormatException, IOException {

        init();

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            answer.append(getNeedTime(i)).append("\n");
        }
        System.out.println(answer.toString().trim());

    }

    int N;
    int[] time;
    List<List<Integer>> previous;
    int[] dp;

    void init() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        time = new int[N + 1];
        previous = new ArrayList<>();
        previous.add(new ArrayList<>());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            previous.add(new ArrayList<>());

            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) {
                    break;
                }

                previous.get(i).add(x);
            }
        }

        dp = new int[N + 1];
    }

    int getNeedTime(int num) {

        if (dp[num] != 0) {
            return dp[num];
        }

        dp[num] = time[num];

        int need = 0;

        for (int p : previous.get(num)) {
            need = Math.max(need, getNeedTime(p));
        }

        return dp[num] += need;
    }
}
