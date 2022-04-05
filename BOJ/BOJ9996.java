package BOJ;

/* 
    한국이 그리울 땐 서버에 접속하지
 */

import java.io.*;
import java.util.*;

public class BOJ9996 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), "*", false);

        start = st.nextToken();
        end = st.nextToken();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (isCorrect(br.readLine())) {
                sb.append("DA\n");
            } else {
                sb.append("NE\n");
            }
        }
        System.out.println(sb.toString().trim());
    }

    static String start, end;

    static boolean isCorrect(String s) {

        if (s.length() < start.length() + end.length()) {
            return false;
        }

        if (!s.startsWith(start) || !s.endsWith(end)) {
            return false;
        }

        return true;
    }
}
