package programmers;

import java.util.*;

/**
 * 블록 이동하기
 * //나중에
 * 
 */
public class pro90 {

    public static void main(String[] args) {

        int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 0 } };

        System.out.println(solution(board));


    }

    static int[][] visit;
    static int[][] map;
    static int len;

    static int[] move = {-1,1};

    static int solution(int[][] board) {
        int answer = 0;

        map = board.clone();
        len = board.length;

        visit = new int[len][len];
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,0,1));
        visit[0][0]++;
        visit[0][1]++;

        boolean fin = false;

        while (true) {

            while (!queue.isEmpty()) {
                Node now = queue.poll();

                System.out.println(now.x1 +" "+now.y1 +" ///" + now.x2 +" "+now.y2);


                visit[now.x1][now.y1]++;
                visit[now.x2][now.y2]++;

                if (visit[now.x1][now.y1]>2 || visit[now.x2][now.y2]>2 ) {
                    continue;
                }


                if (now.x1 == len-1 && now.y1 == len-1) {
                    fin = true;
                    break;
                }
                if (now.x2 == len-1 && now.y2 == len-1) {
                    fin = true;
                    break;
                }

                Queue<Node> temp = checkMove(now);
                
                HashSet<Node> hashSet = new HashSet<>();
                hashSet.addAll(queue);
                hashSet.addAll(temp);
                queue.clear();
                queue.addAll(hashSet);       
                

                System.out.println("size = " + queue.size());

            }

            System.out.println("????");


            answer++;

            if (fin) {
                break;
            }  

            if (answer > 10) {
                break;
            }       

        }
        return answer;
    }

    static Queue<Node> checkMove(Node now){

        Queue<Node> candidate = new LinkedList<>();

        if (now.x1 == now.x2) {//가로

            for(int m : move){
                int ny1 = now.y1+m;
                int ny2 = now.y2+m;
                
                if (ny1 >= 0 && ny1 < len && ny2 >=0 && ny2 < len) {
                    if (map[now.x1][ny1] == 0 && map[now.x2][ny2] == 0) {
                        candidate.add(new Node(now.x1, ny1, now.x2, ny2));
                    }
                }

                int nx = now.x1+m;
                if (nx >=0 && nx<len) {
                    if (map[nx][now.y1] == 0 && map[nx][now.y2] == 0) {
                        candidate.add(new Node(now.x1,now.y1,nx,now.y1));
                        candidate.add(new Node(nx,now.y2,now.x2,now.y2));
                    }
                }
                
            }
        }else{//세로
            for(int m : move){
                int nx1 = now.x1+m;
                int nx2 = now.x2+m;
                
                if (nx1 >= 0 && nx1 < len && nx2 >=0 && nx2 < len) {
                    if (map[nx1][now.y1] == 0 && map[nx2][now.y2] == 0) {
                        candidate.add(new Node(nx1, now.y1, nx2, now.y2));
                    }
                }

                int ny = now.y1+m;
                if (ny >=0 && ny<len) {
                    if (map[now.x1][ny] == 0 && map[now.x2][ny] == 0) {
                        candidate.add(new Node(now.x1,now.y1,now.x2,ny));
                        candidate.add(new Node(now.x1,ny,now.x2,now.y2));
                    }
                }
            }
        }
        

        return candidate;
    }

    static class Node{
        int x1;
        int y1;
        int x2;
        int y2;

        Node(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;            
        }       

    }

}