package boj;

/*
 * 집합
 */

import java.io.*;
import java.util.*;

public class BOJ11723_refactoring2 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        BitSet S = new BitSet(21);

        StringBuilder answer = new StringBuilder();
        while (M-- > 0) {
            String oper = br.readLine();

            if (oper.startsWith("add")) {
                S.set(Integer.parseInt(oper.substring(4)));
            } else if (oper.startsWith("remove")) {
                S.clear(Integer.parseInt(oper.substring(7)));
            } else if (oper.startsWith("check")) {
                answer.append((S.get(Integer.parseInt(oper.substring(6)))) ? "1\n" : "0\n");
            } else if (oper.startsWith("toggle")) {
                int x = Integer.parseInt(oper.substring(7));

                if (S.get(x)) {
                    S.clear(x);
                } else {
                    S.set(x);
                }
            } else if (oper.startsWith("all")) {
                S.set(1, 21, true);
            } else {
                S = new BitSet(21);
            }
        }

        System.out.println(answer.toString().trim());
    }

}
