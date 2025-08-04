package programmers;

import java.util.HashMap;
import java.util.Map;

public class pro243 {

    public int solution(String[] friends, String[] gifts) {

        Map<String, Integer> friendIds = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendIds.put(friends[i], i);
        }

        int[][] giftCount = new int[friends.length][friends.length];

        for (String gift : gifts) {
            String[] giftHistory = gift.split(" ");

            int from = friendIds.get(giftHistory[0]);
            int to = friendIds.get(giftHistory[1]);

            giftCount[from][to]++;
        }

        int[] giftPoint = new int[friends.length];
        for (int i = 0; i < friends.length; i++) {

            for (int j = 0; j < friends.length; j++) {
                giftPoint[i] += giftCount[i][j];
                giftPoint[i] -= giftCount[j][i];
            }
        }

        int maxCount = 0;

        for (int i = 0; i < friends.length; i++) {
            int nextCount = 0;
            for (int j = 0; j < friends.length; j++) {
                if (i == j)
                    continue;

                if (giftCount[i][j] > giftCount[j][i])
                    nextCount++;
                else if (giftCount[i][j] == giftCount[j][i] && giftPoint[i] > giftPoint[j])
                    nextCount++;
            }

            if (nextCount > maxCount) {
                maxCount = nextCount;
            }
        }

        return maxCount;
    }
}
