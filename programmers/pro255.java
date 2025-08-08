package programmers;

import java.util.Arrays;

public class pro255 {

    public int[] solution(int[][] users, int[] emoticons) {

        Arrays.sort(users, (x, y) -> {
            return (x[0] == y[0]) ? x[1] - y[1] : x[0] - y[0];
        });

        for (int[] user : users) {
            System.out.println(user[0] + " " + user[1]);
        }

        Arrays.sort(emoticons);

        int[] discounts = new int[emoticons.length];

        int register = 0;
        int sellAmount = 0;
        for (int[] user : users) {
            int sum = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (discounts[i] == 0) {
                    discounts[i] = user[0];
                }

                sum += (emoticons[i] * discounts[i] / 100) + (emoticons[i] * discounts[i] % 100);
            }

            if (sum >= user[1]) {
                register++;
                sum = 0;
            }

            sellAmount += sum;
        }

        int[] answer = new int[] { register, sellAmount };
        return answer;
    }
}
