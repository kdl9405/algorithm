package programmers;

/**
 * pro91
 */
public class pro91 {

    public static void main(String[] args) {
        int n = 5;
        int[] money = {1,2,5};

        System.out.println(solution(n, money));
        
    }
    static int solution(int n, int[] money) {
        int[] answer = new int[n+1];
        answer[0] = 1;

        for(int m : money){
            for(int i = m; i<=n; i++){
                answer[i] += answer[i-m];
            }
        }

        return answer[n];
    }
}