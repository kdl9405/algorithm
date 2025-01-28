package boj;


/*
 * 에디터
 * 
 * LinkedList의 add와 remove에서 해당 index를 찾는 것이. 시간초과를 유발..
 */

import java.io.*;
import java.util.*;

public class BOJ1406_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int cursor = s.length();

        LinkedList<Character> sList = new LinkedList<>();
        for (int i = 0; i < cursor; i++) {
            sList.add(s.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {

            String input = br.readLine();

            if (input.equals("L")) {

                cursor = Math.max(cursor - 1, 0);

            } else if (input.equals("D")) {

                cursor = Math.min(cursor + 1, sList.size());

            } else if (input.equals("B")) {

                if (cursor != 0) {
                    cursor--;
                    sList.remove(cursor);
                }

            } else {

                sList.add(cursor, input.charAt(2));
                cursor++;

            }
        }


        StringBuilder sb = new StringBuilder();
        for (char c : sList) {
            sb.append(c);
        }

        System.out.println(sb.toString());

    }
}
