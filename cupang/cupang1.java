public class cupang1 {
    
    public static void main(String[] args) {

        int[] answer = solution(999999);

        System.out.println(answer[0] +" "+ answer[1]);
        
    }

    static int[] solution(int N){
        int[] answer = new int[2];

        for(int i = 2; i<10; i++){
            int num = N;
            int temp = 1;

            while (true) {

                if(num % i != 0){
                    temp *= (num%i);
                }
                num /= i;

                

                if (num == 0) {
                    if (temp >= answer[1]) {
                        answer[0] = i;
                        answer[1] = temp;
                    }
                    break;
                }
            }

        }

        return answer;
    }

}

