package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
오리
 */

public class BOJ12933 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String duck = br.readLine();

        if (duck.length() % 5 != 0) {
            System.out.println(-1);
        } else {

            boolean check = true;

            boolean[] visit = new boolean[duck.length()];

            int count = 0;

            while (true) {
                check = false;

                char c = 'q';

                for (int i = 0; i < duck.length(); i++) {
                    if (visit[i]) {
                        continue;
                    }

                    if (duck.charAt(i) == c) {
                        visit[i] = true;
                        if (c == 'k') {
                            check = true;
                        }
                        c = next(c);
                    }
                }

                if (check) {
                    count++;
                } else {
                    break;
                }

            }

            if (count == 0) {
                count = -1;
            } else {
                for (boolean b : visit) {
                    if (!b) {
                        count = -1;
                    }
                }

            }

            System.out.println(count);
        }

    }

    static char next(char c) {
        if (c == 'q') {
            return 'u';
        } else if (c == 'u') {
            return 'a';
        } else if (c == 'a') {
            return 'c';
        } else if (c == 'c') {
            return 'k';
        } else {
            return 'q';
        }
    }

}
