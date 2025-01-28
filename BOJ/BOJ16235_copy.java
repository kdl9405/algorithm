package boj;

import java.io.*;
import java.util.*;

/*
 * 나무 재테크
 * 
 * 1. 봄 - 나무가 양분을 먹음 / 양분을 못먹은 나무는 죽음. 2. 여름 - 죽은 나무가 양분으로 변함 - 나이/2 가 양분으로 추가 3. 가을 - 나무의 번식 - 나이가
 * 5의 배수인 나무만 4. 겨울 - 양분 추가
 */
public class BOJ16235_copy {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        A = new int[N + 1][N + 1];

        PriorityQueue<Tree> live = new PriorityQueue<>();
        PriorityQueue<Tree> dead = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], 5);
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            live.add(new Tree(x, y, z));
        }

        while (K-- > 0) {

            PriorityQueue<Tree> temp = new PriorityQueue<>();

            while (!live.isEmpty()) {
                Tree now = live.poll();

                if (map[now.x][now.y] >= now.z) {
                    map[now.x][now.y] -= now.z;
                    temp.add(new Tree(now.x, now.y, now.z + 1));
                } else {
                    dead.add(now);
                }
            }

            while (!dead.isEmpty()) {
                Tree now = dead.poll();

                map[now.x][now.y] += now.z / 2;
            }

            while (!temp.isEmpty()) {
                Tree now = temp.poll();

                if (now.z % 5 == 0) {

                    for (int i = 0; i < 8; i++) {
                        int nx = now.x + dx[i];
                        int ny = now.y + dy[i];

                        if (nx < 1 || nx > N || ny < 1 || ny > N) {
                            continue;
                        }

                        live.add(new Tree(nx, ny, 1));
                    }
                }

                live.add(now);
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] += A[i][j];
                }
            }

        }

        System.out.println(live.size());

    }

    static int N;
    static int[][] map;
    static int[][] A;

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    private class Tree implements Comparable<Tree> {

        int x;
        int y;
        int z;

        public Tree(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Tree o) {
            // TODO Auto-generated method stub
            return this.z - o.z;
        }

    }

}
