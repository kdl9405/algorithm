package boj;

import java.io.*;
import java.util.*;

/*
 * 레이저 통신
 * 
 * java11 - 300ms
 */
public class BOJ6087_copy {

    static int W, H;
    static String[][] map;
    static int[][] dp; // 0-상 1-하 2-좌 3-우
    static boolean[][] visit;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new String[H][W];
        dp = new int[H][W];
        visit = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            map[i] = br.readLine().split("");
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (map[i][j].equals("C")) {
                    queue.add(new int[] {i, j});
                }
            }
        }

        int[] start = queue.poll();
        int[] end = queue.poll();


        System.out.println(findRoot(end, start));

    }

    static int findRoot(int[] start, int[] end) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {start[0], start[1]});

        int count = -1;

        loop: while (!queue.isEmpty()) {

            int size = queue.size();

            /*
             * System.out.print(count +" = "); for(int[] q : queue){
             * System.out.print(q[0]+" "+q[1]+" / "); }System.out.println();
             */

            while (size-- > 0) {

                int h = queue.peek()[0];
                int w = queue.poll()[1];

                if (h == end[0] && w == end[1]) {
                    break loop;
                }

                if (visit[h][w]) {
                    continue;
                }
                visit[h][w] = true;

                for (int i = 0; i < 4; i++) {
                    int nh = h + dir[i][0];
                    int nw = w + dir[i][1];

                    while (nh >= 0 && nh < H && nw >= 0 && nw < W && !map[nh][nw].equals("*")) {
                        if (!visit[nh][nw]) {
                            queue.add(new int[] {nh, nw});
                        }
                        nh += dir[i][0];
                        nw += dir[i][1];
                    }
                }
            }

            count++;
        }

        if (count == -1) {
            count = 0;
        }
        return count;

    }
}
