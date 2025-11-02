package programmers;

/*
 * 코딩테스트 연습 PCCP 기출문제 [PCCP 기출문제] 2번 / 퍼즐 게임 챌린지
 * 
 */
public class pro275 {

    public int solution(int[] diffs, int[] times, long limit) {

        int min = 1;
        int max = 1;

        for (int diff : diffs) {
            max = Math.max(max, diff);
        }

        while (min < max) {
            int mid = (min + max) / 2;

            long cost = getCost(mid, diffs, times);

            if (cost <= limit) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }


    private long getCost(int level, int[] diffs, int[] times) {

        long cost = 0L;
        cost += times[0];

        for (int i = 1; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                cost += times[i];
            } else {
                cost += ((diffs[i] - level) * (times[i] + times[i - 1]) + times[i]);
            }
        }

        return cost;

    }
}
