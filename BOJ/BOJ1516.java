package BOJ;

/**
 * 
 * 게임 개발
 * 
*/

import java.io.*;
import java.util.*;

public class BOJ1516 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ1516().solution();

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
    Build[] buildSequence;
    int[] dp;

    private class Build {
        int num;
        Build previous;

        Build(int num, Build previous) {
            this.num = num;
            this.previous = previous;
        }
    }

    void addSequence(int num, int previousNum) {

        if (buildSequence[num] == null) {
            buildSequence[num] = new Build(previousNum, null);
        } else {
            buildSequence[num] = new Build(previousNum, buildSequence[num]);
        }
    }

    void init() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        time = new int[N + 1];
        buildSequence = new Build[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) {
                    break;
                }

                addSequence(i, x);
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

        for (Build previous = buildSequence[num]; previous != null; previous = previous.previous) {

            need = Math.max(need, getNeedTime(previous.num));
           
        }

        return dp[num]+=need;
    }
}