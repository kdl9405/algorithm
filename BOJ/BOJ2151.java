package boj;

import java.io.*;
import java.util.*;

/*
 * 거울 설치
 * 
 * 1) 맵 인식 -> 시작지점 저장 2) 시작지점부터 출발 3) *이면 중단 .이면 지속 ! 좌표와 방향값 큐 저장.
 * 
 * => 큐에는 좌표와 기존 방향이 담기고 -> 방향의 90도인 2개 방향으로 지속.
 */
public class BOJ2151 {

    static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0,2 1,3

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] start = new int[] {-1, -1};

        char[][] map = new char[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();

            if (start[0] == -1) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '#') {
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }
        }

        boolean[][][] visit = new boolean[N][N][2];
        visit[start[0]][start[1]][0] = true;
        visit[start[0]][start[1]][1] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start[0], start[1], 0});
        queue.add(new int[] {start[0], start[1], 1});

        int answer = 0;

        loop: while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int[] now = queue.poll();

                if (now[2] == 0) { // 상하방향으로 들어옴 -> 좌우 방향으로 나가야 됨

                    for (int i = 1; i < 4; i += 2) {
                        int nx = now[0] + direction[i][0];
                        int ny = now[1] + direction[i][1];

                        while (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 안에 속하면

                            if (map[nx][ny] == '*') {
                                break;
                            }
                            if (visit[nx][ny][1]) {
                                break;
                            }

                            if (map[nx][ny] == '#') {
                                break loop;
                            }

                            visit[nx][ny][1] = true;

                            if (map[nx][ny] == '!') {
                                queue.add(new int[] {nx, ny, 1});
                            }

                            nx += direction[i][0];
                            ny += direction[i][1];
                        }
                    }

                } else {
                    for (int i = 0; i < 4; i += 2) {
                        int nx = now[0] + direction[i][0];
                        int ny = now[1] + direction[i][1];

                        while (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 안에 속하면

                            if (map[nx][ny] == '*') {
                                break;
                            }
                            if (visit[nx][ny][0]) {
                                break;
                            }

                            if (map[nx][ny] == '#') {
                                break loop;
                            }

                            visit[nx][ny][0] = true;

                            if (map[nx][ny] == '!') {
                                queue.add(new int[] {nx, ny, 0});
                            }

                            nx += direction[i][0];
                            ny += direction[i][1];
                        }
                    }
                }

            }
            answer++;
        }

        System.out.println(answer);

    }

}
