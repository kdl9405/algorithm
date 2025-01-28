package boj;

import java.io.*;
import java.util.*;

/*
 * 드래곤 커브
 */
public class BOJ15685 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        map = new boolean[101][101];
        dp = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            dp.add(new ArrayList<>());
            dp.get(i).add(new ArrayList<>());
            dp.get(i).get(0).add(i);
        }

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            drawing(x, y, d, g);
        }

        int count = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j]) {
                    if (map[i + 1][j] && map[i + 1][j + 1] && map[i][j + 1]) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (map[i][j]) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.println();
        }

    }

    static List<List<List<Integer>>> dp;
    static boolean[][] map;
    static int[][] direction = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};

    static void drawing(int x, int y, int d, int g) {

        List<Integer> list = findDP(d, g);

        map[y][x] = true;
        for (int i = 0; i < list.size(); i++) {
            y += direction[list.get(i)][0];
            x += direction[list.get(i)][1];

            map[y][x] = true;
        }

        // int nx = x;
        // int ny = y;
        // map[nx][ny] = true;
        // for (int l : list) {
        // nx += direction[l][0];
        // ny += direction[l][1];

        // if (nx<0 || nx >100 || ny<0 || ny>100) {
        // System.out.println("!!!!!!!!!!!!!!!");
        // continue;
        // }

        // map[nx][ny] = true;
        // }
    }

    static List<Integer> findDP(int d, int g) {
        if (dp.get(d).size() > g) {
            return dp.get(d).get(g);
        }

        List<Integer> list = findDP(d, g - 1);

        int size = list.size();

        for (int i = size - 1; i >= 0; i--) {
            if (list.get(i) >= 3) {
                list.add(0);
            } else {
                list.add(list.get(i) + 1);
            }
        }

        dp.get(d).add(list);
        // System.out.println(dp.get(d).size() + " " + list.size());

        return list;
    }
}
