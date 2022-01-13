package BOJ;

/* 
    문제집

        1. 현재 풀 수 있는 문제인지 확인이 되야 한다.
        2. 즉, pq에는 풀 수 있는 문제만 들어가야...
        3. 그러면 다음 문제를 알 수있게 연결하고,  각 문제에 대해서는 이전에 풀어야 하는 문제를 알골 있어야?
*/

import java.io.*;
import java.util.*;

public class BOJ1766 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Set<Integer>> before = new ArrayList<>();
        List<Set<Integer>> after = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i <= N; i++) {
            before.add(new HashSet<>());
            after.add(new HashSet<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            before.get(b).add(a);
            after.get(a).add(b);
        }

        for (int i = 1; i <= N; i++) {
            if (before.get(i).isEmpty()) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {

            int question = pq.poll();

            for (int next : after.get(question)) {
                if (before.get(next).size() == 1) {
                    pq.add(next);
                }
                before.get(next).remove(question);

            }

            sb.append(question).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

}
