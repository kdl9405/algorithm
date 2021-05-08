package kakao.intern21;

import java.util.*;

public class solution4_copy {

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
        time = new int[n + 1][n + 1][2];
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

            time[r[0]][r[1]][1] = 1; // 방향  1 = 정방향 0; 역방향

            if (time[r[0]][r[1]][1] == 0) {
                time[r[0]][r[1]][1] = r[2];
            } else {
                time[r[0]][r[1]][1] = Math.min(r[2], time[r[0]][r[1]][1]);
            }

        

        }

        visit[start] = 1;

        dfs(-1, start, end, 0);

        return min;
    }

    static int min = 10;
    static List<HashSet<Integer>> link;
    static HashSet<Integer> trap;
    static int[][] time[];
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

                time[now][next][0] = (time[now][next][0]+1)%2;
                time[next][now][0] = (time[next][now][0]+1)%2;

                
                // int temp = time[now][next][1];
                // time[now][next][1] = time[next][now][1];
                // time[next][now][1] = temp;
            }
        }

        for (Integer next : link.get(now)) {
            if (visit[next] < 2) {

                if (time[now][next][0] == 1 && time[now][next][1] != 0) {
                    visit[next]++;
                    dfs(now, next, end, t + time[now][next][1]);
                    visit[next]--;
                }

                if (time[next][now][0] == 0 && time[next][now][1] != 0) {
                    visit[next]++;
                    dfs(now, next, end, t + time[next][now][1]);
                    visit[next]--;
                }
            }

            // if (visit[next]<2 && time[now][next][1] != 0) {
            //     visit[next]++;
            //     dfs(now, next, end, t+time[now][next][1]);
            //     visit[next]--;
            // }
        }

        if (trap.contains(now)) {

            for (Integer next : link.get(now)) {
             
                time[now][next][0] = (time[now][next][0]+1)%2;
                time[next][now][0] = (time[next][now][0]+1)%2;

                // int temp = time[now][next][1];
                // time[now][next][1] = time[next][now][1];
                // time[next][now][1] = temp;
            }
        }

        return;
    }
}
