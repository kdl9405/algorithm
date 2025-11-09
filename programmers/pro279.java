package programmers;

/*
 * 코딩테스트 연습 연습문제 혼자 놀기의 달인
 */

import java.util.*;

public class pro279 {

    public static void main(String[] args) {
        int[] cards = {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};

        System.out.println(solution(cards));

    }

    public static int solution(int[] cards) {
        int answer = 0;

        N = cards.length;
        opened = new boolean[N + 1];

        List<Integer> cardGroupSizes = new ArrayList<>();

        for (int i = 0; i < N; i++) {

            int groupSize = getOpenedCards(cards, i);

            if (groupSize != 0) {
                cardGroupSizes.add(groupSize);
            }
        }

        if (cardGroupSizes.size() > 1) {
            Collections.sort(cardGroupSizes, (a, b) -> {
                return b - a;
            });

            answer = cardGroupSizes.get(0) * cardGroupSizes.get(1);
        }

        return answer;
    }

    private static int N;
    private static boolean[] opened;

    private static int getOpenedCards(int[] cards, int index) {

        if (opened[index])
            return 0;

        opened[index] = true;
        int nextCard = cards[index] - 1;

        if (opened[nextCard])
            return 1;

        return 1 + getOpenedCards(cards, nextCard);
    }
}
