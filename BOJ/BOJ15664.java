package boj;

/*
 * 
 * N과 M (10)
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ15664 {

    public static void main(String[] args) throws IOException {

        new BOJ15664().solution();
    }

    void solution() throws IOException {

        init();

        findSequence(0, 1);

        System.out.println(answer.toString().trim());
    }

    int N, M;
    int[] numbers;
    int[] arr;
    Set<String> sequenceSet;
    StringBuilder answer;

    void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        arr = new int[M + 1];
        answer = new StringBuilder();
        sequenceSet = new HashSet<>();
    }

    void findSequence(int index, int depth) {

        if (depth > M) {

            StringBuilder sequence = new StringBuilder();
            for (int i = 1; i <= M; i++) {
                sequence.append(arr[i]).append(" ");
            }

            if (!sequenceSet.contains(sequence.toString())) {
                sequenceSet.add(sequence.toString());
                answer.append(sequence).append("\n");
            }
            return;
        }

        if (index == N) {
            return;
        }

        if (numbers[index] >= arr[depth - 1]) {
            arr[depth] = numbers[index];
            findSequence(index + 1, depth + 1);
        }

        findSequence(index + 1, depth);

    }
}
