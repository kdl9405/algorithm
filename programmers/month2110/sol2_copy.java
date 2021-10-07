package programmers.month2110;

import java.util.*;


/* 
    30점.... => 역시나 메모리 초과 문제..
*/

public class sol2_copy {

    public static void main(String[] args) {

        int n = 3;
        long left = 2;
        long right = 5;

        System.out.println(solution(n, left, right));

    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {

            int c = i + 1;
            arr[i][i] = c;

            for (int j = i + 1; j < n; j++) {
                c++;
                arr[i][j] = c;
                arr[j][i] = c;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<n; i++){
            sb.append(Arrays.toString(arr[i]).replaceAll("[,\\[\\]]", "")).append(" ");
        }

        answer = Arrays.copyOfRange(Arrays.stream(sb.toString().trim().split(" ")).mapToInt(Integer::parseInt).toArray(), (int)left, (int)right);

        return answer;
    }

}
