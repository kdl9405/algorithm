package gooorm;

import java.io.*;
import java.util.*;

/* 
    외발 뛰기
*/

public class g5 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        visit = new boolean[n][n];

        if (BFS()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static int n;
    static int[][] map;
    static boolean[][] visit;

    static boolean BFS() {

        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[] { 0, 0 });
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == n - 1 && now[1] == n - 1) {
                return true;
            }

            int d = map[now[0]][now[1]];

            if (now[0] + d < n && !visit[now[0] + d][now[1]]) {
                visit[now[0] + d][now[1]] = true;
                queue.offer(new int[] { now[0] + d, now[1] });
            }

            if (now[1] + d < n && !visit[now[0]][now[1] + d]) {
                visit[now[0]][now[1] + d] = true;
                queue.offer(new int[] { now[0], now[1] + d });
            }

        }

        return false;

    }

}
