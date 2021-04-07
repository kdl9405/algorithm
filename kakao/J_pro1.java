package kakao;

import java.util.*;

public class J_pro1 {

    public static void main(String[] args) {

        int[] gift_cards = {1,1,1,1,1};
        
        int[] wants = {1,1,2,2,2};

        // Arrays.fill(gift_cards, 1);
        // Arrays.fill(wants, 2);

        System.out.println(solution(gift_cards, wants));
        
    }


    public static int solution(int[] gift_cards, int[] wants) {
        int answer = 0;

        Map<Integer, Integer> giftMap = new HashMap<>();
        Map<Integer, Integer> wantMap = new HashMap<>();

        for (int i = 0; i < wants.length; i++) {
            giftMap.put(gift_cards[i], giftMap.getOrDefault(gift_cards[i], 0) + 1);
            wantMap.put(wants[i], wantMap.getOrDefault(wants[i], 0) + 1);
        }

        Set<Integer> giftSet = giftMap.keySet();
        for (Integer i : giftSet) {
            int gift = giftMap.get(i);
            int want = wantMap.getOrDefault(i, 0);

            int sum = gift - want;
            if (sum > 0) {
                answer += sum;
            }
        }
        return answer;
    }
}