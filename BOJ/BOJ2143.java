package BOJ;

/* 
    두 배열의 합
*/

import java.io.*;
import java.util.*;

public class BOJ2143 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ2143().solution();

    }

    void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] A = inputAndSum(N, st);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] B = inputAndSum(M, st);

        Map<Integer, Long> mapA = findAllSum(A);
        Map<Integer, Long> mapB = findAllSum(B);

        long answer = 0;

        for (int a : mapA.keySet()) {
            if (mapB.containsKey(T - a)) {
                answer += (mapA.get(a)*(mapB.get(T-a)));
            }
        }

        System.out.println(answer);

    }

    int[] inputAndSum(int N, StringTokenizer st) {

        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
        }

        return A;
    }

    Map<Integer, Long> findAllSum(int[] A) {
        Map<Integer, Long> mapA = new HashMap<>();
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = A[j] - A[i];
                mapA.put(sum, mapA.getOrDefault(sum, 0L) + 1);
            }
        }

        return mapA;
    }

}
