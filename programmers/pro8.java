
/**
 * 주식가격
 */
public class pro8 {

    public static void main(String[] args) {

        int[] prices = {1,2,3,2,3};

        solution(prices);
        
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i<prices.length-1; i++){

            int count = 0;

            for(int j = i+1 ; j< prices.length; j++){

                count ++;
                
                if (prices[i] > prices[j]) {
                    break;
                }

            }

            answer[i] = count;
            System.out.println(answer[i]);
        }

        answer[prices.length-1] = 0;
     

        return answer;
    }
}
    
