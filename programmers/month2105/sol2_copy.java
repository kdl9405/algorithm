package programmers.month2105;

public class sol2_copy {

    public static void main(String[] args) {

        System.out.println(Long.valueOf("1001111", 2));
        System.out.println(Long.valueOf("1010111", 2));

        // System.out.println((31 ^ (1<<3)));

        long[] numbers = { 79, 7 };

        long[] answer = solution(numbers);
        System.out.println("ans = "+answer[0] + " ");

        System.out.println(Long.toBinaryString(answer[0]));
    }

    public static long[] solution(long[] numbers) {
        for (int i = 0; i < numbers.length; i++) {

            String num = Long.toBinaryString(numbers[i]);

            boolean check = false;
            for (int j = num.length() - 1; j >= 0; j--) {
                if (num.charAt(j) == '0') {

                    numbers[i] ^= (1 << num.length() - 1 - j);
                    check = true;

                    for (int k = j + 1; k < num.length(); k++) {
                        if (num.charAt(k) == '1') {
                            numbers[i] ^= (1 << num.length() - 1 - k);
                            break;
                        }
                    }

                    break;

                }
            }

            if (!check) {
                numbers[i] ^= (3 << num.length() - 1);
            }
        }

        return numbers;
    }
}