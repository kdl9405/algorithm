package programmers;

import java.util.*;

/**
 * [카카오 인턴] 경주로 건설 98
 */
public class pro113 {

    public static void main(String[] args) {
        int[][] board = { { 0, 0, 1, 0, 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 1, 1,
        0, 1 },
        { 1, 0, 0, 0, 0, 1, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0,
        0, 0, 1, 0, 1, 0, 1, 1 },
        { 0, 0, 1, 0, 1, 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1, 0, 0, 0, 1, 0 }, { 1, 0,
        0, 1, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 } };

        // int[][] board = { { 0, 0, 0, 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 0, 0 },
        //         { 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0, 0, 1, 0 },
        //         { 0, 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 } };

        System.out.println(solution(board));
    }

    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int answer;
    static int[][] map;
    static int len;

    static int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        len = board.length;
        map = board.clone();

        bfs(0, 0, 0, -1);
        return answer;
    }

    static void bfs(int x, int y, int cost, int dir){
        Queue<road> queue = new LinkedList<>();

        queue.offer(new road(x, y, cost, dir));

        map[x][y] = 1;

        while (!queue.isEmpty()) {

            road now = queue.poll();

            if (now.x == len-1 && now.y == len-1) {
                answer = Math.min(answer, now.cost);
                continue;
            }

            for(int i = 0; i<4; i++){
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];

                if (nx >=0 && nx<len && ny>=0 && ny<len) {
                    if (map[nx][ny] != 1) {
                        int c = 0;

                        if (now.dir == -1 || now.dir == i) {
                            c = now.cost + 100;
                        }else if(now.dir != i){
                            c = now.cost + 600;
                        }

                        if (map[nx][ny] == 0) {
                            map[nx][ny] = c;
                            queue.add(new road(nx, ny, c, i));
                        }else if(map[nx][ny] > c){
                            map[nx][ny] = c;
                            queue.add(new road(nx, ny, c, i));
                        }
                    }
                }
            }
            
        }

    }
}

class road {
    int x, y, cost, dir;

    public road(int x, int y, int cost, int dir){
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
}