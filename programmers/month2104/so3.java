package programmers.month2104;

import java.util.*;

// 끝점을 하나씩 지우는 형식으로. => 시간초과.
public class so3 {

    public static void main(String[] args) {

        int[] a = { -5, 0, 2, 1, 2 };
        int[][] edges = { { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 } };

        System.out.println(solution(a, edges));
    }

    public static long solution(int[] a, int[][] edges) {
        long answer = 0;

        HashMap<Integer, HashSet<Integer>> line = new HashMap<>();

        for (int[] edge : edges) {
            if (!line.containsKey(edge[0])) {
                line.put(edge[0], new HashSet<>());
            }
            if (!line.containsKey(edge[1])) {
                line.put(edge[1], new HashSet<>());
            }

            line.get(edge[0]).add(edge[1]);
            line.get(edge[1]).add(edge[0]);
        }

        while (line.size() > 1) {
            // 끝점 탐색

            List<Integer> last = new ArrayList<>();

            for (int point : line.keySet()) {
                if (line.get(point).size() == 1) {

                    last.add(point);

                    answer += Math.abs(a[point]);

                    for (int e : line.get(point)) {

                        a[e] += a[point];
                      
                        line.get(e).remove(point);
                    }
                }
            }

            for (int e : last) {
                line.remove(e);
            }

        }

        
        for(int last : line.keySet()) {
            if (a[last] != 0) {
                return -1;
            }   
        }


        return answer;
    }
}