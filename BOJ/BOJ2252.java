package BOJ;
/* 
    줄 세우기 

    1. 자신 앞에 있는 수의 그룹 조사.
    3. 이미 줄이 서있는지 확인하는 check 배열.
*/

import java.io.*;
import java.util.*;

public class BOJ2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        front = new HashMap<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!front.containsKey(b)) {
                front.put(b, new HashSet<>());
            }
            front.get(b).add(a);

        }

        sb = new StringBuilder();
        visit = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {

            lineUp(i);
        }

        System.out.println(sb.toString().trim());
    }

    static int N, M;
    static HashMap<Integer, HashSet<Integer>> front;
    static StringBuilder sb;
    static boolean[] visit;

    static void lineUp(int n) {

        if (visit[n]) {
            return;
        }

        visit[n] = true;

        if (front.containsKey(n)) {

            for (int a : front.get(n)) {

                lineUp(a);

            }
        }

        sb.append(n + " ");

        return;

    }

}
