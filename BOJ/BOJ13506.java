package BOJ;

/* 
    카멜레온 부분 문자열

    포기
*/

import java.io.*;
import java.util.*;

public class BOJ13506 {

    public static void main(String[] args) throws IOException {

        new BOJ13506().solution();

    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] kmp = new int[S.length()];

        int j = 0;
        for (int i = 1; i < S.length(); i++) {

            // System.out.println(i + " " + j);

            while (j > 0 && S.charAt(i) != S.charAt(j)) {
                j = kmp[j - 1];
            }

            if (S.charAt(i) == S.charAt(j)) {
                kmp[i] = ++j;
            }

            // for (int x = 0; x < S.length(); x++) {
            //     System.out.print(kmp[x] + " ");
            // }
            // System.out.println();

        }

        int x = S.length() - 1;
        boolean check = false;
        while (x > 0) {
            for (int i = 1; i < S.length() - 1; i++) {
                if (kmp[i] == x) {
                    for (j = 0; j < x; j++) {
                        System.out.print(S.charAt(j));
                    }
                    check = true;
                    break;
                }
            }

            if (check) {
                break;
            }
            x = kmp[x-1];
        }

        if(!check){
            System.out.println("-1");
        }

    }
}
