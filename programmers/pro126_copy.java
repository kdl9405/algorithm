package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/* 
    경주로 건설
*/
public class pro126_copy {
    public static void main(String[] args) {

        int[][] board = { { 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 0, 0, 0 }, { 1, 0, 0, 1, 0, 1 },
                { 0, 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0 } };

        System.out.println(solution(board));

    }

    public static int solution(int[][] board) {
        int len = board.length;
        int min = Integer.MAX_VALUE;

        PriorityQueue<root> pq = new PriorityQueue<>((a, b) -> {
            return a.cost - b.cost;
        });

        pq.add(new root(0, 0, -1, 0));  // d  0:세로 1:가로
        board[0][0] =1;

        while (!pq.isEmpty()) {

            root now = pq.poll();

            if (now.x == len-1 && now.y == len-1) {
                min = Integer.min(min, now.cost);
                continue;
            }
            
            if (now.cost > min) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x+dx[i];
                int ny = now.y+dy[i];

                if(nx >=0 && nx<len && ny>=0 && ny<len){
                    if(board[nx][ny] != 1){
                        
                        int c = now.cost;
                        
                        if (now.d == -1 || now.d == i%2) {
                            c +=100;
                        }else{
                            c +=600;
                        }
                        
                        if(board[nx][ny] == 0 || board[nx][ny] >= c){
                             board[nx][ny] = c;
                            pq.add(new root(nx,ny,i%2, c));
                        }
                    }
                }
            }

        }

        return min;
    }

    static int[] dx = { -1, 0, 1, 0 }; // 0,2 => 세로  1,3 => 가로
    static int[] dy = { 0, -1, 0, 1 };

}

class root {
    int x;
    int y;
    int d;
    int cost;

    public root(int x, int y, int d, int cost) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.cost = cost;
    }
}