package boj;

/*
 * 문제집
 * 
 * 1. 현재 풀 수 있는 문제인지 확인이 되야 한다. 2. 즉, pq에는 풀 수 있는 문제만 들어가야... 3. 그러면 다음 문제를 알 수있게 연결하고, 각 문제에 대해서는
 * 이전에 풀어야 하는 문제를 알골 있어야?
 */

import java.io.*;
import java.util.*;

public class BOJ1766_copy {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Question[] qArr = new Question[N + 1];
        int[] beforeCnt = new int[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            qArr[a] = new Question(b, qArr[a]);
            beforeCnt[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (beforeCnt[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {

            int num = pq.poll();

            sb.append(num).append(" ");

            for (Question question = qArr[num]; question != null; question = question.before) {
                beforeCnt[question.num]--;
                if (beforeCnt[question.num] == 0) {
                    pq.add(question.num);
                }
            }

        }

        System.out.println(sb.toString().trim());
    }

    private static class Question {

        int num;
        Question before;

        Question(int num, Question before) {
            this.num = num;
            this.before = before;
        }
    }
}
