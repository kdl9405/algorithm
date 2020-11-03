import java.util.*;

/**
 * 기둥과 보 설치
 * 
 */
public class pro87 {

    public static void main(String[] args) {

        int[][] build_frame = { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 },
                { 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } };

        int[][] s = solution(5, build_frame);

        System.out.println("정렬!!!!!");

        for (int[] i : s) {
            for (int j = 0; j < 3; j++) {
                System.out.print(i[j] + " ");
            }
            System.out.println("");
        }
    }

    static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};

        mapA = new int[n + 3][n + 3]; // 기둥 / 0 = 미설치 / 1 = 설치
        mapB = new int[n + 3][n + 3]; // 보 / 0 = 미설치 / 1 = 설치

        for (int[] f : build_frame) {
            int y = f[0] + 1;
            int x = f[1] + 1;
            int a = f[2];

            switch (a) {
                case 0:
                    System.out.println(x+" " + y+" "+ check(x, y, 0));

                    if (f[3] == 1) {
                        if (check(x, y, 0)) {
                            mapA[x][y] = 1;
                        }
                    } else {
                        mapA[x][y] = 0;
                        for (int i = 0; i < 9; i++) {
                            int nx = x + dx[i];
                            int ny = y + dy[i];

                            if (mapA[nx][ny] == 1 && !check(nx, ny, 0)) {
                                mapA[x][y] = 1;
                                break;
                            }
                            if (mapB[nx][ny] == 1 && !check(nx, ny, 1)) {
                                mapA[x][y] = 1;
                                break;
                            }

                        }
                    }

                    break;

                case 1:
                    if (f[3] == 1) {
                        if (check(x, y, a)) {
                            mapB[x][y] = 1;
                        }
                    } else {
                        mapB[x][y] = 0;
                        for (int i = 0; i < 9; i++) {
                            int nx = x + dx[i];
                            int ny = y + dy[i];
                            if (mapA[nx][ny] == 1 && !check(nx, ny, 0)) {
                                mapB[x][y] = 1;
                                break;
                            }
                            if (mapB[nx][ny] == 1 && !check(nx, ny, 1)) {
                                mapB[x][y] = 1;
                                break;
                            }

                        }
                    }
                    break;
            }
        }

        List<Integer[]> list = new LinkedList<>();
        for(int i = 1; i<n+2; i++){
            for(int j = 1; j<n+2; j++){
                if (mapA[j][i] == 1) {
                    list.add(new Integer[]{i,j,0});
                }
                if (mapB[j][i] == 1) {
                    list.add(new Integer[]{i,j,1});
                }
            }
        }

        answer = new int[list.size()][3];
        for(int i = 0; i<list.size(); i++){
            answer[i][0] = list.get(i)[0]-1;
            answer[i][1] = list.get(i)[1]-1;
            answer[i][2] = list.get(i)[2];
        }

        return answer;
    }

    static int[][] mapA;
    static int[][] mapB;
    static int[] dx = { 0, 0, 0, -1, -1, -1, 1, 1, 1 };
    static int[] dy = { 0, -1, 1, 0, -1, 1, 0, -1, 1 };

    static boolean check(int x, int y, int a) {
        boolean possible = false;

        switch (a) {
            case 0:
                if (x == 1 || mapB[x][y] == 1 || mapA[x - 1][y] == 1 || mapB[x][y - 1] == 1) {
                    possible = true;
                }
                break;
            case 1:
                if (mapA[x - 1][y] == 1 || mapA[x - 1][y + 1] == 1) {
                    possible = true;
                } else if (mapB[x][y - 1] == 1 && mapB[x][y + 1] == 1) {
                    possible = true;
                }
                break;
        }

        return possible;
    }

}