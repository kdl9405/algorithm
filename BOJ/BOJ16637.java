package BOJ;

/**
    괄호 추가하기
 */

import java.io.*;

public class BOJ16637 {

    public static void main(String[] args) throws IOException {

        new BOJ16637().solution();

    }

    void solution() throws IOException {

        init();

        dfs(1, operation[0] - '0');

        System.out.println(max);

    }

    int N, max;
    char[] operation;

    void init() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        operation = br.readLine().toCharArray();

        max = Integer.MIN_VALUE;
    }

    void dfs(int index, int value) {

        if (index == N) {
            max = Math.max(max, value);
            return;
        }

        // 괄호 사용
        if (index + 3 < N) {
            dfs(index + 4, calculate(value, operation[index],
                    calculate(operation[index + 1] - '0', operation[index + 2], operation[index +
                            3] - '0')));

        }

        // 괄호 미사용
        dfs(index + 2, calculate(value, operation[index], operation[index + 1] - '0'));

    }

    int calculate(int a, char o, int b) {

        if (o == '*') {
            return a * b;
        } else if (o == '+') {
            return a + b;
        } else
            return a - b;
    }
}

// 3+8*7-9*2