
import java.util.Arrays;

// 체육복
public class pro21 {

    public static void main(String[] args) {

        int[] lost = { 1, 2 };
        int[] reserve = { 2, 3 };

        System.out.println(solution(5, lost, reserve));
    }

    static int solution(int n, int[] lost, int[] reserve) {

        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        boolean[] empty = new boolean[reserve.length];

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (!empty[j] && lost[i] == reserve[j]) {
                    empty[j] = true;
                    lost[i] = 0;
                    break;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {

            if (lost[i] != 0) {
                for (int j = 0; j < reserve.length; j++) {

                    if (!empty[j]) {

                        if (lost[i] >= (reserve[j] - 1) && lost[i] <= (reserve[j] + 1)) {
                            empty[j] = true;
                            break;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < empty.length; i++) {
            if (empty[i]) {
                answer++;
            }
        }

        return answer;
    }
}