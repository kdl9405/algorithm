package boj;

import java.io.*;
import java.util.*;

/*
 * 숨바꼭질 2
 * 
 * 시간초과
 */
public class BOJ12851_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        dp = new int[100001];
        dp[n] = 1;
        int count = 0;

        loop: while (!queue.isEmpty()) {
            int size = queue.size();
            int[] temp = dp.clone();
            while (size-- > 0) {
                int now = queue.poll();

                if (now == k) {
                    break loop;
                }

                int a = now - 1;
                int b = now + 1;
                int c = now * 2;

                if (a >= 0) {
                    if (temp[a] == 0) {
                        queue.add(a);
                    }
                    temp[a] += dp[now];
                }

                if (b < 100000) {
                    if (temp[b] == 0) {
                        queue.add(b);
                    }
                    temp[b] += dp[now];
                }
                if (c >= 0 && c < 100000) {
                    if (temp[c] == 0) {
                        queue.add(c);
                    }
                    temp[c] += dp[now];
                }
            }

            dp = temp.clone();

            count++;
        }

        System.out.println(count + "\n" + dp[k]);

    }

    static int[] dp;
}
