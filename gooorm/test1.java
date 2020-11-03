package gooorm;

import java.util.*;

public class test1 {
    public static void main(String[] args) {

        int[][] matrix = { { 0, 1, 1, 0, 0, 0 }, { 0, 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 1, 1 },
                { 1, 1, 0, 0, 1, 0 }, { 1, 1, 1, 0, 0, 0 } };
        int sizeOfMatrix = 6;

        solution(sizeOfMatrix, matrix);

    }

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static boolean[][] visit;

    private static void solution(int sizeOfMatrix, int[][] matrix) {

        List<Integer> list = new LinkedList<>(); 

        visit = new boolean[sizeOfMatrix][sizeOfMatrix];

        for (int i = 0; i < sizeOfMatrix; i++) {
            for (int j = 0; j < sizeOfMatrix; j++) {

                if (matrix[i][j] == 1 && !visit[i][j]) {

                    visit[i][j] = true;

                    int count = 1;

                    Queue<Integer[]> queue = new LinkedList<>();
                    queue.offer(new Integer[] { i, j });

                    while (!queue.isEmpty()) {
                        int x = queue.peek()[0];
                        int y = queue.poll()[1];

                        for(int n = 0; n<4; n++){
                            int nx = x+dx[n];
                            int ny = y+dy[n];

                            if (nx>=0 && nx<sizeOfMatrix && ny>=0 && ny<sizeOfMatrix) {
                                if (matrix[nx][ny] == 1 && !visit[nx][ny]) {
                                    count++;
                                    queue.offer(new Integer[]{nx,ny});
                                    visit[nx][ny] = true;
                                }
                            }
                        }
                    }
                    list.add(count);
                }
            }            
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()+"\n");
        for(Integer n : list){
            sb.append(n +" ");
        }
        
        System.out.println(sb);

    }

}
