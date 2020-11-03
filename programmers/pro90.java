package programmers;

import java.util.*;

/**
 * 블록 이동하기
 * //나중에
 * 
 */
public class pro90 {

    public static void main(String[] args) {

        int[][] board = { { 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0 }, { 0, 1, 0, 1, 1 }, { 1, 1, 0, 0, 1 },
                { 0, 0, 0, 0, 0 } };

        System.out.println(solution(board));

    }

    static int solution(int[][] board) {
        int answer = 0;

        int n = board.length;
        visit = new boolean[n][n]; 
        visit[0][0] = true;
        visit[0][1] = true;   
        HashMap<Integer,HashMap<String, Integer>> map = new HashMap<>();
        HashMap<String, Integer> temp = new HashMap<>();
        temp.put("x", 0);
        temp.put("y", 0);
        map.put(0, temp);
        temp = new HashMap<>();
        temp.put("x", 0);
        temp.put("y", 1);
        map.put(1, temp);

        Queue<HashMap<Integer,HashMap<String, Integer>>> queue = new LinkedList<>();

        HashMap<Integer,HashMap<String, Integer>> now = new HashMap<>();
        while (!queue.isEmpty()) {
            now = new HashMap<>();
            now = queue.poll();



            
        }


        return answer;
    }

    static boolean[][] visit;

    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

}