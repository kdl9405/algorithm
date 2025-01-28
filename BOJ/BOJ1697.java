package boj;

import java.io.*;
import java.util.*;

public class BOJ1697 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[1000001];

        if (k <= n) {
            System.out.println(n - k);
            System.out.close();
        }

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> tempQ;


        queue.offer(n);

        int day = 0;

        while (true) {

            if (queue.contains(k)) {
                break;
            }

            day++;

            tempQ = new LinkedList<>();

            while (!queue.isEmpty()) {
                int now = queue.poll();
                visit[now] = true;

                if (now - 1 >= 0 && !visit[now - 1]) {
                    tempQ.offer(now - 1);
                }
                if (now + 1 <= 1000000 && !visit[now + 1]) {
                    tempQ.offer(now + 1);
                }
                if (now * 2 <= 1000000 && !visit[now * 2]) {
                    tempQ.offer(now * 2);
                }
            }

            queue.addAll(tempQ);
        }

        System.out.println(day);

    }
}
