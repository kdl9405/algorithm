package BOJ;

/* 
    도영이가 만든 맛있는 음식
*/

import java.io.*;
import java.util.*;

public class BOJ2961 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        taste = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            taste[i][0] = Integer.parseInt(st.nextToken());
            taste[i][1] = Integer.parseInt(st.nextToken());
        }

        diff = 1000000000;

        cook(0, 0, 1, 0);

        System.out.println(diff);
    }

    static int N;
    static int[][] taste;
    static int diff;

    static void cook(int index, int bit, int sour, int bitter) {

        if (index == N) {

            if (bit == 0) {
                return;
            }

            diff = Math.min(diff, Math.abs(sour - bitter));

            return;
        }

        cook(index+1, bit, sour, bitter);
        cook(index+1, bit | (1<<index), sour*taste[index][0], bitter+taste[index][1]);

    }

}
