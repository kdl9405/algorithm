/**
 * 2 x n 타일링
 * 
 */
public class pro80 {

    public static void main(String[] args) {


        System.out.println(solution(4));

    }

    static int solution(int n) {
        int answer = 1;
        int x = 1;
        
        for(int i = 0; i<n-1; i++){
            int y = (answer+x) % 1000000007;
            x = answer;
            answer = y;
        }


        return answer;
    }

    
}