package programmers;

import java.util.*;


/* 
    게임 맵 최단거리

*/
public class pro165 {

    public static void main(String[] args) {

    }

    public int solution(int[][] maps) {
        int answer = 1;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visit= new boolean[n][m];
        
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{0,0});
        
        boolean check = false;
        
        loop:
        while(true){
            answer ++;
            Queue<Integer[]> temp = new LinkedList<>();
            
            while(!queue.isEmpty()){
                Integer[] now = queue.poll();
                if(visit[now[0]][now[1]]){
                    continue;
                }
                visit[now[0]][now[1]] = true;
                
                for(int i = 0; i<4; i++){
                    int nx = now[0]+dx[i];
                    int ny = now[1]+dy[i];
                    
                    if(nx == n-1 && ny == m-1){
                        check = true;
                        break loop;
                    }
                    
                    if(nx>=0 && nx<n && ny>=0 && ny<m && maps[nx][ny] != 0 && !visit[nx][ny]){
                        temp.add(new Integer[]{nx,ny});
                    }
                }
            }
            
            if(temp.isEmpty()){
                break;
            }
            queue.addAll(temp);
            
        }
        
        if(!check){
            answer = -1;
        }
                
        
        return answer;
    }
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1}; 
}