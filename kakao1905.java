/**
 * kakao1905
 */
public class kakao1905 {

    public static void main(String[] args) {

        int[] stones = { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 };
        int k = 3;

        // solution(stones, k);
        System.out.println(solution(stones, k));

    }

    public static int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;

   
        for(int i = 0; i<=stones.length-k; i++){
            int temp = i; 
            int stone = stones[i];

            for(int j = i; j<i+k; j++){
                if(stones[j] > stone){
                    stone = stones[j];
                    temp = j;
                    
                }
            }
            if(answer > stone){
                answer = stone;
            }
            i = temp;

        }
        return answer;
    }
}

