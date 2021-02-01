package programmers;

//기둥과 보

/* 
    1. 생성 가능 체크 함수 / 삭제 가능 체크 함수
    2. 최종 결과 체크
*/

public class pro121 {

    public static void main(String[] args) {

        int n = 5;
        int[][] build_frame = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
                { 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };

        int[][] answer = solution(n, build_frame);

        for (int[] a : answer) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println("");
        }

    }

    static int[][] solution(int n, int[][] build_frame) {

        mapA = new int[n + 1][n + 1];
        mapB = new int[n + 1][n + 1];

        int count = 0;

        for (int[] build : build_frame) {

            int x = build[0];
            int y = build[1];
            int f = build[2];

            if (build[3] == 1 && createCheck(x, y, f)) {
                if (f == 0) {
                    mapA[y][x] = 1;
                } else {
                    mapB[y][x] = 1;
                }

                count++;
            }

            if (build[3] == 0) {

                count--;

                if (f == 0) {
                    mapA[y][x] = 0;
                } else {
                    mapB[y][x] = 0;
                }

                if (!deleteCheck(x, y, f)) {
                    if (f == 0) {
                        mapA[y][x] = 1;
                    } else {
                        mapB[y][x] = 1;
                    }
                    count++;
                }
            }
        }

        int[][] answer = new int[count][3];

        int c = 0;

        for (int w = 0; w <= n; w++) {
            for (int h = 0; h <= n; h++) {
                if (mapA[h][w] == 1) {
                    answer[c][0] = w;
                    answer[c][1] = h;
                    answer[c][2] = 0;
                    c++;
                }
                if (mapB[h][w] == 1) {
                    answer[c][0] = w;
                    answer[c][1] = h;
                    answer[c][2] = 1;
                    c++;
                }
            }
        }

        return answer;
    }

    static int[][] mapA;
    static int[][] mapB;
    static int[] dx = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
    static int[] dy = { 1, 1, 1, 0, 0, 0, -1, -1, -1 };

    static boolean createCheck(int x, int y, int a) {

        switch (a) {
            case 0:

                if (y == 0) {
                    return true;
                }

                if (mapB[y][x] == 1) {
                    return true;
                }
                if (x > 0 && mapB[y][x - 1] == 1) {
                    return true;
                }

                if (y > 0 && mapA[y - 1][x] == 1) {
                    return true;
                }

                break;

            case 1:

                if (y > 0 && mapA[y - 1][x] == 1) {
                    return true;
                }
                if (y > 0 && x < mapA.length - 1 && mapA[y - 1][x + 1] == 1) {
                    return true;
                }
                if (x > 0 && x < mapB.length - 2 && mapB[y][x - 1] == 1 && mapB[y][x + 1] == 1) {
                    return true;
                }

                break;
        }

        return false;
    }

    static boolean deleteCheck(int x, int y, int a) {

        for (int i = 0; i < 9; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < mapA.length && ny >= 0 && ny < mapA.length) {
                if (mapA[ny][nx] == 1 && !createCheck(nx, ny, 0)) {
                    return false;
                }
                if (mapB[ny][nx] == 1 && !createCheck(nx, ny, 1)) {
                    return false;
                }
            }
        }

        return true;

    }
}