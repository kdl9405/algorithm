package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 
    연결 요소의 개수
*/

public class BJ11724 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        line = new boolean[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            line[a][b] = true;
            line[b][a] = true;

        }

        count = 0;

        for(int i = 1; i<=n; i++){
            if (!visit[i]) {
                count++;
                bfs(i);
            }
        }

        System.out.println(count);

    }

    static boolean[][] line;
    static boolean[] visit;
    static int count;

    static void bfs(int n) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (true) {

            Queue<Integer> temp = new LinkedList<>();

            while (!queue.isEmpty()) {
                int p = queue.poll();
                if (!visit[p]) {
                    visit[p] = true;

                    for (int i = 1; i < line.length; i++) {
                        if (line[p][i] && !visit[i]) {
                            temp.add(i);
                        }
                    }
                    
                }

            }
            if (temp.isEmpty()) {
                break;
            }
            queue.addAll(temp);
        }
    }
}
