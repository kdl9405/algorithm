import java.util.*;

/**
 * 기둥과 보 설치
 * 히든케이스 실패
 */
public class pro87_copy {

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

        mapA = new int[n + 1][n + 1]; // 기둥 / 0 = 미설치 / 1 = 설치
        mapB = new int[n + 1][n + 1]; // 보 / 0 = 미설치 / 1 = 설치

        for (int[] f : build_frame) {

            int x = f[0];
            int y = f[1];

            switch (f[2]) {
                case 0: // 기둥
                    if (f[3] == 1) { // 설치
                        if (check(x, y, 0)) {
                            mapA[x][y] = 1;
                        }
                    } else {
                        mapA[x][y] = 0;
                        if (x<n && mapA[x + 1][y] == 1 && !check(x + 1, y, 0)) {
                            mapA[x][y] = 1;
                            break;
                        }
                        if (x<n && mapB[x + 1][y] == 1 && !check(x + 1, y, 1)) {
                            mapA[x][y] = 1;
                            break;
                        }
                        if (x<n && y>0 && mapB[x + 1][y - 1] == 1 && !check(x + 1, y - 1, 1)) {
                            mapA[x][y] = 1;
                            break;
                        }
                    }
                    break;

                case 1: // 보
                    if (f[3] == 1) {
                        if (check(x, y, 1)) {
                            mapB[x][y] = 1;
                        }
                    } else {
                        mapB[x][y] = 0;
                        if (x>0 && mapB[x-1][y] == 1 && !check(x-1, y, 1)) {
                            mapB[x][y] = 1;
                            break;
                        }
                        if (x<n && mapB[x+1][y] == 1 && !check(x+1, y, 1)) {
                            mapB[x][y] = 1;
                            break;
                        }
                        if (mapA[x][y] == 1 && !check(x, y, 0)) {
                            mapB[x][y] = 1;
                            break;
                        }
                        if (x<n && mapA[x+1][y] == 1 && !check(x+1, y, 0)) {
                            mapB[x][y] = 1;
                            break;
                        }
                    }
                    break;
            }
        }

        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=n; j++){
                System.out.print(mapA[i][j] +" ");
            }
            System.out.println("");
        }
        System.out.println("");


        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=n; j++){
                System.out.print(mapB[i][j] +" ");
            }
            System.out.println("");
        }

        List<Integer[]> list = new LinkedList<>();
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=n; j++){
                if (mapA[i][j] == 1) {
                    list.add(new Integer[]{i,j,0});
                }
                if (mapB[i][j] == 1) {
                    list.add(new Integer[]{i,j,1});
                }
            }
        }

        answer = new int[list.size()][3];
        for(int i = 0; i<list.size(); i++){
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
            answer[i][2] = list.get(i)[2];
        }

        return answer;
    }

    static int[][] mapA;
    static int[][] mapB;

    static boolean check(int x, int y, int z) {
        boolean possible = false;

        switch (z) {
            case 0:
                if (y == 0 || mapB[x - 1][y] == 1 || mapA[x][y - 1] == 1) {
                    possible = true;
                }
                break;
            case 1:
                if (mapA[x][y - 1] == 1 || mapA[x + 1][y - 1] == 1) {
                    possible = true;
                } else if (mapB[x - 1][y] == 1 && mapB[x + 1][y] == 1) {
                    possible = true;
                }
                break;
        }

        return possible;
    }

}