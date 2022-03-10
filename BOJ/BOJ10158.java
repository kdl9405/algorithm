package BOJ;

/**
 * 개미
 */

import java.io.*;
import java.util.*;

public class BOJ10158 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int x = (t + p) % (2*w);
        int y = (t + q) % (2*h);

        if (x > w) {
            x = 2*w-x;
        }

        if (y > h) {
            y = 2*h-y;
        }

        System.out.println(x+" " +y);
    }

}