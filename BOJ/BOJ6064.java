package BOJ;

import java.io.*;
import java.util.*;

/* 
    카잉 달력
*/
public class BOJ6064 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int lcm = LCM(M, N);

            int i = 0;
            int answer = -1;
            while (i * M <= lcm) {
                if ((i * M + x - y) % N == 0) {
                    answer = i*M+x;
                }
                i++;
            }

            sb.append(answer +" \n");

        }

        System.out.println(sb.toString());
    }

    static int GCD(int x, int y) {

        if (x < y) {
            int temp = y;
            y = x;
            x = temp;
        }

        int n;
        while (y != 0) {
            n = x % y;
            x = y;
            y = n;
        }

        return x;
    }

    static int LCM(int x, int y) {
        int g = GCD(x, y);

        return (x * y) / g;
    }
}
