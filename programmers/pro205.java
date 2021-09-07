package programmers;

import java.util.*;

/* 
    가장 먼 노드

*/
public class pro205 {

    public static void main(String[] args) {

    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;

        line = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            line.add(new HashSet<>());
        }

        for(int[] e : edge){
            line.get(e[0]).add(e[1]);
            line.get(e[1]).add(e[0]);
        }

        visit = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;


        while (true) {
            
            int size = queue.size();

            for(int i = 0; i<size; i++){

                int x = queue.poll();

                for(int y : line.get(x)){
                    if (!visit[y]) {
                        visit[y] = true;
                        queue.add(y);
                    }
                }

            }

            if (queue.isEmpty()) {
                answer = size;
                break;
            }
        }

        return answer;
    }

    static boolean[] visit;
    static List<HashSet<Integer>> line;

}
