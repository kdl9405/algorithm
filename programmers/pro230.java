package programmers;

/* 
    k진수에서 소수 개수 구하기

*/

public class pro230 {

    public static void main(String[] args) {

        new pro230().solution(110011, 10);
    }

    public int solution(int n, int k) {
        int answer = 0;

        String number = Integer.toString(n, k);

        String[] numArr = number.split("0");
        for (String num : numArr) {

            try {
                if (isPrime(Long.parseLong(num))) {
                    answer++;
                }
            } catch (NumberFormatException e) {
                continue;

            }

        }

        return answer;
    }

    boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
