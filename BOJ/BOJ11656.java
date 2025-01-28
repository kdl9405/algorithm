package boj;

/*
 * 접미사 배열
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ11656 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int len = S.length();

        String[] sArr = new String[len];

        for (int i = 0; i < len; i++) {
            sArr[i] = S.substring(i);
        }

        Arrays.sort(sArr);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(sArr[i]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }
}
