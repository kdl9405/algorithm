package boj;


import java.util.*;
import java.io.*;

public class BOJ2606 {

    static int[][] connect;
    static boolean[] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        connect = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            connect[a][b] = 1;
            connect[b][a] = 1;
        }

        System.out.println(bfs(1));


    }

    static int bfs(int i) {

        Queue<Integer> queue = new LinkedList<>();

        visit[i] = true;

        queue.offer(i);
        int count = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int j = 1; j < visit.length; j++) {
                if (connect[x][j] == 1 && !visit[j]) {
                    queue.offer(j);
                    visit[j] = true;
                    count++;
                }
            }
        }

        return count;

    }
}
