package programmers;

import java.util.Arrays;

//리틀 프렌즈 사천성

// 26종류
// 두개를 연결할 수 있는 방법은 최대 2개

// 1. 처음 A~Z별로 2개의 좌표 기억
// 2. A부터 순서대로 삭제 할 수 있는지 확인 하고 제거
// 3. 만약 제거 되면 A부터 다시 체크
// 4. Z까지 확인했는데 제거가 안되면, 불가능


public class pro118 {

    public static void main(String[] args) {

        int m = 3;
        int n = 3;
        String[] board = { "DBA", "C*A", "CDB" };

        System.out.println(solution(m, n, board));

    }

    static String solution(int m, int n, String[] board) {
        String answer = "";

        map = board.clone();

        visit = new boolean[26];
        Arrays.fill(visit, true);
        coord = new int[26][2][2];

        int count = 0;

        for (int i = 0; i < m; i++) {
            String line = board[i];
            for (int j = 0; j < n; j++) {
                int ch = line.charAt(j) - 'A';
                if (ch >= 0 && ch < 26) {
                    if (visit[ch]) {
                        count++;
                        visit[ch] = false;
                        coord[ch][0][0] = i;
                        coord[ch][0][1] = j;
                    } else {
                        coord[ch][1][0] = i;
                        coord[ch][1][1] = j;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < 26) {

            if (count == 0) {
                break;
            }

            if (!visit[i]) {
                if (delete(i)) {
                    visit[i] = true;
                    char c = (char) (i + 'A');
                    map[coord[i][0][0]] = map[coord[i][0][0]].replaceAll(Character.toString(c), ".");
                    map[coord[i][1][0]] = map[coord[i][1][0]].replaceAll(Character.toString(c), ".");
                    sb.append(c);
                    i = 0;
                    count--;
                    continue;
                }
            }

            i++;
        }

        if (count == 0) {
            answer = sb.toString();
        } else {
            answer = "IMPOSSIBLE";
        }

        return answer;
    }

    static boolean[] visit;
    static int[][][] coord;
    static String[] map;

    static boolean delete(int ch) {

        int x1 = coord[ch][0][0];
        int y1 = coord[ch][0][1];

        int x2 = coord[ch][1][0];
        int y2 = coord[ch][1][1];

        // 루트 1
        int i = x1;
        while (true) {
            if (map[i].charAt(y1) != (char) ('A' + ch)) {
                if (map[i].charAt(y1) != '.') {
                    break;
                }
            }

            if (i != x2) {
                i++;
            } else {
                break;
            }
        }

        if (i == x2) {
            int j = y1;
            while (j != y2) {
                if (map[i].charAt(j) != (char) ('A' + ch)) {
                    if (map[i].charAt(j) != '.') {
                        break;
                    }
                }

                if (y1 < y2) {
                    j++;
                } else if (y1 > y2) {
                    j--;
                }
            }
            if (j == y2) {
                return true;
            }
        }

        // 루트 2
        i = x2;
        while (true) {
            if (map[i].charAt(y2) != (char) ('A' + ch)) {
                if (map[i].charAt(y2) != '.') {
                    break;
                }
            }

            if (i != x1) {
                i--;
            } else {
                break;
            }
        }

        if (i == x1) {
            int j = y2;
            while (j != y1) {
                if (map[i].charAt(j) != (char) ('A' + ch)) {
                    if (map[i].charAt(j) != '.') {
                        break;
                    }
                }

                if (y2 < y1) {
                    j++;
                } else if (y2 > y1) {
                    j--;
                }
            }
            if (j == y1) {
                return true;
            }
        }

        return false;
    }
}
