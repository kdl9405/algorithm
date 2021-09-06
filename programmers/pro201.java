package programmers;

import java.util.*;

/* 
    게임 맵 최단거리
*/

public class pro201 {

    public static void main(String[] args) {

    }

    public int solution(int[][] maps) {
        int answer = 0;

        int n = maps.length;
        int m = maps[0].length;

        boolean find = false;


        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});

        loop:
        while (!queue.isEmpty()) {
        
            int size = queue.size();
            answer++;

            while (size-- > 0) {
                int[] now = queue.poll();

                for(int i = 0; i<4; i++){
                    int nx = now[0]+dx[i];
                    int ny = now[1]+dy[i];

                    if(nx == n && ny == m){
                        find = true;
                        break loop;
                    }

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (maps[nx][ny] != 0) {
                            queue.add(new int[]{nx,ny});
                            maps[nx][ny] = 0;
                        }
                    }
                }
            }
        }

        if (!find) {
            answer = -1;
        }

        return answer;
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
}
