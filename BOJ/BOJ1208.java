package BOJ;

/* 
    부분수열의 합 2

    1. 배열을 2개로 나눔
    2. 오른쪽 배열의 수열을 구하고, 그 합의 개수를 체크
    3. 왼쪽 배열의 수열을 구하면서, S-합 == 오늘쪽 합의 개수를 더함
*/

import java.io.*;
import java.util.*;

public class BOJ1208 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        map = new HashMap<>();
        answer = 0;

        checkRight(N / 2, 0);
        checkLeft(0, 0);

        if (S == 0) {
            answer--;
        }

        System.out.println(answer);

    }

    static int N, S;
    static int[] arr;
    static HashMap<Integer, Integer> map;
    static long answer;

    static void checkRight(int index, int sum) {

        if (index == N) {
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            return;
        }

        checkRight(index + 1, sum);
        checkRight(index + 1, sum + arr[index]);
    }

    static void checkLeft(int index, int sum) {
        if (index == N / 2) {
            if (map.containsKey(S - sum)) {
                answer += map.get(S - sum);
            }
            return;
        }

        checkLeft(index + 1, sum);
        checkLeft(index + 1, sum + arr[index]);
    }
}
