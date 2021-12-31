package BOJ;

/*
    합이 0인 네 정수


    해쉬맵 - 해쉬충돌
*/

import java.io.*;
import java.util.*;

public class BOJ7453_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        long[] A = new long[n];
        long[] B = new long[n];
        long[] C = new long[n];
        long[] D = new long[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Long.parseLong(st.nextToken());
            B[i] = Long.parseLong(st.nextToken());
            C[i] = Long.parseLong(st.nextToken());
            D[i] = Long.parseLong(st.nextToken());
        }


        HashMap<Long, Long> front = new HashMap<>();
        HashMap<Long, Long> back = new HashMap<>();

        long x = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x = A[i] + B[j];
                front.put(x, front.getOrDefault(x, 0L) + 1L);

                x = C[i] + D[j];
                back.put(x, back.getOrDefault(x, 0L) + 1L);
            }
        }

        long answer = 0L;

        for (Long a : front.keySet()) {
            if (back.containsKey(0 - a)) {
                answer += (front.get(a) * back.get(0 - a));
            }
        }

        System.out.println(answer);

    }
}
