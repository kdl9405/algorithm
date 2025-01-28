package boj;

import java.io.*;
import java.util.*;

/*
 * 숫자 야구
 */

public class BOJ2503 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        num = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        arr = new int[3];
        visit = new boolean[9];
        set = new HashSet<>();

        nPr(0, 3);

        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            String number = st.nextToken();
            int striker = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            HashSet<String> candidate = new HashSet<>();
            candidate.addAll(set);

            for (String c : candidate) {
                int sCount = 0;
                int bCount = 0;
                for (int i = 0; i < 3; i++) {
                    if (c.charAt(i) == number.charAt(i)) {
                        sCount++;
                    }
                    if (c.contains(Character.toString(number.charAt(i)))) {
                        bCount++;
                    }
                }
                if (sCount != striker) {
                    set.remove(c);
                    continue;
                }

                if (bCount - sCount != ball) {
                    set.remove(c);
                    continue;
                }
            }
        }
        System.out.println(set.size());

    }

    static int[] num;
    static int[] arr;
    static boolean[] visit;
    static HashSet<String> set;

    static void nPr(int depth, int r) {
        if (depth == r) {
            StringBuffer sb = new StringBuffer();
            for (int a : arr) {
                sb.append(a);
            }
            String s = sb.toString().trim();

            if (!set.contains(s)) {
                set.add(s);
            }

            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = num[i];
                nPr(depth + 1, r);
                visit[i] = false;
            }
        }
    }
}
