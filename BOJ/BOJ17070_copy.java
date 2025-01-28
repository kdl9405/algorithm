package boj;

import java.io.*;
import java.util.*;

/*
 * 파이프 옮기기 1
 * 
 * 완탐 => 시간초과
 */
public class BOJ17070_copy {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Pipe> queue = new LinkedList<>();
        queue.add(new Pipe(1, 1, 1, 2));

        int count = 0;
        while (!queue.isEmpty()) {
            Pipe now = queue.poll();

            if (now.x2 == N && now.y2 == N) {
                count++;
                continue;
            }

            if (now.x2 < N && now.y2 < N) { // 대각선 이동
                if (map[now.x2][now.y2 + 1] == 0 && map[now.x2 + 1][now.y2 + 1] == 0
                        && map[now.x2 + 1][now.y2] == 0) {
                    queue.add(new Pipe(now.x2, now.y2, now.x2 + 1, now.y2 + 1));
                }
            }

            if (now.x2 < N && now.x1 != now.x2) {
                if (map[now.x2 + 1][now.y2] == 0) {
                    queue.add(new Pipe(now.x2, now.y2, now.x2 + 1, now.y2));
                }
            }

            if (now.y2 < N && now.y1 != now.y2) {
                if (map[now.x2][now.y2 + 1] == 0) {
                    queue.add(new Pipe(now.x2, now.y2, now.x2, now.y2 + 1));
                }
            }
        }

        System.out.println(count);

    }
}


class Pipe {

    int x1, y1;
    int x2, y2;

    public Pipe(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
