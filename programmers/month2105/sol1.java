package programmers.month2105;

public class sol1 {
    
    public static void main(String[] args) {
        
    System.out.println(solution(13, 17));

    }

    public static int solution(int left, int right) {
        int answer = 0;

        for(int i = left; i<=right; i++){
            if ((Math.sqrt(i) % 1) == 0.0) {
                answer-=i;
            }else{
                answer+=i;
            }
        }

        return answer;
    }
}