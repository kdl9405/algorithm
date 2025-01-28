package boj;

/*
 * 오큰수
 */

import java.io.*;
import java.util.*;

public class BOJ17928 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // int[] num = new int[N];

        // StringTokenizer st = new StringTokenizer(br.readLine());
        // for(int i = 0; i<N; i++){
        // num[i] = Integer.parseInt(st.nextToken());
        // }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty() && num[stack.peek()] < num[i]) {
                num[stack.pop()] = num[i];
            }

            stack.push(i);

        }

        while (!stack.isEmpty()) {
            num[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int a : num) {
            sb.append(a + " ");
        }

        System.out.println(sb.toString().trim());

    }
}
