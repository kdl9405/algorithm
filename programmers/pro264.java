package programmers;

public class pro264 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        for (int i = n - 1; i >= 0; i--) {

            int d = deliveries[i];
            int p = pickups[i];

            int dNeed = d / cap + (d % cap == 0 ? 0 : 1);
            int pNeed = p / cap + (p % cap == 0 ? 0 : 1);

            int count = Math.max(dNeed, pNeed);

            answer += (count * (i + 1) * 2);

            int dRemain = count * cap - d;
            int pRemain = count * cap - p;

            for (int j = i - 1; j >= 0; j--) {
                if (dRemain == 0 && pRemain == 0) {
                    break;
                }
                if (dRemain > 0) {
                    if (deliveries[j] >= dRemain) {
                        deliveries[j] -= dRemain;
                        dRemain = 0;
                    } else {
                        dRemain -= deliveries[j];
                        deliveries[j] = 0;
                    }
                }

                if (pRemain > 0) {
                    if (pickups[j] >= pRemain) {
                        pickups[j] -= pRemain;
                        pRemain = 0;
                    } else {
                        pRemain -= pickups[j];
                        pickups[j] = 0;
                    }
                }
            }
        }
        return answer;
    }
}
