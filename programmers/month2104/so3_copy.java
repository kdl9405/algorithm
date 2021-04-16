package programmers.month2104;

import java.util.*;

// 

public class so3_copy {

    public static void main(String[] args) {

        int[] a = {2, -4, 2 };
        int[][] edges = { { 0, 1 }, { 1, 2 }};


        System.out.println(solution(a, edges));
    }

    static ArrayList<ArrayList<Integer>> line;
    static long[] w;
    static boolean[] leaf;
    static long answer;

    public static long solution(int[] a, int[][] edges) {

        int sum = 0;
        for (int x : a) {
            sum += x;
        }

        if (sum != 0) {
            return -1;
        }

        w = new long[a.length];
        line = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            w[i] = a[i];
            line.add(new ArrayList<>());
        }

        answer = 0;
        for (int[] edge : edges) {
           
            line.get(edge[0]).add(edge[1]);
            line.get(edge[1]).add(edge[0]);
        }

       
        while (true) {
            
            Queue<Integer> queue = new LinkedList<>();

            for()
        }

        return answer;
    }

}
