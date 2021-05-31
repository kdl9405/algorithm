package kakao.intern21;

import java.util.*;

/* 

    함정 밟으면, 길의 방향이 바뀜?

    테스트 케이스 2개 통과 못함.


    1) 정상길, 비정상길 두개를 저장
    2) 함정의 발동 여부를 비트마스크로 저장
    
    3) 다익스트라를 통해서 매 함정의 발동여부를 파악하고, 거기에 따라 길을 선택하여 탐색

*/

public class solution4 {

    public static void main(String[] args) {

        int n = 4;
        int start = 1;
        int end = 4;
        int[][] roads = { { 1, 2, 1 }, { 3, 2, 1 }, { 2, 4, 1 } };
        int[] traps = { 2, 3 };

        System.out.println(solution(n, start, end, roads, traps));
    }

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {

        link = new ArrayList<>();
        trap = new HashSet<>();
        time = new int[n + 1][n + 1];
        visit = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            link.add(new HashSet<>());
        }

        for (int t : traps) {
            trap.add(t);
        }

        for (int[] r : roads) {
            link.get(r[0]).add(r[1]);
            link.get(r[1]).add(r[0]);

            if (time[r[0]][r[1]] == 0) {
                time[r[0]][r[1]] = r[2];
            } else {
                time[r[0]][r[1]] = Math.min(r[2], time[r[0]][r[1]]);
            }

        }

        visit[start] = 1;

        dfs(-1, start, end, 0);

        return min;
    }

    static int min = 9000001;
    static List<HashSet<Integer>> link;
    static HashSet<Integer> trap;
    static int[][] time;
    static int[] visit;

    static void dfs(int before, int now, int end, int t) {

        if (now == end) {
            min = Math.min(min, t);
            return;
        }

        if (t >= min) {
            return;
        }

        if (trap.contains(now)) {

            for (Integer next : link.get(now)) {

                int temp = time[now][next];
                time[now][next] = time[next][now];
                time[next][now] = temp;
            }
        }

        for (Integer next : link.get(now)) {
            if (visit[next] < 2 && time[now][next] != 0) {
                visit[next]++;
                dfs(now, next, end, t + time[now][next]);
                visit[next]--;
            }
        }

        if (trap.contains(now)) {

            for (Integer next : link.get(now)) {

                int temp = time[now][next];
                time[now][next] = time[next][now];
                time[next][now] = temp;
            }
        }

        return;
    }
}
