package BOJ;

import java.util.*;
import java.io.*;

// dfs는 시간초과

public class BOJ2178 {

    static int[][] map;
    static boolean[][] visit;
    static int n, m;
    static int min = Integer.MAX_VALUE;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i = 0; i<n; i++){
            String[] s = br.readLine().split("");
            for(int j = 0; j<m; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        // dfs(0, 0, 1);

        bfs(0, 0);


        System.out.println(map[n-1][m-1]);


    }

    static void bfs(int x, int y){
        visit[x][y] = true;

        Queue<Integer[]> queue = new LinkedList<>();

        queue.offer(new Integer[]{x,y});

        while (!queue.isEmpty()) {

            int x1 = queue.peek()[0];
            int y1 = queue.peek()[1];
            queue.poll();

            if (x1 == n-1 && y1 == m-1) {
                return; 
            }

            for(int i = 0; i<4; i++){
                int nx = x1+dx[i];
                int ny = y1+dy[i];
    
                if (nx >=0 && nx<n && ny>=0 && ny<m ) {
                    if (map[nx][ny] == 1 && !visit[nx][ny]) {
                        queue.offer(new Integer[]{nx,ny});
                        visit[nx][ny] = true;
                        map[nx][ny] = map[x1][y1]+1;
                       
                    }
                }
            }
                       
        }

        return;
        
    }

    static void dfs(int x, int y, int depth){

        if (x == n-1 && y== m-1) {
            min = Math.min(min, depth);
            return;
        }

        if (depth >= min) {
            return;
        }

        visit[x][y] = true;

        for(int i = 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx >=0 && nx<n && ny>=0 && ny<m ) {
                if (map[nx][ny] == 1 && !visit[nx][ny]) {
                    visit[nx][ny] = true;
                    dfs(nx, ny, depth+1);
                    visit[nx][ny] = false;
                }
            }
        }
    }
}
