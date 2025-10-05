package programmers;

/*
 * 코딩테스트 연습 연습문제 숫자 카드 나누기
 * 
 * https://school.programmers.co.kr/learn/courses/30/lessons/135807
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class pro269 {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        List<Integer> candidateA = getDivisors(arrayA[0]);
        List<Integer> candidateB = getDivisors(arrayB[0]);

        for (Integer a : candidateA) {
            if (check(a, arrayA, arrayB)) {
                answer = Math.max(answer, a);
            }
        }

        for (Integer a : candidateB) {
            if (check(a, arrayB, arrayA)) {
                answer = Math.max(answer, a);
            }
        }

        return answer;
    }

    private boolean check(int a, int[] A, int[] B) {

        for (int i = 0; i < A.length; i++) {
            if (A[i] % a != 0)
                return false;
        }

        for (int i = B.length - 1; i >= 0; i--) {
            if (B[i] % a == 0)
                return false;
        }

        return true;
    }

    public static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i) {
                    divisors.add(n / i);
                }
            }
        }

        Collections.sort(divisors);
        return divisors;
    }
}
