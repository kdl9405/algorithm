package boj;

import java.io.*;
import java.util.*;

/*
 * 나무 재테크
 * 
 * 1. 봄 - 나무가 양분을 먹음 / 양분을 못먹은 나무는 죽음. 2. 여름 - 죽은 나무가 양분으로 변함 - 나이/2 가 양분으로 추가 3. 가을 - 나무의 번식 - 나이가
 * 5의 배수인 나무만 4. 겨울 - 양분 추가
 * 
 * 
 * => 봄 여름의 로직을 줄이는 게 관건... 어떤 자료구조로 한번에 처리할 수 있을까..
 */
public class BOJ16235 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        A = new int[N + 1][N + 1];
        treeMap = new ArrayList[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], 5);
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                treeMap[i][j] = new ArrayList<>();

            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            treeMap[x][y].add(z);
        }

        while (K-- > 0) {

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    boolean eatable = true;

                    Collections.sort(treeMap[i][j]);


                }
            }

            // winter
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] += A[i][j];
                }
            }

        }

    }

    static int N;
    static int[][] map;
    static int[][] A;
    static ArrayList<Integer>[][] treeMap;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static class Tree {

        int x;
        int y;
        int z;

        public Tree(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
