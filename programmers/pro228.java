package programmers;

/* 
    미로 탈출

    1. 방향 신경쓰지 않고, 연결 정보 저장. / time[][] 에 방향에 따른 시간 저장.
    2. Set에 trap를 담아서, 트랩에 대한 즉시 체크가 가능하도록.
    3. bfs에 노드와 트랩의 발동 정보를 담아서 도착할 때까지 조회.
    4. 길을 탐색할 때, 노드의 트랩 여부에 따라 이동가능한지 지정.

*/

import java.util.*;

public class pro228 {

    public static void main(String[] args) {

        int n = 4;
        int start = 1;
        int end = 4;
        int[][] roads = { { 1, 2, 1 }, { 3, 2, 1 }, { 2, 4, 1 } };
        int[] traps = { 2, 3 };

        System.out.println(solution(n, start, end, roads, traps));

    }

    static List<HashSet<Integer>> link;
    static int[][] time;
    static int INF = 9000001;
    static HashMap<Integer, Integer> trapIndex;
    static int[] visit;

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int answer = 0;

        setInfo(n, roads, traps);

        // BFS
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });

        pq.add(new int[] { start, 0, 0 }); // 노드 / 체크 비트 / 비용

        visit = new int[n+1];

        while (!pq.isEmpty()) {

            int[] now = pq.poll();

            if (now[0] == end) {
                answer = now[2];
                break;
            }

            if (visit[now[0]]> 3) {
                continue;
            }

            visit[now[0]]++;

            boolean reverseInit = false;

            if (trapIndex.containsKey(now[0])
                    && (now[1] & (1 << trapIndex.get(now[0]))) == 1 << trapIndex.get(now[0])) {
                reverseInit = true;
            }

            for (int next : link.get(now[0])) {

                boolean reverse = reverseInit;

                if (trapIndex.containsKey(next)) {

                    // 다음 노드 트랩이 발동되어 있는 상태
                    if ((now[1] & (1 << trapIndex.get(next))) == (1 << trapIndex.get(next))) {
                        reverse = !reverse;
                    }

                    if (reverse) {
                        if (time[next][now[0]] < INF) {
                            pq.add(new int[] { next, now[1] ^ 1 << trapIndex.get(next), now[2] + time[next][now[0]] });
                        }
                    } else {
                        if (time[now[0]][next] < INF) {
                            pq.add(new int[] { next, now[1] ^ 1 << trapIndex.get(next), now[2] + time[now[0]][next] });
                        }
                    }

                } else {

                    if (reverse) {
                        if (time[next][now[0]] < INF) {
                            pq.add(new int[] { next, now[1], now[2] + time[next][now[0]] });
                        }
                    } else {
                        if (time[now[0]][next] < INF) {
                            pq.add(new int[] { next, now[1], now[2] + time[now[0]][next] });
                        }
                    }

                }
            }

        }

        return answer;

    }

    public static void setInfo(int n, int[][] roads, int[] traps) {

        link = new ArrayList<>();
        time = new int[n + 1][n + 1];
        

        for (int i = 0; i <= n; i++) {
            link.add(new HashSet<>());
            Arrays.fill(time[i], INF);

        }

        for (int[] road : roads) {
            link.get(road[0]).add(road[1]);
            link.get(road[1]).add(road[0]);

            time[road[0]][road[1]] = Math.min(time[road[0]][road[1]], road[2]);
        }

        trapIndex = new HashMap<>();
        for (int i = 0; i < traps.length; i++) {
            trapIndex.put(traps[i], i);
        }

        return;
    }

}
