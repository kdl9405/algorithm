package BOJ;

/* 
    보석 도둑

    1. 보석의 정보를 저장. 
    2. 값이 무게는 작은 순서로 정렬.
    3. 가방을 무게가 작은순으로 정렬하고, 순회
    4. 해당 무게까지 담을 수 있는 보석을 우선순위 큐에 담음 (우선순위 큐는 가격이 큰 순으로 정렬)
    5. 가능한 보석을 우선순위 큐에 모두 담은 후,  가장 큰 것을 할당.
    
*/

import java.io.*;
import java.util.*;

public class BOJ1202 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewel = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bag = new int[K];

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewel, (a, b) -> {
            return a[0] - b[0];
        });

        Arrays.sort(bag);
        long total = 0;
        int index = 0;

                PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int b : bag) {

            while (index < N) {
                if (jewel[index][0] <= b) {
                    pq.add(jewel[index][1]);
                    index++;
                } else {
                    break;
                }
            }

            if (!pq.isEmpty()) {
                total += pq.poll();
            }
        }

        System.out.println(total);
    }
}
