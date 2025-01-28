package boj;

/*
 * 보석 도둑
 * 
 * 1. 보석의 정보를 저장. 2. 값이 비싼 순서로, 무게는 작은 순서로 정렬. 3. 가방을 무게가 작은 순으로 정렬하고, 보석을 가방의 무게가 적은 것부터 할당.
 * 
 * => 시간초과
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ1202_copy {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewel = new int[N][2];

        for (int i = 0; i < N; i++) {
            jewel[i] =
                    Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        List<Integer> bag = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }

        Arrays.sort(jewel, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        Collections.sort(bag);
        int count = 0;
        long total = 0;

        for (int[] j : jewel) {
            for (int i = 0; i < bag.size(); i++) {
                if (bag.get(i) >= j[0]) {
                    count++;
                    total += j[1];

                    bag.remove(i);
                    break;
                }
            }

            if (count == K) {
                break;
            }
        }

        System.out.println(total);
    }
}
