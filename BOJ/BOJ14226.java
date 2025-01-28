package boj;

/*
 * 이모티콘
 * 
 * 
 * 1. 클립보드에 복사 2. 화면에 복사 3. 하나 삭제
 */

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ14226 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int S = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 1, 0});

        boolean[][] visit = new boolean[1001][1001];
        visit[0][1] = true;

        int count = 0;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();

            if (now[1] == S) {
                count = now[2];
                break;
            }

            queue.offer(new int[] {now[1], now[1], now[2] + 1});

            if (now[0] != 0) {
                if (now[0] + now[1] <= 1000 && !visit[now[0]][now[0] + now[1]]) {
                    visit[now[0]][now[0] + now[1]] = true;
                    queue.offer(new int[] {now[0], now[0] + now[1], now[2] + 1});
                }
            }

            if (now[1] > 0 && !visit[now[0]][now[1] - 1]) {
                visit[now[0]][now[1] - 1] = true;
                queue.offer(new int[] {now[0], now[1] - 1, now[2] + 1});
            }
        }

        System.out.println(count);

    }
}
