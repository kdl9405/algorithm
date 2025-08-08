package programmers;

import java.util.*;

public class pro256 {

    public int[] solution(int[][] users, int[] emoticons) {

        discountSet = new HashSet<>();

        findAllDiscount(0, emoticons.length, new StringBuilder());

        int[] answer = new int[2];
        for (String discount : discountSet) {
            int[] result = getResult(users, emoticons, discount);

            if (result[0] > answer[0]) {
                answer[0] = result[0];
                answer[1] = result[1];
            } else if (result[0] == answer[0] && answer[1] < result[1]) {
                answer[1] = result[1];
            }
        }

        return answer;
    }

    private int[] discountRates = { 10, 20, 30, 40 };
    private HashSet<String> discountSet;

    private void findAllDiscount(int index, int length, StringBuilder sb) {
        if (index == length) {
            discountSet.add(sb.toString().trim());
            return;
        }

        for (int discountRate : discountRates) {
            findAllDiscount(index + 1, length, new StringBuilder(sb).append(" ").append(discountRate));
        }
    }

    private int[] getResult(int[][] users, int[] emoticons, String discount) {

        int[] discounts = Arrays.stream(discount.split(" ")).mapToInt(Integer::parseInt).toArray();

        int register = 0;
        int sellAmount = 0;

        for (int[] user : users) {

            int sum = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] >= user[0]) {
                    sum += (emoticons[i] * (100 - discounts[i]) / 100);
                }
            }

            if (sum >= user[1]) {
                register++;
            } else {
                sellAmount += sum;
            }
        }

        return new int[] { register, sellAmount };

    }
}
