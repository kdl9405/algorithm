package boj;

import java.util.Scanner;

public class BOJ1343 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String board = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        int count = 0;

        loop: for (int i = 0; i < board.length(); i++) {
            char c = board.charAt(i);

            if (i == board.length() - 1 && c == 'X') {
                count++;
            }

            if (c == '.' || i == board.length() - 1) {

                if (count > 0) {
                    if (count >= 4) {
                        int x = count / 4;
                        count -= (x * 4);
                        while (x-- > 0) {
                            sb.append("AAAA");
                        }
                    }
                    if (count % 2 == 0) {
                        int x = count / 2;
                        while (x-- > 0) {
                            sb.append("BB");
                        }
                    } else {
                        sb = new StringBuilder();
                        sb.append(-1);
                        break loop;
                    }
                    count = 0;
                }
                if (c == '.') {
                    sb.append(c);
                }
            } else {
                count++;
            }
        }

        System.out.println(sb.toString());
    }
}
