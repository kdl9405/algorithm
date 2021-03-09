package BJ;

import java.util.*;
import java.io.*;

/**
 * BJ2667
 */
public class BJ2667 {

    static int[][] map;
    static boolean[][] visit;
    static HashMap<Integer, Integer> hash = new HashMap<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visit = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        int hnum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    hnum++;
                    dfs(i, j, hnum);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        list.addAll(hash.values()); 

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(hnum+"\n");
        
        for(Integer i : list){
            sb.append(i+"\n");
        }

        System.out.println(sb);

    }

    static void dfs(int x, int y, int hnum){
        visit[x][y] = true;
        hash.put(hnum, hash.getOrDefault(hnum, 0)+1);

        for(int i = 0; i<4; i++){

            int nx = x+dx[i];
            int ny = y+dy[i];

            if (nx >=0 && nx<visit.length && ny >=0 && ny<visit.length) {
                if (!visit[nx][ny] && map[nx][ny] ==1) {
                    dfs(nx, ny, hnum);
                }
            }
        }

    }
}