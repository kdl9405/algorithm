package programmers;

import java.util.*;

/**
 * p
 */
public class p {

    public static void main(String[] args) {

        int[][] board = { { 1, 0, 0, 3 }, { 2, 0, 0, 0 }, { 0, 0, 0, 2 }, { 3, 0, 1, 0 } };
        int r = 1;
        int c = 0;

        new p().test(board);
        // System.out.println(new p().solution(board, r, c));
    }

    void test(int[][] board) {
        Board = new int[4][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                Board[i][j] = board[i][j];

        Point st = new Point(0, 0,"");
        Point dest = new Point(3, 3,"");

        System.out.println(bfs(st, dest));
    }

    int bfs(Point st, Point dest) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[4][4];
        visited[st.x][st.y] = true;
        q.add(st);

        int count = 0;
        while (!q.isEmpty()) {

            int size = q.size();

            System.out.println(count+"-----------------");
            while (size-- > 0) {
                Point cur = q.poll();
                System.out.println(cur.x+","+ cur.y+ " = "+ cur.route);


                if (cur.x == dest.x && cur.y == dest.y) {
                    System.out.println(cur.route);
                    return count;
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

                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny,cur.route+" - "+ nx+","+ny));

                    for (int i = 1; i < 3; i++) {
                        nx += dx[d];
                        ny += dy[d];

                        if (isOut(nx, ny)) {
                            nx -= dx[d];
                            ny -= dy[d];
                            break;
                        }

                        if (Board[nx][ny] != 0) {
                            break;
                        }
                    }

                    if (!visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny,cur.route+" - "+ nx+","+ny));
                    }
                }
            }
            count++;
        }
        return INF;
    }

    int INF = 987654321;
    int[] dx = { -1, 1, 0, 0 };
    int[] dy = { 0, 0, -1, 1 };
    int[][] Board;

    class Point {
        int x, y;
        String route;

        Point(int x, int y, String route) {
            this.x = x;
            this.y = y;
            this.route = route;
        }
    }

    public int solution(int[][] board, int r, int c) {
        // 변수 초기화, 깊은 복사
        Board = new int[4][4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                Board[i][j] = board[i][j];

        return permu(new Point(r, c), 1);
    }

    int permu(Point st, int depth) {

        int ret = INF;

        for (int num = 1; num <= 3; num++) {
            LinkedList<Point> list = new LinkedList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (Board[i][j] == num) {
                        // System.out.print(num + " ");
                        list.add(new Point(i, j));
                    }
                }
            }
            if (list.size() == 0) {
                // System.out.println();
                continue;// 다음 num으로 컨티뉴처리
            }
            // 0,1번 방문 순서 정하고 각각마다 bfs 수행, 재귀호출&실행으로 그 때의 방문 횟수 계산
            int one = bfs(st, list.get(0)) + bfs(list.get(0), list.get(1)) + 2;
            int two = bfs(st, list.get(1)) + bfs(list.get(1), list.get(0)) + 2;
            // 재귀함수로 카드 6개 모든 쌍을 방문!
            // 현재 num 위치 방문 처리

            int x = list.get(0).x;
            int y = list.get(1).y;
            int v = Board[list.get(0).x][list.get(0).y];

            for (int i = 0; i < 2; i++) {
                Point cur = list.get(i);
                Board[cur.x][cur.y] = 0;
            }
            // 2가지 중 현재위치에서의 버튼 조작횟수 최솟값을 ret에 저장!
            // ret = one + permu(list.get(1));
            ret = Math.min(ret, one + permu(list.get(1), depth + 1));
            ret = Math.min(ret, two + permu(list.get(0), depth + 1));
            // 재귀 리턴 후 원복 처리
            for (int i = 0; i < 2; i++) {
                Point cur = list.get(i);
                Board[cur.x][cur.y] = num;
            }
        }

        if (ret == INF)
            return 0;

        return ret;
    }

    boolean isOut(int x, int y) {
        return x < 0 || x > 3 || y < 0 || y > 3;
    }

}

class Solution {

}