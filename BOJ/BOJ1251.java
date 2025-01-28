package boj;

/*
 * 단어 나누기
 */

import java.io.*;
import java.util.*;

public class BOJ1251 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();

        find(0, 3, new StringBuilder());

        Collections.sort(list);

        System.out.println(list.get(0));
    }

    static String s;
    static List<String> list = new ArrayList<>();

    static void find(int start, int depth, StringBuilder temp) {

        if (depth == 1) {

            temp.append(new StringBuilder(s.substring(start)).reverse());
            list.add(temp.toString());
            return;
        }

        for (int i = start; i < s.length() - depth + 1; i++) {

            find(i + 1, depth - 1, new StringBuilder(temp)
                    .append(new StringBuilder(s.substring(start, i + 1)).reverse()));
        }

    }
}
