package BOJ;

import java.io.*;
import java.util.*;

/* 
    분수 합
*/
public class BOJ1735 {

    public static void main(String[] args) throws IOException {

        new BOJ1735().solution();
    }

    private void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c1 = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c2 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        int p = (p1 * p2);
        int c = ((c1 * p2) + (c2 * p1));

        int lcd = LCD(c, p);
        System.out.println((c/lcd)+" " + (p/lcd));

    }

    private int LCD(int a, int b) {
        while (b != 0) {
            int n = a % b;
            a = b;
            b = n;
        }
        return a;
    }

}
