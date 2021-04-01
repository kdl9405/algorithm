package BOJ;

import java.io.*;
import java.util.*;

/* 
    단어 섞기

    
*/
public class BOJ9177 {

    static char[] A, B, D;
    static boolean possible;
    static boolean [][] visit;

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            st = new StringTokenizer(br.readLine());

            A = st.nextToken().toCharArray();
            B = st.nextToken().toCharArray();
            D = st.nextToken().toCharArray();

            visit = new boolean[A.length+1][B.length+1];
            possible = false;
            makeCheck(A.length - 1, B.length - 1, D.length - 1);

            if (possible) {
                sb.append("Data set " + t + ": ").append("yes\n");
            } else {
                sb.append("Data set " + t + ": ").append("no\n");
            }

        }

        System.out.println(sb.toString());
    }

    static void makeCheck(int aIdx, int bIdx, int dIdx) {

        if (visit[aIdx+1][bIdx+1]) {
            return;
        }
        visit[aIdx+1][bIdx+1] = true;

        if (aIdx < 0 && bIdx < 0 && dIdx < 0) {
            possible = true;
            return;
        }

        if (aIdx >= 0 && D[dIdx] == A[aIdx]) {
            makeCheck(aIdx - 1, bIdx, dIdx - 1);
        }

        if (bIdx >= 0 && D[dIdx] == B[bIdx]) {
            makeCheck(aIdx, bIdx - 1, dIdx - 1);
        }

       
    }
}
