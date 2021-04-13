package BOJ;

import java.util.Collections;
import java.util.*;

/**
 * BOJ1300 K번째 수 이분탐색
 */
public class BOJ1300 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int k = Integer.parseInt(sc.nextLine());

        int answer = 0;

        int min = 1;
        int max = k;

        while (min <= max) {
            int mid = (min + max) / 2;
            int cnt = 0;

            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }

            if (cnt < k) {
                min = mid + 1;
            } else {
                answer = mid;
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }
}