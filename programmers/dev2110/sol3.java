package programmers.dev2110;

import java.util.*;

public class sol3 {

    public static void main(String[] args) {

        int[][] macaron = {{1, 1}, {1, 2}, {1, 4}, {2, 1}, {2, 2}, {2, 3}, {3, 4}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {4, 4}, {4, 3}, {5, 4}, {6, 1}};

        solution(macaron);

        System.out.println("!!");

    }

    public static String[] solution(int[][] macaron) {
        String[] answer = new String[6];

        map = new int[6][6];

        for (int[] m : macaron) {

            visit = new boolean[6][6];

            for (int i = 0; i < 5; i++) {
                if (map[i + 1][m[0] - 1] != 0) {
                    map[i][m[0] - 1] = m[1];

                    delete = new ArrayList<>();
                    checkDFS(i, m[0] - 1, m[1]);

                    break;
                }

                if (i == 4) {
                    map[5][m[0] - 1] = m[1];

                    delete = new ArrayList<>();
                    checkDFS(5, m[0] - 1, m[1]);
                }
            }

            if (delete.size() >= 3) {

                System.out.println("입력 후 삭제?");

                for (int[] p : delete) {
                    map[p[0]][p[1]] = 0;
                }

                move();
            }

            System.out.println("----------------");
            for(int i = 0; i<6; i++){
                for(int j = 0; j<6; j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("----------------");

            while (true) {

                check = false;

                checkALL();

                if (!check) {
                    break;
                }

                for(int i = 0; i<6; i++){
                    for(int j = 0; j<6; j++){
                        System.out.print(map[i][j]+" ");
                    }
                    System.out.println();
                }
                System.out.println("----------------");
            }

            for(int i = 0; i<6; i++){
                for(int j = 0; j<6; j++){
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("----------------");

        }

        for (int i = 0; i < 6; i++) {
            StringBuilder sb = new StringBuilder();
            for(int n : map[i]){
                sb.append(n);
            }
            answer[i] = sb.toString();
        }

        return answer;
    }

    static int[][] map;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static boolean[][] visit;
    static List<int[]> delete;
    static boolean check;

    static void checkDFS(int x, int y, int c) {

        visit[x][y] = true;

        delete.add(new int[] { x, y });

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= 6 || ny < 0 || ny >= 6) {
                continue;
            }

            if (map[nx][ny] == c && !visit[nx][ny]) {
                checkDFS(nx, ny, c);
            }

        }

        return;
    }

    static void move() {

        System.out.println("무브");

        System.out.println("----------------");
        for(int i = 0; i<6; i++){
            for(int j = 0; j<6; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------------");

        for (int i = 0; i < 6; i++) {
            int count = 0;
            if (map[5][i] == 0) {
                count++;
            }else{
                continue;
            }
            for (int j = 4; j >= 0; j--) {
                if (map[j][i] == 0) {
                    count++;
                } else {
                   
                    map[j + count][i] = map[j][i];
                    map[j][i] = 0;
                    
                }

            }
        }

        System.out.println("----------------");
        for(int i = 0; i<6; i++){
            for(int j = 0; j<6; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------------");

        return;
    }

    static void checkALL() {

        visit = new boolean[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 5; j >= 0; j--) {

                if (map[j][i] == 0) {
                    break;
                }

                delete = new ArrayList<>();
                checkDFS(j, i, map[j][i]);

                if (delete.size() >= 3) {

                    System.out.println("삭제 "  + map[j][i]);

                    for (int[] p : delete) {
                        map[p[0]][p[1]] = 0;
                    }

                    move();

                    check = true;
                    return;
                }

            }
        }

        return;

    }

}
