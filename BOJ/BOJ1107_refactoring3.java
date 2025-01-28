package boj;

import java.io.*;
import java.util.*;

/*
 * 리모컨
 * 
 * 2. DP
 */
public class BOJ1107_refactoring3 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ1107_refactoring3().solution();
    }

    void solution() throws NumberFormatException, IOException {

        init();

        System.out.println(Math.min(findUpDP(N), findDownDP(N)));

        // System.out.println(findUpDP(N));
    }

    int N;
    boolean[] isBroken;
    int[] upDp;
    int[] downDp;
    int INF;

    void init() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        isBroken = new boolean[10];
        int M = Integer.parseInt(br.readLine());

        if (M == 0) {
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (M-- > 0) {
            isBroken[Integer.parseInt(st.nextToken())] = true;
        }

        INF = Math.abs(N - 100);

        upDp = new int[1000001];
        downDp = new int[N * 2 + 1];

        Arrays.fill(upDp, -1);
        Arrays.fill(downDp, -1);

        upDp[100] = 0;
        downDp[100] = 0;
    }

    int findUpDP(int n) {

        if (n > N + INF) {
            return INF - 1;
        }

        if (upDp[n] != -1) {
            return upDp[n];
        }

        if (isPossible(n)) {
            upDp[n] = Integer.toString(n).length();
        }

        return upDp[n] = Math.min(upDp[n], findUpDP(n + 1) + 1);
    }

    int findDownDP(int n) {

        if (n < 0) {
            return INF;
        }

        if (downDp[n] != -1) {
            return downDp[n];
        }

        if (isPossible(n)) {
            downDp[n] = Integer.toString(n).length();
        }

        return downDp[n] = Math.min(downDp[n], findDownDP(n - 1) + 1);
    }

    boolean isPossible(int ch) {
        char[] arr = Integer.toString(ch).toCharArray();

        for (char c : arr) {
            if (isBroken[c - '0']) {
                return false;
            }
        }

        return true;
    }

}
