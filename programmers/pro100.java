package programmers;

import java.util.*;

/**
 * 하노이의 탑
 * 
 */
public class pro100 {

    public static void main(String[] args) {

        int[][] result = solution(3);
        for (int[] r : result) {
            System.out.println(r[0] + " to " + r[1]);
        }

    }

    static int[][] solution(int n) {
        int from = 1;
        int mid = 2;
        int to = 3;

        move(n, from, mid, to);

        int[][] answer = new int[list.size()][2];

        for(int i = 0; i<list.size(); i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }

        return answer;
    }

    static List<Integer[]> list = new LinkedList<>();

    static void move(int n, int from, int mid, int to) {

        if (n == 1) {
            list.add(new Integer[]{from, to});
            return;
        }

        move(n - 1, from, to, mid);
        list.add(new Integer[]{from, to});
        move(n - 1, mid, from, to);

    }
}