package programmers;

/**
 * 스킬체크 레벨2 - 1
 */
public class pro93 {

    public static void main(String[] args) {

        int[] numbers = { 1, 1, 1, 1, 1 };
        int target = 3;

        System.out.println(solution(numbers, target));

    }

    static int solution(int[] numbers, int target) {
        int answer = 0;

        count = 0;
        dfs(target, 0, 0, numbers);

        answer = count;
        return answer;
    }

    static int count;

    static void dfs(int target, int depth, int sum, int[] numbers) {
        if (depth == numbers.length) {
            if (sum == target) {
                count++;
            }
            return;
        }

        dfs(target, depth + 1, sum + numbers[depth], numbers);
        dfs(target, depth + 1, sum - numbers[depth], numbers);

    }

}