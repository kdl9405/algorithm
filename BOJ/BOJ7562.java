package BOJ;

/*
    나이트의 이동
*/

import java.io.*;
import java.util.*;

public class BOJ7562 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int l = Integer.parseInt(br.readLine());
            boolean[][] visit = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] { x1, y1 });

            int count = 0;
            boolean find = false;

            while (!queue.isEmpty()) {

                int size = queue.size();

                while (size-- > 0) {
                    int[] now = queue.poll();

                    if (now[0] == x2 && now[1] == y2) {
                        find = true;
                        break;
                    }

                    for (int i = 0; i < 8; i++) {
                        int nx = now[0] + dx[i];
                        int ny = now[1] + dy[i];

                        if (nx < 0 || nx >= l || ny < 0 || ny >= l || visit[nx][ny]) {
                            continue;
                        }

                        visit[nx][ny] = true;
                        queue.add(new int[] { nx, ny });
                    }

                }

                if (find) {
                    break;
                }

                count++;
            }

            sb.append(count + "\n");

        }

        System.out.println(sb.toString().trim());
    }

    static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
}
