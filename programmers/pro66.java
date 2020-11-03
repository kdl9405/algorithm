import java.util.Arrays;
import java.util.HashSet;

/**
 * 소수만들기
 */
public class pro66 {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 7, 6, 4 };

        System.out.println(solution(nums));

    }

    static int solution(int[] nums) {
        int answer = -1;

        count = 0;
        arr = new boolean[3000];
        Arrays.fill(arr, true);
        num = new int[3];

        for (int i = 2; i * i < 3000; i++) {
            for (int j = i * i; j < 3000; j += i) {
                arr[j] = false;
            }
        }

        dfs(0, 0, nums);

        answer = count;

        return answer;
    }

    static boolean[] arr;
    static int count;
    static int[] num;

    static void dfs(int depth, int x, int[] nums) {
        if (depth == 3) {

            int sum = 0;

            for(int n : num){
                sum += n;
            }

            if (arr[sum]) {
                count++;
            }
            return;
        }

        for (int i = x; i < nums.length; i++) {
            num[depth] =  nums[i];
            dfs(depth + 1, i + 1, nums);
        }
    }
}