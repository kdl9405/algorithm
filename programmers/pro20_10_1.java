/**
 * pro20_10_1
 */
public class pro20_10_1 {

    
    public static void main(String[] args) {
        
        System.out.println(solution(45));
    }

    static int solution(int n) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append(n%3);
            n/=3;

            if (n==0) {
                break;
            }            
        }

        answer = Integer.parseInt(sb.toString(),3);

        return answer;
    }
}