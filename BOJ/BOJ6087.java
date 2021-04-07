package BOJ;

import java.io.*;
import java.util.*;

/* 
    레이저 통신

*/
public class BOJ6087 {

    static int W, H;
    static char[][] map;
    static boolean[][] visit;
    static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];

        int[] start = new int[2];
        boolean init = false;

        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().toCharArray();
            if (init) {
                continue;
            }
            for (int j = 0; j < W; j++) {
                if (map[i][j] == 'C') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        visit = new boolean[H][W];

        System.out.println(findRoot_BFS(start));

    }

    static int findRoot_BFS(int[] start) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        int count = 0;

        loop: while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {
                int h = queue.peek()[0];
                int w = queue.poll()[1];

                if (visit[h][w]) {
                    continue;
                }

                visit[h][w] = true;

                for (int i = 0; i < 4; i++) {
                    int nh = h + dir[i][0];
                    int nw = w + dir[i][1];

                    while (nh >= 0 && nh < H && nw >= 0 && nw < W && map[nh][nw] != '*') {
                        if (!visit[nh][nw]) {
                            if (map[nh][nw] == 'C') {
                                break loop;
                            }
                            queue.add(new int[] { nh, nw });
                        }
                        nh += dir[i][0];
                        nw += dir[i][1];
                    }
                }
            }
            count++;
        }

        return count;
    }

}
