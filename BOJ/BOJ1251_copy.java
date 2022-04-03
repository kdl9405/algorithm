package BOJ;

/* 
    단어 나누기

    응~ 그리디 안돼 
*/

import java.io.*;

public class BOJ1251_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();

        find(0, 3);

        System.out.println(sb.toString());

    }

    static String s;
    static StringBuilder sb = new StringBuilder();

    static void find(int start, int depth) {

        if (depth == 1) {
            sb.append(new StringBuilder(s.substring(start)).reverse());
            return;
        }

        int min = 27;
        int index = 0;
        for (int i = start; i < s.length() - depth + 1; i++) {

            if (s.charAt(i) - 'a' < min) {
                min = s.charAt(i)-'a';
                index = i;
            }
        }

        sb.append(new StringBuilder(s.substring(start, index+1)).reverse());

        find(index + 1, depth - 1);
    }
}
