package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class J_pro3 {

    public static void main(String[] args) {
        int n = 11;
        int[] passenger = { 1, 7, 3, 5, 5, 1, 1, 1, 1, 10 };
        int[][] train = { { 1, 2 }, { 3, 2 }, { 5, 1 }, { 4, 5 }, { 1, 6 }, { 6, 7 }, { 7, 8 }, { 8, 9 }, { 10, 1 } };

        long beforeTime = System.currentTimeMillis();

        int[] answer = solution(n, passenger, train);

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime); // 두 시간에 차 계산
        System.out.println("시간차이(ms) : " + secDiffTime);

        System.out.println(answer[0] + " " + answer[1]);
    }

    public static int[] solution(int n, int[] passenger, int[][] train) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 1; i <= passenger.length; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < train.length; i++) {
            map.get(train[i][0]).add(train[i][1]);
            map.get(train[i][1]).add(train[i][0]);
        }

        int[] answer = bfs(map, passenger);
        return answer;
    }

    static int[] bfs(Map<Integer, List<Integer>> map, int[] passenger) {
        int[] answer = new int[2];
        int[] sum = new int[passenger.length + 1];
        boolean[] visited = new boolean[passenger.length + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(1);
        visited[1] = true;

        sum[1] = passenger[0];
        answer[0] = 1;
        answer[1] = passenger[0];

        while (!q.isEmpty()) {
            int current = q.poll();
            List<Integer> currentAdjList = map.get(current);

            for (int i = 0, size = currentAdjList.size(); i < size; i++) {
                int target = currentAdjList.get(i);
                if (!visited[target]) {

                    q.offer(target);
                    visited[target] = true;
                    sum[target] = sum[current] + passenger[target - 1];
                    if (answer[1] < sum[target]) {
                        answer[0] = target;
                        answer[1] = sum[target];
                    } else if (answer[1] == sum[target] && answer[0] < target) {
                        answer[0] = target;
                    }
                }
            }
        }

        for(int i = 0; i<sum.length; i++){
            System.out.println(i+" "+sum[i]);
        }



        return answer;
    }
}