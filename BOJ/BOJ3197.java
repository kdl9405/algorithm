package boj;

/*
 * 백조의 호수
 * 
 * 
 * 1. 물이 있는 영역 그룹을 조사. 2. 얼음이 녹은 영역은 주변과 비교해서, 그 영역 그룹을 정의. 3. 하루가 지난 후 녹은 얼음의 영역 그룹이 정의되면, 백조의 영역을
 * 비교. 4. 백조의 영역이 같은면 => 만났다!!!
 * 
 * 
 * 영역 맵과 호수를 하나로 관리
 */

import java.io.*;
import java.util.*;

public class BOJ3197 {
    static int R, C;
    static char[][] lake;
    static List<Integer> swan;
    static int[] area;
    static Queue<int[]> water;

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        lake = new char[R][C];
        swan = new ArrayList<>();
        water = new LinkedList<>();

        area = new int[R * C + 2];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                lake[i][j] = input.charAt(j);
                if (lake[i][j] != 'X') {
                    if (lake[i][j] == 'L') {
                        swan.add(i * C + j + 1);
                    }

                    checkArea(i, j);
                }
            }
        }

        int day = 0;

        while (true) {


            if (findArea(swan.get(0)) == findArea(swan.get(1))) {
                break;
            }

            day++;

            // 접촉된 얼음 녹이기!!
            meltIce();


        }

        System.out.println(day);

    }

    static void checkArea(int r, int c) {

        lake[r][c] = '.';

        water.add(new int[] {r, c});

        int a = findArea(r * C + c + 1);
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                continue;
            }

            if (lake[nr][nc] == '.') {
                int b = findArea(nr * C + nc + 1);

                if (a != b) {
                    area[b] = a;
                }
            }
        }

        return;

    }

    static void meltIce() {

        int size = water.size();

        while (size-- > 0) {

            int[] w = water.poll();


            for (int i = 0; i < 4; i++) {
                int nr = w[0] + dr[i];
                int nc = w[1] + dc[i];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                    continue;
                }

                if (lake[nr][nc] == 'X') {
                    checkArea(nr, nc);
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
