package programmers;

import java.util.*;

/* 
    거리두기 확인하기
*/
public class pro192 {
    
    public static void main(String[] args) {
        
    }

    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int i = 0; i<places.length; i++){

            if (check(places[i])) {
                answer[i] = 1;
            }else{
                answer[i] = 0;
            }

        }

        
        return answer;
    }

    static boolean check(String[] place){

        char[][] arr = new char[5][5];

        for(int i = 0; i<5; i++){
            arr[i] = place[i].toCharArray();
        }

        for(int i = 0; i<5; i++){
            for(int j = 0; j<5; j++){
                if(arr[i][j] == 'P'){
                    
                    if(!possible(arr, i, j)){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static boolean possible(char[][] arr, int x, int y){

        visit = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visit[x][y] = true;
        
        int d = 0;
        while (d++ < 2) {
            int size = queue.size();

            while (size-- > 0) {
                
                int[] now = queue.poll();

                for(int i = 0; i<3; i++){
                    int nx = now[0]+dx[i];
                    int ny = now[1]+dy[i];

                    if (nx >= 0 && nx<5 && ny >= 0 && ny<5 && !visit[nx][ny]) {
                        
                        if(arr[nx][ny] == 'P'){
                            return false;
                        }else if(arr[nx][ny] == 'O'){
                            queue.add(new int[]{nx,ny});
                        }
                    
                        visit[nx][ny] = true;

                    }
                }
            }
        }

        return true;

    }

    static int[] dx = {1,0,0};
    static int[] dy = {0,-1,1};
    static boolean[][] visit;
}
