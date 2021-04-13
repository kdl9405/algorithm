package BOJ;

import java.util.*;
import java.io.*;

public class BOJ2206 {

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static int[][] map;
    static int[][] visit;

    static int n,m;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(s[j]);
                visit[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }

    static void bfs(int x, int y){
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{x,y,1,0});
        visit[x][y] = 0;

        while (!queue.isEmpty()) {
            Integer[] point = queue.poll();
            if (point[0] == n-1 && point[1] == m-1 ) {
                result = point[2];
                break;
            }

            for(int i = 0; i<4; i++){
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if (nx<0 || ny<0 || nx>= n || ny>=m) {
                    continue;
                }
                if (visit[nx][ny] <= point[3]) {
                    continue;
                }
                if (map[nx][ny] ==0) {
                    visit[nx][ny] = point[3];
                    queue.offer(new Integer[]{nx,ny,point[2]+1, point[3]});
                }else{
                    if (point[3] == 0) {
                        visit[nx][ny] = 1;
                        queue.offer(new Integer[]{nx,ny,point[2]+1, 1});
                    }
                }
            }
        }
    }
}
