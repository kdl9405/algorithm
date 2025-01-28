package boj;

import java.io.*;
import java.util.*;

/*
 * 반복수열
 */
public class BOJ2331 {

    public static void main(String[] args) throws IOException {

        new BOJ2331().solution();
    }

    void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        map.put(A, 0);

        int index = 1;
        while (true) {

            int next = nextNum(A, P);
            if (map.containsKey(next)) {
                System.out.println(map.get(next));
                return;
            }

            A = next;
            map.put(A, index++);
        }
    }

    int nextNum(int A, int P) {

        int next = 0;

        while (A > 0) {

            next += Math.pow(A % 10, P);
            A /= 10;
        }

        return next;
    }
}
