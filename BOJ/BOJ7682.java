package boj;

import java.io.*;

/*
 * 틱택토
 */
public class BOJ7682 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String state = br.readLine();
            if (state.equals("end")) {
                break;
            }

            if (checkValid(state)) {
                sb.append("valid\n");
            } else {
                sb.append("invalid\n");
            }
        }

        System.out.println(sb.toString());

    }

    static boolean checkValid(String state) { // 누군가가 승리한 경우, 판이 가득찬 경우

        int x = state.replaceAll("[^X]", "").length();
        int o = state.replaceAll("[^O]", "").length();

        if ((x + o == 9) && (x != 5 || o != 4)) {
            return false;
        }

        char[] map = state.toCharArray();
        int col = 0;
        int row = 0;
        int cross = 0;
        int winner = -1;

        for (int i = 0; i <= 2; i++) {
            if (map[i] == map[i + 3] && map[i] == map[i + 6]) {
                if (map[i] == '.') {
                    continue;
                }
                col++;
                if (map[i] == 'X') {
                    winner = 0;
                } else {
                    winner = 1;
                }
            }
        }
        if (col > 1) {
            return false;
        }

        for (int i = 0; i <= 6; i += 3) {
            if (map[i] == map[i + 1] && map[i] == map[i + 2]) {
                if (map[i] == '.') {
                    continue;
                }
                row++;
                if (map[i] == 'X') {
                    winner = 0;
                } else {
                    winner = 1;
                }
            }
        }

        if (row > 1) {
            return false;
        }

        if (map[4] != '.' && (map[0] == map[4] && map[4] == map[8])
                || (map[2] == map[4] && map[4] == map[6])) {

            cross++;
            if (map[4] == 'X') {
                winner = 0;
            } else {
                winner = 1;
            }
        }

        if (winner == 0 && (x - o != 1)) {
            return false;
        }
        if (winner == 1 && (x != o)) {
            return false;
        }

        if (row == 0 && col == 0 && cross == 0 && x + o != 9) {
            return false;
        }

        return true;
    }
}
