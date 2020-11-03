
import java.util.Arrays;

//가장 큰수

public class pro16_copy {

    static String str = "";
    static boolean[] visit;
    static int[] arr;
    static Long max = Long.MIN_VALUE;

    public static void main(String[] args) {

        int[] numbers = {3, 30, 34, 5, 9, 4, 40, 42 };

         System.out.println(solution(numbers));

    }

    static String solution(int[] numbers) {
        String answer = "";

        visit = new boolean[numbers.length];
        arr = new int[numbers.length];
                
        answer = Long.toString(dfs(numbers, 0, 0));

        return answer;
    }

    static long dfs(int[] numbers, int n, int depth){

        if (depth == numbers.length) {
            for(int val : arr){
                str = str + val;                
            }
            max = Math.max(max, Long.parseLong(str));
            str = "";
            return max;
        }

        for(int i = 0; i<numbers.length; i++){
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = numbers[i];
                dfs(numbers, i, depth+1);
                visit[i] = false;
            }
        }

        return max;
    }

    
}
