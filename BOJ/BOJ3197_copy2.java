package BOJ;

/* 
    백조의 호수


    1. 물이 있는 영역 그룹을 조사.
    2. 얼음이 녹은 영역은 주변과 비교해서, 그 영역 그룹을 정의.
    3. 하루가 지난 후 녹은 얼음의 영역 그룹이 정의되면, 백조의 영역을 비교.
    4. 백조의 영역이 같은면 => 만났다!!!
*/

import java.io.*;
import java.util.*;

public class BOJ3197_copy2 {

    static int R, C, areaNum;
    static int[][] lake;
    static List<int[]> swan;
    static int[] area;
    static Queue<int[]> ice;
    static Queue<int[]> water;

    static int[] dr = { 0, 0, -1, 1 };
    static int[] dc = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        lake = new int[R][C];
        swan = new ArrayList<>();
        ice = new LinkedList<>();
        water = new LinkedList<>();

        areaNum = 1;

        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (line[j] != 'X') {
                    water.add(new int[] { i, j });
                    if (line[j] == 'L') {
                        swan.add(new int[] { i, j });
                    }
                    lake[i][j] = areaNum;
                    areaNum++;
                } else {
                    lake[i][j] = -1;
                }
            }
        }

        area = new int[areaNum];
        int day = 0;

        while (true) {

            // 녹은 얼음 영역 체크
            checkArea();

            if (findArea(lake[swan.get(0)[0]][swan.get(0)[1]]) == findArea(
                    lake[swan.get(1)[0]][swan.get(1)[1]])) {
                break;
            }

            day++;
            
            // 접촉된 얼음 녹이기!!
            meltIce();

        }

        System.out.println(day);

    }

    static void checkArea() {

        boolean[][] visit = new boolean[R][C];

        int size = water.size();
        int a = 0;
        int b = 0;

        while (size-- > 0) {
            int[] w = water.poll();

            if (visit[w[0]][w[1]]) {
                continue;
            }
            visit[w[0]][w[1]] = true;

            a = findArea(lake[w[0]][w[1]]);

            for (int i = 0; i < 4; i++) {
                int nr = w[0] + dr[i];
                int nc = w[1] + dc[i];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C || visit[nr][nc]) {
                    continue;
                }
                if (lake[nr][nc] == -1) {
                    visit[nr][nc] = true;
                    ice.add(new int[] { nr, nc, a });
                    continue;
                }

                b = findArea(lake[nr][nc]);
                if (a != b) {
                    area[b] = a;
                }

            }

        }

        return;

    }

    static void meltIce() {

        int size = ice.size();

        boolean[][] visit = new boolean[R][C];
        while (size-- > 0) {

            int[] i = ice.poll();

            if (visit[i[0]][i[1]]) {
                continue;
            }
            visit[i[0]][i[1]] = true;

            lake[i[0]][i[1]] = i[2];
            water.add(new int[] { i[0], i[1] });

            for (int d = 0; d < 4; d++) {
                int nr = i[0] + dr[d];
                int nc = i[1] + dc[d];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C || visit[nr][nc]) {
                    continue;
                }

                if (lake[nr][nc] == -1) {
                    ice.add(new int[] { nr, nc, i[2] });
                }
            }
        }
        return;

    }

    static int findArea(int n) {

        if (area[n] == 0) {
            return n;
        }

        return area[n] = findArea(area[n]);
    }
}
