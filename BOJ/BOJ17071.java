package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 숨바꼭질 5
 */
public class BOJ17071 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int time = 0;

        if (n != k) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(n);

            boolean[][] visit = new boolean[2][500001];

            while (true) {

                time++;
                k += time;

                int x = time % 2;

                if (k > 500000) {
                    time = -1;
                    break;
                }

                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    int now = queue.poll();
                    int y = now - 1;

                    if (y >= 0 && !visit[x][y]) {
                        queue.add(y);
                        visit[x][y] = true;
                    }

                    y = now + 1;
                    if (y <= 500000 && !visit[x][y]) {
                        queue.add(y);
                        visit[x][y] = true;
                    }

                    y = now * 2;
                    if (y <= 500000 && !visit[x][y]) {
                        queue.add(y);
                        visit[x][y] = true;
                    }

                }

                System.out.println("time = " + time + " k = " + k + " n = " + queue);

                if (visit[x][k]) {
                    break;
                }

            }

        }

        System.out.println(time);

    }
}
