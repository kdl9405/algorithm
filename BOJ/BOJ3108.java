package BOJ;

/* 
    로고 

    1. 직사각형들의 교차그룹의 수 
    2.  if(0,0을 지나가는 직사각형이 없으면) +1

*/

import java.io.*;
import java.util.*;

public class BOJ3108 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        map = new int[1001][1001];
        group = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken())+500;
            int y1 = Integer.parseInt(st.nextToken())+500;
            int x2 = Integer.parseInt(st.nextToken())+500;
            int y2 = Integer.parseInt(st.nextToken())+500;

            int sqaure = i;

            for (int r = x1; r <= x2; r++) {

                if (map[r][y1] == 0) {
                    map[r][y1] = sqaure;
                } else {
                    int a = findGroup(map[r][y1]);
                    int b = findGroup(sqaure);

                    if (a == b) {
                        sqaure = a;
                    } else {
                        group[b] = a;
                    }
                }

                if (map[r][y2] == 0) {
                    map[r][y2] = sqaure;
                } else {
                    int a = findGroup(map[r][y2]);
                    int b = findGroup(sqaure);

                    if (a == b) {
                        sqaure = a;
                    } else {
                        group[b] = a;
                    }
                }
            
            }

            for (int c = y1; c <= y2; c++) {
                if (map[x1][c] == 0) {
                    map[x1][c] = sqaure;
                } else {
                    int a = findGroup(map[x1][c]);
                    int b = findGroup(sqaure);

                    if (a == b) {
                        sqaure = a;
                    } else {
                        group[b] = a;
                    }
                }

                if (map[x2][c] == 0) {
                    map[x2][c] = sqaure;
                } else {
                    int a = findGroup(map[x2][c]);
                    int b = findGroup(sqaure);

                    if (a == b) {
                        sqaure = a;
                    } else {
                        group[b] = a;
                    }
                }

            }

        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(findGroup(i));
        }

        int count = set.size();
        if (map[500][500] != 0) {
            count--;
        }

        System.out.println(count);

    }

    static int[][] square;
    static int[][] map;
    static int[] group;

    static int findGroup(int n) {

        if (group[n] == 0) {
            return n;
        }

        return group[n] = findGroup(group[n]);
    }

}
