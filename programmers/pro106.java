
import java.util.*;

/**
 * 길 찾기 게임
 * 
 */
public class pro106 {

    public static void main(String[] args) {

        int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
                { 2, 2 } };
        int[][] result = solution(nodeinfo);

        for (int[] r : result) {
            for (int i = 0; i < r.length; i++) {
                System.out.print(r[i] + " ");
            }
            System.out.println("");
        }

    }

    static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};

        HashMap<String, Integer> hash = new HashMap<>();
        HashMap<Integer,HashSet<Integer>> set = new HashMap<>(); 
        for (int i = 0; i < nodeinfo.length; i++) {
            String temp = nodeinfo[i][0] + "," + nodeinfo[i][1];
            hash.put(temp, i + 1);
            if (set.containsKey(nodeinfo[i][1])) {
                HashSet<Integer> s = set.get(nodeinfo[i][1]);
                s.add(nodeinfo[i][0]);
                set.put(nodeinfo[i][1], s);
            }else{
                HashSet<Integer> s = new HashSet<>();
                s.add(nodeinfo[i][0]);
                set.put(nodeinfo[i][1], s);
            }
        }

        System.out.println(hash);
        System.out.println(set);

        int max = set.keySet().stream().mapToInt(i->i).toArray()[set.size()-1];
        System.out.println(max);
        // while (!set.isEmpty()) {
            
        // }

        // Arrays.sort(nodeinfo, (n1, n2) -> {
        //     if (n2[1] == n1[1]) {
        //         return n1[0] - n2[0];
        //     }
        //     return n2[1] - n1[1];
        // });

        // Queue<Integer[]> queue = new LinkedList<>();
        // for (int[] n : nodeinfo) {
        //     queue.offer(new Integer[] { n[0], n[1] });
        // }

        // Stack<Integer> stack = new Stack<>();
        // stack.push(100001);
        
        // int depth = queue.peek()[1]+1;
        // StringBuilder sb = new StringBuilder();
        // while (!queue.isEmpty()) {
        //     Integer[] point = queue.poll();
        //     if (point[0] <= stack.peek() && point[1] < depth) {
        //         sb.append(hash.get(point[0]+","+point[1])+"  ");
        //         stack.push(point[0]);
        //         depth = point[1];
        //     }else if (point[1] < depth) {
        //         stack.pop();

        //     }

        // }

        // while (!queue.isEmpty()) {
        //     System.out.println(queue.peek()[0] + " " + queue.poll()[1] );
        // }
        return answer;
    }
}