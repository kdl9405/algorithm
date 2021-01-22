package programmers;

import java.util.*;

/**
 * 블록 이동하기 //상하좌우 다 이동됨....
 * 
 */
public class pro90 {

    public static void main(String[] args) {

        int[][] board = { { 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 0, 0, 1 }, { 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 1, 0, 0, 0, 0 } };

        System.out.println(solution(board));

    }

    static boolean[][][] visit;
    static int[][] map;
    static int len;

    static int[] move = { -1, 1 };

    static int solution(int[][] board) {
        int answer = 0;

        map = board.clone();
        len = board.length;

        visit = new boolean[2][len][len];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 0, 1));

        boolean fin = false;

        while (true) {

            System.out.println("----------------------count    " + answer);

            HashSet<Node> hashSet = new HashSet<>();

            while (!queue.isEmpty()) {
                Node now = queue.poll();

                int d = 0;
                if (now.y1 == now.y2) {
                    d = 1;
                }

                System.out.println(now.x1 + " " + now.y1 + " ///" + now.x2 + " " + now.y2);

                System.out.println("visit    " + visit[d][now.x1][now.y1] + "///" + visit[d][now.x2][now.y2]);

                if (visit[d][now.x1][now.y1] && visit[d][now.x2][now.y2]) {
                    continue;
                }

                if (now.x1 == len - 1 && now.y1 == len - 1) {
                    fin = true;
                    break;
                }
                if (now.x2 == len - 1 && now.y2 == len - 1) {
                    fin = true;
                    break;
                }

                Queue<Node> temp = checkMove(now);

                if (now.x1 == 4 && now.y1 == 2) {
                    if (now.x2 == 3 && now.y1 == 2) {
                        System.out.println("!!!!!!!!!!     ");

                        for (Node n : temp) {
                            System.out.print(n.x1 + "," + n.y1 + "//////" + n.x2 + "," + n.y2 + "    ");
                        }
                    }
                }

                visit[d][now.x1][now.y1] = true;
                visit[d][now.x2][now.y2] = true;

                System.out.println("temp size  " + temp.size());

                hashSet.addAll(temp);
                System.out.println("hash size  " + hashSet.size());

            }

            for (Node n : hashSet) {

                System.out.print(n.x1 + "," + n.y1 + "//////" + n.x2 + "," + n.y2 + "    ");
            }
            System.out.println();

            queue.addAll(hashSet);

            System.out.println("queue size  " + queue.size());

            if (fin) {
                break;
            }

            if (answer > 25) {
                break;
            }

            answer++;

        }
        return answer;
    }

    static Queue<Node> checkMove(Node now) {

        Queue<Node> candidate = new LinkedList<>();

        if (now.x1 == now.x2) {// 가로

            for (int m : move) {
                int ny1 = now.y1 + m;
                int ny2 = now.y2 + m;

                if (ny1 >= 0 && ny1 < len && ny2 >= 0 && ny2 < len) {
                    if (map[now.x1][ny1] == 0 && map[now.x2][ny2] == 0) {
                        candidate.add(new Node(now.x1, ny1, now.x2, ny2));
                    }
                }

                int nx = now.x1 + m;
                if (nx >= 0 && nx < len) {
                    if (map[nx][now.y1] == 0 && map[nx][now.y2] == 0) {
                        candidate.add(new Node(now.x1, now.y1, nx, now.y1));
                        candidate.add(new Node(nx, now.y2, now.x2, now.y2));
                        candidate.add(new Node(nx, now.y1, nx,now.y2));
                    }
                }

            }
        } else {// 세로
            for (int m : move) {
                int nx1 = now.x1 + m;
                int nx2 = now.x2 + m;

                if (nx1 >= 0 && nx1 < len && nx2 >= 0 && nx2 < len) {
                    if (map[nx1][now.y1] == 0 && map[nx2][now.y2] == 0) {
                        candidate.add(new Node(nx1, now.y1, nx2, now.y2));
                    }
                }

                int ny = now.y1 + m;
                if (ny >= 0 && ny < len) {
                    if (map[now.x1][ny] == 0 && map[now.x2][ny] == 0) {
                        candidate.add(new Node(now.x1, now.y1, now.x1, ny));
                        candidate.add(new Node(now.x2, ny, now.x2, now.y2));
                        candidate.add(new Node(now.x1, ny, now.x2, ny));
                    }
                }
            }
        }

        return candidate;
    }

    static class Node {
        int x1;
        int y1;
        int x2;
        int y2;

        Node(int x1, int y1, int x2, int y2) {

            if (x1 + y1 > x2 + y2) {
                this.x1 = x2;
                this.y1 = y2;
                this.x2 = x1;
                this.y2 = y1;
            } else {
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
            }

        }

    }

}