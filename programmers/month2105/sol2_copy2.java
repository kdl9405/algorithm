package programmers.month2105;

/* 
    통과
    */

public class sol2_copy2 {

    public static void main(String[] args) {

        System.out.println(Long.valueOf("1001111", 2));
        System.out.println(Long.valueOf("1010111", 2));

        // System.out.println((31 ^ (1<<3)));

        long[] numbers = { 7, 7 };

        long[] answer = solution(numbers);
        System.out.println("ans = " + answer[0] + " ");

        System.out.println(Long.toBinaryString(answer[0]));
    }

    public static long[] solution(long[] numbers) {
        for (int i = 0; i < numbers.length; i++) {

            char[] num = Long.toBinaryString(numbers[i]).toCharArray();

            boolean check = false;
            for (int j = num.length - 1; j >= 0; j--) {
                if (num[j] == '0') {
                    num[j] = '1';

                    check = true;
                    for (int k = j + 1; k < num.length; k++) {
                        if (num[k] == '1') {
                            num[k] = '0';
                            break;
                        }
                    }

                    break;
                }
            }

            if (!check) {
                numbers[i] ^= (3 << num.length - 1);
            }else{
                numbers[i] = Long.valueOf(new String(num), 2);
            }
        }

        return numbers;
    }
}