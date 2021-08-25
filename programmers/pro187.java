package programmers;

/*  
부족한 금액 계산하기
*/

public class pro187 {

    public static void main(String[] args) {
        
    }
    
    public static long solution(int price, int money, int count) {

        long answer = ((count+1)*count)/2;
        answer *= price;

        if (answer <= money) {
            answer = 0;
        }else{
            answer-=money;
        }




        return answer;
    }
}
