package programmers;

/*
 * 코딩테스트 연습 2023 KAKAO BLIND RECRUITMENT 표현 가능한 이진트리
 */

public class pro284 {


    public static void main(String[] args) {

        long[] numbers = {95};

        solution(numbers);
    }

    public static int[] solution(long[] numbers) {


        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binaryString = getBinaryString(numbers[i]);

            answer[i] = checkBinary(binaryString) ? 1 : 0;
        }

        return answer;
    }

    private static String getBinaryString(long number) {

        String binaryString = Long.toBinaryString(number);

        int fullLength = 0;
        int h = 1;
        while (fullLength < binaryString.length()) {
            fullLength = (int) Math.pow(2, h++) - 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fullLength - binaryString.length(); i++) {
            sb.append('0');
        }
        sb.append(binaryString);

        return sb.toString();
    }

    private static boolean checkBinary(String binaryString) {
        int length = binaryString.length();
        if (length <= 1)
            return true;

        int mid = length / 2;
        char root = binaryString.charAt(mid);
        String left = binaryString.substring(0, mid);
        String right = binaryString.substring(mid + 1);

        if (root == '0') {
            if (left.contains("1") || right.contains("1")) {
                return false;
            }
        }

        return checkBinary(left) && checkBinary(right);
    }
}
