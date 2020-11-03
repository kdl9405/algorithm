package programmers;

import java.util.Arrays;

/**
 * 최고의 집합
 * 
 */
public class pro99 {

    public static void main(String[] args) {

        int[] result = solution(3, 9);

        for (int r : result) {
            System.out.print(r + " ");
        }
    }

    static int[] solution(int n, int s) {

        if(n>s){
            return new int[]{-1};
        }

        int[] answer = new int[n];

        Arrays.fill(answer, s / n);

        int x = s % n;

        if (x > 0) {
            for (int i = 0; i < n; i++) {
                answer[i]++;
                x--;
                if (x == 0) {
                    break;
                }
            }
            Arrays.sort(answer);
        }

        return answer;
    }
}