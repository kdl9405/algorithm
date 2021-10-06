package programmers;

import java.util.*;

/* 
    전력망을 둘로 나누기

*/

public class pro218 {

    public static void main(String[] args) {

        int n = 9;
        int[][] wires = { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } };

        System.out.println(solution(n, wires));

    }

    public static int solution(int n, int[][] wires) {
        int answer = n;

        lines = new HashMap<>();

        for (int[] wire : wires) {

            if (!lines.containsKey(wire[0])) {
                lines.put(wire[0], new HashSet<>());
            }
            lines.get(wire[0]).add(wire[1]);

            if (!lines.containsKey(wire[1])) {
                lines.put(wire[1], new HashSet<>());
            }
            lines.get(wire[1]).add(wire[0]);
        }

        child = new int[n + 1];
        visit = new boolean[n + 1];

        findChild(1);


        for(int i = 1; i<=n; i++){
            answer = Math.min(answer, Math.abs((child[i] - (n - child[i]))));
        }

        return answer;
    }

    static HashMap<Integer, HashSet<Integer>> lines;
    static int[] child;
    static boolean[] visit;

    static int findChild(int n) {

        visit[n] = true;

        int count = 1;

        for (int c : lines.get(n)) {
            if (!visit[c]) {
                count += findChild(c);
            }
        }

        return child[n] = count;
    }

}
