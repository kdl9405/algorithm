package programmers;

import java.util.LinkedList;
import java.util.Queue;

/* 
    4단 고음
*/

public class pro135 {

    public static void main(String[] args) {
        System.out.println(solution(41));
    }

    public static int solution(int n) {
        int answer = 0;

        answer = findA(n, 0);

        return answer;
    }

    static int findA(int n, int plus) {

        if (n == 3 && plus == 2) {
            return 1;
        }

        if (Math.pow(3, plus / 2) > n) {
            return 0;
        }

        int c = 0;

        if (n % 3 == 0 && plus >= 2) {
            c += findA(n / 3, plus - 2);
        }
        c += findA(n - 1, plus + 1);

        return c;
    }

}
