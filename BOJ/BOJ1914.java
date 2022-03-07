package BOJ;

/* 
    하노이 탑
*/

import java.io.*;
import java.math.BigInteger;

public class BOJ1914 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ1914().solution();
    }

    void solution() throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N <= 20) {
            answer = new StringBuilder();
            answer.append((int)Math.pow(2, N) - 1).append("\n");
            hanoi(N, 1, 3, 2);
            System.out.println(answer.toString().trim());

        } else {

            BigInteger count = new BigInteger("1");
            BigInteger two = new BigInteger("2");
            for (int i = 1; i <= N; i++) {
                count = count.multiply(two);
            }
            count = count.subtract(new BigInteger("1"));
            System.out.println(count);
        }

    }

    StringBuilder answer;

    void hanoi(int n, int from, int to, int mid) {

        if (n == 1) {
            answer.append(from).append(" ").append(to).append("\n");
        } else {
            hanoi(n-1, from, mid, to);
            answer.append(from).append(" ").append(to).append("\n");
            hanoi(n-1, mid, to, from);
        }
    }
}
