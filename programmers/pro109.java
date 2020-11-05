import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

/**
 * pro109
 */
public class pro109 {

    public static void main(String[] args) {
        int[][] t = { { 5, 1 }, { 2, 5 }, { 3, 5 }, { 3, 6 }, { 2, 4 }, { 4, 0 } };
        System.out.println(solution(t));
    }

    static int solution(int[][] t) {
        int answer = 0;

        HashSet<HashSet<Integer>> set = new HashSet<>();

        for (int[] a : t) {
            HashSet<Integer> temp = new HashSet<>();
            temp.add(a[0]);
            temp.add(a[1]);
            set.add(temp);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int x = queue.poll();
        }


        return answer;
    }

}