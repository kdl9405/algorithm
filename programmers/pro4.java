import java.util.*;

//숫자배치
public class pro4 {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static int[] arr;
    static long max = Integer.MIN_VALUE;

    public static void main(String[] args) {

        int[] numbers = { 3, 30, 34, 5, 9, 4, 40, 42 };

        System.out.println(solution(numbers));

    }

    static String solution(int[] numbers) {
        String answer = "";

        visit = new boolean[numbers.length];
        arr = new int[numbers.length];

        long result = dfs(numbers, 0, 0);
        answer = Long.toString(result);

        return answer;
    }

    static long dfs(int[] numbers, int n, int depth) {
        if (depth == numbers.length) {

            for (int val : arr) {
                sb.append(val);
            }
            long x = Long.parseLong(sb.toString());
            max = Math.max(x, max);

            sb = new StringBuilder();

            return max;
        }

        for (int i = 0; i < numbers.length; i++) {

            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = numbers[i];
                dfs(numbers, i, depth + 1);
                visit[i] = false;
            }
        }

        return max;
    }
}