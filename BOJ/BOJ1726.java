package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1726 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> queue = new LinkedList<>();

        int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).map(i -> i - 1).toArray();
        int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).map(i -> i - 1).toArray();

        queue.add(start);

        visit = new boolean[m][n][4];
        visit[start[0]][start[1]][start[2]] = true;

        answer = 0;

        loop: while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {
                int[] now = queue.poll();

                if (now[0] == end[0] && now[1] == end[1] && now[2] == end[2]) {
                    break loop;
                }

                for(int i = 1; i<=3; i++){
                    int nx = now[0]+d[now[2]][0]*i;
                    int ny = now[1]+d[now[2]][1]*i;

                    if (nx <0 || nx>=m || ny<0 || ny>=n || visit[nx][ny][now[2]]) {
                        continue;
                    }

                    visit[nx][ny][now[2]] = true;
                    queue.add(new int[]{nx,ny,now[2]});
                }

                int nd = (now[2]+1)%4;
                if (!visit[now[0]][now[1]][nd]) {
                    visit[now[0]][now[1]][nd] = true;
                    queue.add(new int[]{now[0],now[1],nd});
                }
                nd = (now[2]+3)%4;
                if (!visit[now[0]][now[1]][nd]) {
                    visit[now[0]][now[1]][nd] = true;
                    queue.add(new int[]{now[0],now[1],nd});
                }

            }

            answer++;
        }

        System.out.println(answer);

    }

    static int m, n, answer;
    static int[][] map;
    static boolean[][][] visit;

    static int[][] d = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
}
