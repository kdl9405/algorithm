package BOJ;

import java.io.*;
import java.util.*;

/* 
    리모컨
*/
public class BOJ1107_refactoring1 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ1107_refactoring1().solution();
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

        int count = Math.abs(N - 100);

        if (!isBroken[0]) {
            count = Math.min(count, N + 1);
        }

        if (isPossible(N)) {
            count = Math.min(count, Integer.toString(N).length());
        } else {

            int target = N;
            // up
            while (true) {
                target++;

                if (Integer.toString(target).length() + (target - N) >= count) {
                    break;
                }

                if (isPossible(target)) {
                    count = Integer.toString(target).length() + (target - N);
                    break;
                }
            }

            target = N;
            // down
            while (true) {
                target--;

                if (target <= 0) {
                    break;
                }

                if (Integer.toString(target).length() + (N - target) >= count) {
                    break;
                }

                if (isPossible(target)) {
                    count = Integer.toString(target).length() + (N - target);
                    break;
                }
            }

        }

        return count;

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
