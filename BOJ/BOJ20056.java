package BJ;

import java.io.*;
import java.util.*;

/* 
    마법사 상어와 파이어
*/

public class BJ20056 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        direcion = new int[][] { { N - 1, 0 }, { N - 1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, N - 1 }, { 0, N - 1 },
                { N - 1, N - 1 } };

        fireball = new ArrayList<>();
        while (M-- > 0) {

            int[] fire = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            fire[0]--;
            fire[1]--;
            fireball.add(fire);

        }

        while (K-- > 0) {

            move();

            System.out.println("------이동 후-------");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j][0] + " ");
                }
                System.out.println();
            }

            divide();

            System.out.println("------분할 후-------");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j][0] + " ");
                }
                System.out.println();
            }

        }

        int sum = 0;
        for (int[] fire : fireball) {
            sum += fire[2];
        }

        System.out.println(sum);

    }

    static int N, M, K;
    static int[][][] map; // [0] 질량 [1] 속도 [2] 방향 (속도와 방향은 합쳐지지 않은 경우에만)
    static int[][][] mergeInfo; // [0] 방향 0은 미정, 1은 홀수, 2는 짝수, 3은 불일치 //[1] 속도 // [2](합쳐진 파이어볼 개수)
    static List<int[]> fireball;
    static int[][] direcion; // 0~7 이동

    static void move() { // fireball 리스트를 받아서 이동하여 맵 작성 (질량 맵, 방향맵, 속도맵 ) + 병합리스트
        // 리스트로 받은 파이어볼 정보를 기반으로 이동(합쳐지는 파이어볼은 수량과 방향일치성을 체크해야함.)
        // 합쳐지지 않은 파이어볼은 방향과 속도를 기억해야함.

        map = new int[N][N][3];
        mergeInfo = new int[N][N][3];

        for (int[] fire : fireball) {
            int m = fire[2];
            int s = fire[3];
            int d = fire[4];

            int nr = fire[0] + (s * direcion[d][0]);
            int nc = fire[1] + (s * direcion[d][1]);
            nr %= N;
            nc %= N;

            map[nr][nc][0] += m;
            map[nr][nc][1] = s;
            map[nr][nc][2] = d;

            if (mergeInfo[nr][nc][0] == 0) {
                if (d % 2 == 0) {
                    mergeInfo[nr][nc][0] = 2;
                } else {
                    mergeInfo[nr][nc][0] = 1;
                }
            } else {
                if (d % 2 == 1 && mergeInfo[nr][nc][0] != 1) {
                    mergeInfo[nr][nc][0] = 3;
                } else if (d % 2 == 0 && mergeInfo[nr][nc][0] != 2) {
                    mergeInfo[nr][nc][0] = 3;
                }
            }
            mergeInfo[nr][nc][1] += s;
            mergeInfo[nr][nc][2]++;
        }

        return;

    }

    static void divide() { // 합쳐진 파이어볼이 있으면 분할시키고 맵 정보를 리스트 만듬

        fireball = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (mergeInfo[i][j][2] > 1) {
                    // 분할
                    if (map[i][j][0] < 5) {
                        continue;
                    }

                    int m = map[i][j][0] / 5;
                    int s = mergeInfo[i][j][1] / mergeInfo[i][j][2];
                    map[i][j][0] = 0;

                    int k = 0;
                    if (mergeInfo[i][j][0] == 3) {
                        k = 1;
                    }

                    for (; k < 8; k += 2) {
                        fireball.add(new int[] { i, j, m, s, k });
                    }

                } else if (mergeInfo[i][j][2] == 1) {
                    fireball.add(new int[] { i, j, map[i][j][0], map[i][j][1], map[i][j][2] });
                }
            }
        }    

        return;

    }

}
