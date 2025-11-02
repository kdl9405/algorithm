package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 코딩테스트 연습 연습문제 무인도 여행
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/154540
 * 
 */

public class pro272 {

    public int[] solution(String[] maps) {

        n = maps.length;
        m = maps[0].length();

        List<Integer> foods = new ArrayList<>();

        map = new char[n][m];
        visited = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            map[i] = maps[i].toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {

                    foods.add(findFood(i, j));
                }
            }
        }


        int[] answer = foods.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);

        if (answer.length == 0) {
            answer = new int[] {-1};
        }
        return answer;
    }

    private int n, m;
    private boolean[][] visited;
    private char[][] map;
    private int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int findFood(int x, int y) {
        visited[x][y] = true;

        int food = map[x][y] - '0';

        for (int[] d : dir) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                continue;
            if (map[nx][ny] == 'X' || visited[nx][ny])
                continue;

            food += findFood(nx, ny);
        }

        return food;
    }
}
