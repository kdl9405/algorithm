package boj;

/*
 * 가장 긴 증가하는 부분 수열 5
 * 
 * 1. 배열을 앞과 뒤부분으로 나눔. 2. 앞부분에서 증가하는 부분수열울 구함. (길이와 마지막 숫자) 3. 앞부분 부분수열의 마지막 숫자와 이어지는 부분수열을 뒷부분에서 구함
 * 
 */

import java.io.*;
import java.util.*;

public class BOJ14003 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] index = new int[N];

        List<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        for (int i = 0; i < N; i++) {
            int a = A[i];

            if (a > list.get(list.size() - 1)) {
                list.add(a);
                index[i] = list.size() - 1;
            } else {

                int left = 0;
                int right = list.size() - 1;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (list.get(mid) >= a) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }
                list.set(right, a);
                index[i] = right;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(i + " " + index[i]);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(list.size() - 1 + "\n");

        Stack<Integer> stack = new Stack<>();

        int idx = list.size() - 1;

        for (int i = N - 1; i >= 0; i--) {
            if (index[i] == idx) {
                stack.push(A[i]);
                idx--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb.toString().trim());

    }

    static int[] A;

}
