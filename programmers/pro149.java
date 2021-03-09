package programmers;

/*
    자연수 뒤집어 배열로 만들기

*/

public class pro149 {
    class Solution {
        public int[] solution(long n) {

            String number = Long.toString(n);

            int[] answer = new int[number.length()];
            for (int i = 1; i <= number.length(); i++) {
                answer[i - 1] = Integer.valueOf(number.charAt(number.length() - i) - '0');
            }

            return answer;
        }
    }
}
