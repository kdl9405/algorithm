package BOJ;

/* 
    말이 되고픈 원숭이

*/

import java.io.*;
import java.util.*;

public class BOJ1600 {

    static int[][] move = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    static int[][] jump = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 } };

    public static void main(String[] args) throws IOException {

        int a = 1<<31;
        System.out.println(a);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        int[][] visit = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                visit[i][j] = -1;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0, K });

        int count = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {
                int[] monkey = queue.poll();

                if (monkey[0] == H - 1 && monkey[1] == W - 1) {
                    System.out.println(count);
                    return;
                }

                if (visit[monkey[0]][monkey[1]] > monkey[2]) {
                    continue;
                }
                visit[monkey[0]][monkey[1]] = monkey[2];
               

                for (int i = 0; i < 4; i++) {
                    int nr = monkey[0] + move[i][0];
                    int nc = monkey[1] + move[i][1];

                    if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1 || visit[nr][nc] > monkey[2]) {
                        continue;
                    }

                    queue.add(new int[] { nr, nc, monkey[2] });

                }

                if (monkey[2] > 0) {
                    for (int i = 0; i < 8; i++) {
                        int nr = monkey[0] + jump[i][0];
                        int nc = monkey[1] + jump[i][1];

                        if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1
                                || visit[nr][nc] > monkey[2] - 1) {
                            continue;
                        }

                        queue.add(new int[] { nr, nc, monkey[2] - 1 });

                    }
                }
            }

            count++;

        }

        System.out.println(-1);

    }

}
