package programmers;

import java.util.*;

/**
 * [카카오 인턴] 경주로 건설 95.7
 */
public class pro113_copy {

    public static void main(String[] args) {
        // int[][] board = { { 0, 0, 1, 0, 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 1, 1, 0, 1 },
        //         { 1, 0, 0, 0, 0, 1, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 1, 0, 1, 1 },
        //         { 0, 0, 1, 0, 1, 1, 0, 1, 0, 1 }, { 0, 1, 0, 0, 1, 0, 0, 0, 1, 0 }, { 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
        //         { 0, 0, 0, 0, 0, 1, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0 } };

        int[][] board ={};

        System.out.println(solution(board));
    }

    // 위치와 방향을 보관
    // 방향이 바뀌면 +500
    // 칸 이동시 +100

    static int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        cost = new int[len][len][2];
        visit = new boolean[len][len][2];
        
        for(int i = 0; i<len; i++){
            for(int j = 0; j<len; j++){
                cost[i][j][0] = 1000000;
                cost[i][j][1] = 1000000;
                
            }
        }
        
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>(){
           @Override
            public int compare(Integer[] o1, Integer[] o2){
                return (cost[o1[0]][o1[1]][0]+cost[o1[0]][o1[1]][1]) - (cost[o2[0]][o2[1]][0]+ cost[o2[0]][o2[1]][1]);
            }
        });
        
        if(board[0][1] == 0){
            visit[0][1][0] = true;
            cost[0][1][0] = 100;
            queue.offer(new Integer[] {0,1});
        }
        
        if(board[1][0] == 0){
            visit[1][0][1] = true;
            cost[1][0][1] = 100;
            queue.offer(new Integer[]{1,0});
        } 
        
        visit[0][0][0] = true;
        visit[0][0][1] = true;
        
        
        while(!queue.isEmpty()){
            Integer[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            
            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if(nx >= 0 && nx<len && ny>=0 && ny<len){
                    if(board[nx][ny] == 1){
                        continue;
                    }
                    
                    if(nx == x && !visit[nx][ny][0]){
                        visit[nx][ny][0] = true;
                        cost[nx][ny][0] = Math.min(cost[x][y][0], cost[x][y][1]+500)+100;
                        queue.offer(new Integer[]{nx,ny});
                    }
                    
                    if(ny == y && !visit[nx][ny][1]){
                        visit[nx][ny][1] = true;
                        cost[nx][ny][1] = Math.min(cost[x][y][0]+500, cost[x][y][1])+100;
                        queue.offer(new Integer[]{nx,ny});
                    }
                }
            }
           
        }
        
        answer = Math.min(cost[len-1][len-1][0], cost[len-1][len-1][1]);
        
        return answer;
    }
    
    static int[][][] cost;
    static boolean[][][] visit;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
}