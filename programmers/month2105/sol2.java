package programmers.month2105;

public class sol2 {

    public static void main(String[] args) {

        // System.out.println(Long.valueOf("11111", 2));
        // System.out.println(Long.valueOf("10111", 2));

        // System.out.println((31 ^ (1<<3)));
        
        long[] numbers = {2};

        long[] answer = solution(numbers);
        System.out.println(answer[0]+" " );
    }

    public static long[] solution(long[] numbers) {

        for(int i = 0; i<numbers.length; i++){

            int j = 0;
            boolean check = false;
            while (true) {

                if ((numbers[i]^(1<<j)) > numbers[i]) {
                    numbers[i]^=(1<<j);

                    check = true;
                    while (j-- >0) {
                        if ((numbers[i]^(1<<j)) < numbers[i]) {
                            numbers[i]^=(1<<j);
                            break;
                        }
                    }
                    break;
                }
                j++;                
            }    

            if (!check) {
                j--;
                numbers[i]^=(1<<j);
            }
            

        }

        return numbers;
    }
}
