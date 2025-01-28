package boj;

/*
 * 한 줄로 서기
 */

import java.io.*;
import java.util.*;

public class BOJ1138 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] before = new int[N];
        List<Integer> line = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            line.add(i + 1);
            before[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 0; i--) {
            int n = before[i];
            if (n == 0) {
                continue;
            }

            ListIterator<Integer> iter = line.listIterator(line.indexOf(i + 1));

            iter.next();
            iter.remove();
            while (n-- > 0) {
                while (iter.next() < i + 1) {
                }
            }

            iter.add(i + 1);
        }

        StringBuilder answer = new StringBuilder();
        for (int num : line) {
            answer.append(num).append(" ");
        }
        System.out.println(answer.toString().trim());

    }
}
