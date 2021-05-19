package BOJ;

import java.io.*;
import java.util.*;

/* 
    톱니바퀴 

    1. 회전 전에, 마주보는 부분 확인 후 회전방식 지정(1,-1,0)
    2. 


*/
public class BOJ14891 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        s = new String[5];
        for (int i = 1; i <= 4; i++) {
            s[i] = br.readLine();
        }

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            check(x, d);

        }

        int sum = 0;
        for (int i = 1; i <= 4; i++) {
            if (s[i].charAt(0) == '1') {
                sum += Math.pow(2, i - 1);
            }
        }

        System.out.println(sum);

    }

    static String[] s;

    static void check(int n, int d) {

        Queue<int[]> queue = new LinkedList<>();

        // 오른쪽 체크
        int nd = d;
        for (int i = n; i < 4; i++) {
            if (s[i].charAt(2) == s[i + 1].charAt(6)) {
                break;
            }
            nd *= -1;
            queue.add(new int[] { i + 1, nd });
        }

        // 왼쪽 체크
        nd = d;
        for (int i = n; i > 1; i--) {
            if (s[i].charAt(6) == s[i - 1].charAt(2)) {
                break;
            }
            nd *= -1;
            queue.add(new int[] { i - 1, nd });
        }

        rotate(n, d);

        while (!queue.isEmpty()) {

            rotate(queue.peek()[0], queue.poll()[1]);
        }

        return;
    }

    static void rotate(int n, int d) {

        if (d == -1) {
            String ns = s[n].substring(1);
            ns += s[n].charAt(0);
            s[n] = ns;
        } else {
            String ns = s[n].substring(0, 7);
            ns = s[n].charAt(7) + ns;
            s[n] = ns;
        }

        return;
    }
}
