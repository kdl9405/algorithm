package BOJ;

/**
타일 장식물

*/

import java.util.*;

public class BOJ13301 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        long[] fibonacci = new long[N + 1];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i <= N; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        long answer = (fibonacci[N] + fibonacci[N - 1]) * 2L;

        System.out.println(answer);

    }
}
