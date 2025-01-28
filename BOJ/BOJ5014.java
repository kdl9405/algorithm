package boj;

import java.io.*;
import java.util.*;

public class BOJ5014 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] min = new int[F + 1];
        Arrays.fill(min, -1);
        min[S] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == G) {
                break;
            }

            if (now + U <= F && min[now + U] == -1) {
                min[now + U] = min[now] + 1;
                queue.add(now + U);
            }

            if (0 < now - D && min[now - D] == -1) {
                min[now - D] = min[now] + 1;
                queue.add(now - D);
            }

        }

        if (min[G] == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(min[G]);
        }

    }
}
