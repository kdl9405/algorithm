package boj;

import java.io.*;

/*
 * 찾기
 * 
 * KMP 알고리즘
 */
public class BOJ1786 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String t = br.readLine();
        String p = br.readLine();


        int[] kmpTable = new int[p.length()];

        int j = 0;
        for (int i = 1; i < p.length(); i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = kmpTable[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                kmpTable[i] = ++j;
            }
        }

        int count = 0;
        StringBuilder sb = new StringBuilder();

        j = 0;
        for (int i = 0; i < t.length(); i++) {
            while (j > 0 && t.charAt(i) != p.charAt(j)) {
                j = kmpTable[j - 1];
            }
            if (t.charAt(i) == p.charAt(j)) {
                if (j == p.length() - 1) {
                    count++;
                    sb.append(i - p.length() + 2).append(" ");
                    j = kmpTable[j];
                } else {
                    j++;
                }
            }
        }

        System.out.println(count);
        System.out.println(sb.toString());


    }
}
