package BOJ;

import java.io.*;
import java.util.*;

/* 
    점프 점프

*/
public class BOJ14282 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] stones = new int[n];
        stones = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] visit = new boolean[n];

        int s = Integer.parseInt(br.readLine());
        s--;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visit[s] = true;

        int count = 1;
        while (!queue.isEmpty()) {

            int x = queue.poll();
            int next = x - stones[x];

            if (next >= 0 && !visit[next]) {
                visit[next] = true;
                count++;
                queue.add(next);
            }

            next = x + stones[x];
            if (next < n && !visit[next]) {
                visit[next] = true;
                count++;
                queue.add(next);
            }
        }

        System.out.println(count);

    }
}
