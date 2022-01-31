package BOJ;

import java.io.*;
import java.util.*;

/* 
    리모컨

    1. 완탐
*/
public class BOJ1107_refactoring {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ1107_refactoring().solution();
    }

    void solution() throws NumberFormatException, IOException {

        init();

        System.out.println(bruteFroce());

    }

    int N;
    boolean[] isBroken;

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
    }

    int bruteFroce() {

        if (N == 100) {
            return 0;
        }

        int[] count = new int[1000001];
        count[100] = 0;

        if (N < 100) {
            for (int i = 99; i >= N; i--) {

                if (isPossible(i)) {
                    count[i] = Math.min(count[i + 1] + 1, Integer.toString(i).length());
                } else {
                    count[i] = count[i + 1] + 1;
                }
            }

            for (int i = N - 1; i >= 0; i--) {
                if (isPossible(i)) {

                    count[N] = Math.min(count[N], Integer.toString(i).length() + (N - i));

                    break;
                }
            }

        } else {

            for (int i = 101; i <= N; i++) {
                if (isPossible(i)) {
                    count[i] = Math.min(count[i - 1] + 1, Integer.toString(i).length());
                } else {
                    count[i] = count[i - 1] + 1;
                }

            }

            for (int i = N + 1; i < N * 2; i++) {
                if (isPossible(i)) {

                    count[N] = Math.min(count[N], Integer.toString(i).length() + (i - N));

                    break;
                }
            }
        }

        return count[N];
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
