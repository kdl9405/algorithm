package BOJ;

/* 
    불
*/

import java.io.*;
import java.util.*;

public class BOJ5427 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int[][] move = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] map = new char[h][w];
            Queue<int[]> point = new LinkedList<>();
            Queue<int[]> fire = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == '@') {
                        point.add(new int[] { i, j });
                        map[i][j] = '.';
                    } else if (map[i][j] == '*') {
                        fire.add(new int[] { i, j });
                    }
                }
            }

            int count = 0;
            boolean escape = false;
            boolean[][] visit = new boolean[h][w];
            visit[point.peek()[0]][point.peek()[1]] = true;

            loop:
            while (true) {

                int size = fire.size();

                while (size-- > 0) {

                    int[] f = fire.poll();

                    for (int i = 0; i < 4; i++) {
                        int nh = f[0] + move[i][0];
                        int nw = f[1] + move[i][1];

                        if (nh < 0 || nh >= h || nw < 0 || nw >= w) {
                            continue;
                        }

                        if (map[nh][nw] != '.') {
                            continue;
                        }

                        map[nh][nw] = '*';
                        fire.add(new int[] { nh, nw });
                    }
                }


                count++;

                size = point.size();
                while (size-- > 0) {
                    int[] now = point.poll();

                    for (int i = 0; i < 4; i++) {
                        int nh = now[0] + move[i][0];
                        int nw = now[1] + move[i][1];

                        if (nh < 0 || nh >= h || nw < 0 || nw >= w) {
                            escape = true;
                            break loop;
                        }

                        if (visit[nh][nw]) {
                            continue;
                        }

                        if (map[nh][nw] == '.') {
                            visit[nh][nw] = true;
                            point.add(new int[] { nh, nw });
                        }

                    }
                }

                if (point.isEmpty()) {
                    break;
                }

            }

            if (escape) {
                sb.append(count).append("\n");
            }else{
                sb.append("IMPOSSIBLE\n");
            }


        }

        System.out.println(sb.toString().trim());

    }
}
