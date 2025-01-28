package boj;

import java.io.*;
import java.util.*;

/*
 * ZOAC
 */
public class BOJ16719 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        // int[][] arr = new int[str.length()][2];

        // for (int i = 0; i < str.length(); i++) {
        // arr[i][0] = str.charAt(i);
        // arr[i][1] = i;
        // }

        // Arrays.sort(arr, (a1, a2) -> {
        // if (a1[0] == a2[0]) {
        // return a1[1] - a2[1];
        // }
        // return a1[0] - a2[0];
        // });

        boolean[] visit = new boolean[str.length()];
        char[] result = new char[str.length()];
        // result[arr[0][1]] = (char)arr[0][0];
        // visit[arr[0][1]] = true;

        StringBuilder sb = new StringBuilder();

        String temp = "";

        int x = 0;
        while (x++ < str.length()) {

            int index = 0;
            int dis = Integer.MAX_VALUE;
            String s = temp;

            for (int i = 0; i < str.length(); i++) {
                if (!visit[i]) {
                    result[i] = str.charAt(i);
                    String t = new String(result).replaceAll(" ", "");
                    if (t.compareTo(s) < dis) {
                        s = t;
                        index = i;
                        dis = t.compareTo(s);
                    }
                    result[i] = (char) ' ';
                }
            }


            result[index] = str.charAt(index);
            visit[index] = true;
            temp = s.trim();
            sb.append(temp + " " + temp.length()).append("\n");
        }



        System.out.println(sb.toString().trim());

    }
}
