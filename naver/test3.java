package naver;

import java.util.*;

public class test3 {

    public static void main(String[] args) {

        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 2, 4 }, { 2, 5 }, { 2, 6 }, { 3, 7 }, { 3, 8 }, { 3, 9 } };

        System.out.println(solution(10, edges));

    }

    static int solution(int n, int[][] edges) {
        int answer = 0;

        int[] computer = new int[n];

        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            map.put(edges[i][0], map.getOrDefault(edges[i][0], 0) + 1);
        }

        queue.addAll(map.keySet());

        List<Integer> list = new ArrayList<>(map.keySet());

        Collections.sort(list, (l1,l2) ->{
            return map.get(l1).compareTo(map.get(l2));
        });
        
        while (!queue.isEmpty()) {
            int x = queue.poll();
            computer[x] = 1;

            
            
            for (int i = 0; i < n - 1; i++) {

                if (edges[i][0] == x) {
                    int nx = edges[i][1];
                    computer[nx] = 1;
                    queue.offer(nx);
                }
                if (edges[i][0] > x) {
                    break;
                }
            }

        }

        return answer;
    }

}
