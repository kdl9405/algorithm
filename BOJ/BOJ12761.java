package BOJ;

/* 
    돌다리
*/

import java.io.*;
import java.util.*;

public class BOJ12761 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] d = { 1, -1, A, -A, B, -B };

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        int count = 0;

        boolean[] visit = new boolean[100001];
        visit[N] = true;

        loop: while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {
                int now = queue.poll();

                if (now == M) {
                    break loop;
                }

                for (int i = 0; i < 6; i++) {
                    int nx = now + d[i];

                    if (nx >= 0 && nx <= 100000 && !visit[nx]) {
                        visit[nx] = true;
                        queue.offer(nx);
                    }
                }

                if (now*A<=100000 && !visit[now*A]) {
                    visit[now*A] = true;
                    queue.offer(now*A);
                }
                
                if (now*B<=100000 && !visit[now*B]) {
                    visit[now*B] = true;
                    queue.offer(now*B);
                }

            }

            count++;

        }

        System.out.println(count);

    }

}
