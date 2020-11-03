package programmers;

/**
 * 숫자의 표현
 */
public class pro57 {

    public static void main(String[] args) {

        System.out.println(solution(10000));
    }

    static int solution(int n) {
        int answer = 0;

        int x = 1;

        while (x <= n) {

            int sum  = 0;
            for(int i = x; i<=n; i++){
                sum += i;
                if (sum == n) {
                    answer++;
                }else if (sum>n) {
                    break;
                }
            }
            x++;
        }

        return answer;
    }

}