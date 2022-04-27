package BOJ;

/* 
    신기한 소수
*/

import java.io.*;

public class BOJ2023 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        answer = new StringBuilder();

        backTracking(1, 2);
        backTracking(1, 3);
        backTracking(1, 5);
        backTracking(1, 7);


        System.out.println(answer.toString());
    }

    static int N;
    static StringBuilder answer;

    static void backTracking(int depth, int number) {

        if (!isPrime(number)) {
            return;
        }

        if (depth == N) {
            answer.append(number).append("\n");
            return;
        }

        depth++;
        number *= 10;

        for (int i = 0; i <= 9; i++) {
            backTracking(depth, number + i);
        }
    }

    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
