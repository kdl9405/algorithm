
public class pro31 {

    //타겟 넘버


    static int answer = 0;

    public static void main(String[] args) {

        int[] numbers = {1,1,1,1,1};

        System.out.println(solution(numbers, 3));
    }

    static int solution(int[] numbers, int target) {

        dfs(numbers, target, 0);

        return answer;
    }

    static void dfs(int[] numbers, int target, int depth){
     
        if (depth == numbers.length) {
            int sum = 0;
            for(int n : numbers){
                sum += n;
            }
            if (sum == target) {
                answer++;
            }return;
        }

        numbers[depth] *= 1;
        dfs(numbers, target, depth+1);

        numbers[depth] *= -1;
        dfs(numbers, target, depth+1);

        
    }
}
