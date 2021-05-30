package kakao.intern21;

import java.util.LinkedList;
import java.util.Queue;

public class solution2 {

    // 각 P의 거리가 2 이하면 0 아니면 1?
    // 체크를 아래바향과, 오른쪽 방향만 했으면 더 좋았을 듯.

    public static void main(String[] args) {
        String[][] places = { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
                { "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX" },
                { "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } };

        int[] answer = solution(places);

        for(int a: answer){
            System.out.println(a);
        }

    }

    public static int[] solution(String[][] places) {

        int n = places.length;

        int[] answer = new int[n];

        for (int i = 0; i < 1; i++) {
            answer[i] = checkP(places[i]);
        }

        return answer;
    }

    static int checkP(String[] place) {

        char[][] map = new char[5][5];

        for (int i = 0; i < 5; i++) {
            map[i] = place[i].toCharArray();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 'P') {

                    // System.out.println(i+" "+j);

                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[] { i, j });

                    for (int cnt = 0; cnt < 2; cnt++) {

                        int size = queue.size();

                        while (size-- > 0) {
                            int[] p = queue.poll();

                            for (int d = 0; d < 4; d++) {
                                int x = p[0] + dx[d];
                                int y = p[1] + dy[d];

                                if (x >= 0 && x < 5 && y >= 0 && y < 5) {

                                    if (x == i && y == j) {
                                        continue;
                                    }

                                    if (map[x][y] == 'P') {
                                        return 0;
                                    }

                                    if (map[x][y] == 'O') {
                                        queue.add(new int[] { x, y });
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }

        return 1;
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
}
