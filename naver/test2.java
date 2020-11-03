package naver;

import java.util.*;

public class test2 {

    public static void main(String[] args) {

        int[][] blocks = { { 0, 50 }, { 0, 22 }, { 2, 10 }, { 1, 4 }, { 4, -13 } };

        int[] answer = solution(blocks);

        StringBuilder sb = new StringBuilder();

        for (int a : answer) {
            sb.append(a + " ");
        }

        System.out.println(sb);

    }

    static int[] solution(int[][] blocks) {
        int[] answer = {};

        int len = blocks.length;
        int[][] map = new int[len][len];
        boolean[][] fill = new boolean[len][len];
        int[] start = new int[len];

        for (int i = 0; i < len; i++) {
            int a = blocks[i][0];
            int b = blocks[i][1];
            map[i][a] = b;
            start[i] = a;
            fill[i][a] = true;
        }

        for (int i = 1; i < len; i++) {

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start[i]);

            while (!queue.isEmpty()) {
                int x = queue.poll();

                if (x - 1 >= 0) {
                    if (!fill[i][x - 1]) {
                        map[i][x - 1] = map[i - 1][x - 1] - map[i][x];
                        queue.offer(x - 1);
                        fill[i][x - 1] = true;
                    }
                }

                if (x + 1 <= i) {
                    if (!fill[i][x + 1]) {
                        map[i][x + 1] = map[i - 1][x] - map[i][x];
                        queue.offer(x + 1);
                        fill[i][x + 1] = true;
                    }
                }
            }

        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                list.add(map[i][j]);
            }
        }

        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}
