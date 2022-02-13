package programmers;

import java.util.*;

/**
 * p
 */
public class p3 {

    public static void main(String[] args) {

        int[][] board = { { 1, 0, 0, 3 }, { 2, 0, 0, 0 }, { 0, 0, 0, 2 }, { 3, 0, 1, 0 } };
        int r = 1;
        int c = 0;

        new p3().test(board);
        // System.out.println(new p3().solution(board, r, c));
    }

    void test(int[][] board) {
        Board = new int[4][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                Board[i][j] = board[i][j];

        Point st = new Point(0, 0, 0,"");
        Point dest = new Point(3, 3, 0,"");

        System.out.println(bfs(st, dest));
    }

    int bfs(Point st, Point dest) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];
        visited[st.x][st.y] = true;
        q.add(st);

        while (!q.isEmpty()) {
            Point cur = q.poll();
            System.out.println(cur.x+","+ cur.y+ " = "+ cur.route);

            if (cur.x == dest.x && cur.y == dest.y) {
                System.out.println(cur.route);
                return cur.cnt;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (cur.x == 0 && cur.y == 3) {
                    System.out.println("!!! "+nx+","+ny + " "+ (isOut(nx,ny)? "out" : visited[nx][ny]));
                }

                if (isOut(nx, ny) || visited[nx][ny]) {
                    continue;
                }
                // 1.일반 상하좌우 이동
                q.add(new Point(nx, ny, cur.cnt + 1,cur.route+" - "+ nx+","+ny));
                visited[nx][ny] = true;

                // 2.ctrl+상하좌우 이동
                for (int i = 0; i < 2; i++) {
                    if (Board[nx][ny] != 0)
                        break;// 카드에 도달했다면 반복 이동 멈춤!
                    // 범위체크,방문체크 후 이동
                    if (isOut(nx + dx[d], ny + dy[d]))
                        break;// 현재 방향으로 범위초과한다면 반복 멈춤!
                    nx += dx[d];
                    ny += dy[d];
                }
                // 이동할 만큼 이동하고 다음 이동할 좌표로 처리:큐삽입&방문체크!
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny, cur.cnt + 1,cur.route+" - "+ nx+","+ny));
                }
            }
        }
        return INF;
    }

    static final int INF = 987654321;
    static int[][] Board = new int[4][4];

    static class Point {
        int x, y, cnt;
        String route;

        Point(int x, int y, int cnt, String route) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.route = route;
        }
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

   

    boolean isOut(int x, int y) {
        return x < 0 || x > 3 || y < 0 || y > 3;
    }

    // 범위 초과하면 true를 리턴.
    static boolean check(int x, int y) {
        return x < 0 || x > 3 || y < 0 || y > 3;
    }

    // 재귀함수로 각 순자카드마다 고르는 순서를 선택한다!
    static int permutate(Point src) {
        int ret = INF;
        for (int num = 1; num <= 6; num++) {
            List<Point> cards = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Board[i][j] == num) {
                        cards.add(new Point(i, j, 0));
                    }
                }
            }
            if (cards.isEmpty())
                continue;
            int one = bfs2(src, cards.get(0)) + bfs2(cards.get(0), cards.get(1)) + 2;
            int two = bfs2(src, cards.get(1)) + bfs2(cards.get(1), cards.get(0)) + 2;

            for (int i = 0; i < 2; i++)
                Board[cards.get(i).x][cards.get(i).y] = 0;

            ret = Math.min(ret, one + permutate(cards.get(1)));
            ret = Math.min(ret, two + permutate(cards.get(0)));

            for (int i = 0; i < 2; i++)
                Board[cards.get(i).x][cards.get(i).y] = num;
        }
        if (ret == INF)
            return 0;
        return ret;
    }

    int permu(Point st) {

        int ret = INF;

        for (int num = 1; num <= 6; num++) {
            LinkedList<Point> list = new LinkedList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Board[i][j] == num) {
                        list.add(new Point(i, j, 0));
                    }
                }
            }
            if (list.size() == 0) {
                continue;// 다음 num으로 컨티뉴처리
            }
            // 0,1번 방문 순서 정하고 각각마다 bfs 수행, 재귀호출&실행으로 그 때의 방문 횟수 계산
            int one = bfs(st, list.get(0)) + bfs(list.get(0), list.get(1)) + 2;
            int two = bfs(st, list.get(1)) + bfs(list.get(1), list.get(0)) + 2;
            // 재귀함수로 카드 6개 모든 쌍을 방문!
            // 현재 num 위치 방문 처리

            for (int i = 0; i < 2; i++) {
                Point cur = list.get(i);
                Board[cur.x][cur.y] = 0;
            }
            // 2가지 중 현재위치에서의 버튼 조작횟수 최솟값을 ret에 저장!
            // ret = one + permu(list.get(1));
            ret = Math.min(ret, one + permu(list.get(1)));
            ret = Math.min(ret, two + permu(list.get(0)));
            // 재귀 리턴 후 원복 처리
            for (int i = 0; i < 2; i++) {
                Point cur = list.get(i);
                Board[cur.x][cur.y] = num;
            }
        }

        if (ret == INF)
            return 0;

        // System.out.println("( " + ret + " )");
        return ret;
    }

    public int solution(int[][] board, int r, int c) {
        Board = board;
        return permu(new Point(r, c, 0));
    }
}
