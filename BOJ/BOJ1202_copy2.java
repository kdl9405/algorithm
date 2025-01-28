package boj;

/*
 * 보석 도둑
 * 
 * 1. 보석의 정보를 저장. (우선순위큐에 저장) 2. 값이 비싼 순서로, 무게는 작은 순서로 정렬. 3. 가방을 무게가 작은 순으로 정렬하고, 보석을 가방의 무게가 적은
 * 것부터 할당. (탐색를 이분탐색으로!!)
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ1202_copy2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> jewel = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewel.add(
                    new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        List<Integer> bag = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(bag);
        int count = 0;
        long total = 0L;

        while (!jewel.isEmpty()) {
            int[] j = jewel.poll();

            int min = 0;
            int max = bag.size() - 1;

            int index = 0;

            while (min <= max) {

                int mid = (min + max) / 2;

                if (bag.get(mid) < j[0]) {
                    min = mid + 1;
                } else {
                    index = mid;
                    max = mid - 1;
                }
            }

            if (bag.get(index) >= j[0]) {
                total += j[1];
                bag.remove(index);
                count++;
            }
            if (count == K) {
                break;
            }
        }

        System.out.println(total);
    }
}
