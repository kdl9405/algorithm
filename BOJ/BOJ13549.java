package BOJ;

import java.io.*;
import java.util.*;

/* 
    숨바꼭질 3
*/
public class BOJ13549 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int time = Math.abs(k - n);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        queue.offer(n);
        int count = 0;

        loop: while (true) {

            if (count >= time) {
                break;
            }

            HashSet<Integer> temp = new HashSet<>();

            while (!queue.isEmpty()) {
                int current = queue.poll();

                temp.add(current);

                if (current != 0) {
                    for (int i = current; i <= k + time; i *= 2) {

                        if (!visit[i]) {

                            visit[i] = true;

                            temp.add(i);

                            if (i == k) {
                                break loop;
                            }
                        }
                    }
                }

            }

            System.out.println("temp " + temp);

            count++;

            HashSet<Integer> next = new HashSet<>();

            for (Integer q : temp) {

                if (q - 1 == k || q + 1 == k) {
                    break loop;
                }
                if (q - 1 > 0 && !visit[q - 1]) {
                    next.add(q - 1);
                    visit[q - 1] = true;
                }
                if (!visit[q + 1]) {
                    next.add(q + 1);
                    visit[q + 1] = true;

                }
            }

            queue.addAll(next);
            System.out.println("queue " + queue);

        }

        System.out.println(count);

    }

    static boolean[] visit = new boolean[2000002];

}
