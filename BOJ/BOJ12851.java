package boj;

import java.io.*;
import java.util.*;

/*
 * 숨바꼭질 2
 */
public class BOJ12851 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0 + "\n" + 1);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int count = 0;
        boolean[] visit = new boolean[100001];

        int time = 0;
        boolean finish = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {
                int now = queue.poll();

                visit[now] = true;

                int a = now - 1;
                int b = now + 1;
                int c = now * 2;

                if (a == k || b == k || c == k) {
                    finish = true;
                }

                if (a >= 0 && !visit[a]) {
                    queue.add(a);
                }
                if (b <= 100000 && !visit[b]) {
                    queue.add(b);
                }
                if (c >= 0 && c <= 100000 && !visit[c]) {
                    queue.add(c);
                }

            }
            time++;

            if (finish) {
                while (!queue.isEmpty()) {
                    if (k == queue.poll()) {
                        count++;
                    }
                }
                break;
            }
        }

        System.out.println(time + "\n" + count);

    }

    static int[] dp;
}
