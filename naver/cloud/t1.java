package naver.cloud;

/* 
    땅따먹기? 전쟁?
        1. 국가 알파벳이 붙어있는 맵이 주어진다.
        2. .은 없다는 것이고, 붙어있는 국가들을 전쟁을 한다.
        3. 붙어있는 구역에서, 각장 많은 땅을 갖고 있는 국가가, 그보다 적은 국가의 땅을 획득한다. (숫자가 같은 국가는 못먹음.)
        4. 여러 구역에 같은 나라의 알파벳이 존재한다.
        5. 모든 전쟁이 끝난 후 , 가장 많은 땅을 가진 국가의 땅의 수를 출력.

    =>
        1. 방문체크를 하는 boolean[][](visit)과 최종적으로 땅의 개수를 기록할 HashMap(result)를 생성.
        2. 각 구역의 국가별 땅 개수를 저장할 HashMap(section)를 생성
        3. map를 순회하면서 빈칸(.)아 아니면,  section를 초기화하고 탐색(find)
        4. 탐색이 끝나면, 탐색한 구역의 승자를 판별하고, 각 국가의 땅을 result에 저장
            (실제 map의 값을 변경하지 않고 승자보다 적은 숫자는 승자에게, 같은 숫자는 해당 국가에 저장)
        5. 맵의 순환이 끝나면, result를 조회하여 가장 큰 수를 반환.


    => 매 전쟁마다 해당 구역의 전쟁결과를 map에 반영하고, 한번 더 map를 순회하여 최종결과를 출력하는 것을 좋지 않다 판단.
    => 매 전쟁마다 map의 값을 변경하지 않고 승자를 판별, 땅의 수를 저장하는 방식을 택함.

*/

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
