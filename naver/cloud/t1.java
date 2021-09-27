package naver.cloud;

import java.util.*;

public class t1 {

    public static void main(String[] args) {

    }

    public static int solution(String[] maps) {
        int answer = 0;

        map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        visit = new boolean[map.length][map[0].length];
        result = new HashMap<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; i++) {
                if (map[i][j] == '.' || visit[i][j]) {
                    continue;
                }

                section = new HashMap<>();

                find(i, j);
                check();

            }
        }

        for(Character c : result.keySet()){
            answer = Math.max(answer, result.get(c));
        }

        return answer;

    }

    static char[][] map;
    static boolean[][] visit;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static HashMap<Character, Integer> section;
    static HashMap<Character, Integer> result;

    static void find(int x, int y) {

        visit[x][y] = true;

        section.put(map[x][y], section.getOrDefault(map[x][y], 0) + 1);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || visit[nx][ny]) {
                continue;
            }

            if (map[nx][ny] != '.') {
                find(nx, ny);
            }
        }

        return;
    }

    static void check() {

        char n = 'A';
        int max = 0;

        for (Character c : section.keySet()) {
            if (max < section.get(c)) {
                n = c;
                max = section.get(c);
            } else if (max == section.get(c)) {
                if (n < c) {
                    n = c;
                }
            }
        }

        for (Character c : section.keySet()) {
            if (section.get(c) == max) {
                result.put(c, result.getOrDefault(c, 0)+max);
            }else{
                result.put(n, result.getOrDefault(n, 0)+section.get(c));
            }
        }

        return;

    }
}
