package programmers.month2105;

import java.util.*;

public class sol4 {

    public static void main(String[] args) {



    }

    public long[] solution(int[] values, int[][] edges, int[][] queries) {

        List<Long> answer = new ArrayList<>();

        link = new ArrayList<>();
        parent = new int[values.length+1];
        value = values.clone();

        for(int i = 0; i<=values.length; i++){
            link.add(new ArrayList<>());
        }

        for(int[] e : edges){
            link.get(e[0]).add(e[1]);
            link.get(e[1]).add(e[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parent[1] = 1;

        while (!queue.isEmpty()) {
            int p = queue.poll();

            for(int child : link.get(p)){
                if (parent[child] != 0) {
                    continue;
                }
                parent[child] = p;
                queue.add(child);
            }
        }

        for(int[] q : queries){
            if (q[1] == -1) {
                answer.add(findSum(q[0]));
            }else{

                change(q[0]);
                value[1] = q[1];
            }
        }



        return answer.stream().mapToLong(l->l).toArray();
    }

    static List<List<Integer>> link;
    static int[] parent;
    static int[] value;

    static long findSum(int n){

        int sum = value[n];

        for(int child : link.get(n)){
            if (child != parent[n]) {
                sum += findSum(child);
            }
        }

        return sum;
    }

    static void change(int n){

        if (parent[n] != 1) {
            value[n] = value[parent[n]];
        }

        change(parent[n]);
    }
}
