package programmers;

import java.util.*;

/* 
    N으로 표현
*/

public class pro202 {

    public static void main(String[] args) {

    }

    public static int solution(int N, int number) {
        int answer = -1;

        int[] unit = new int[9];
        for (int i = 1; i <= 8; i++) {
            unit[i] = (unit[i - 1] * 10) + N;
        }

        List<HashSet<Integer>> list = new ArrayList<>();
        list.add(new HashSet<>());

        for (int i = 1; i <= 8; i++) {
            list.add(new HashSet<>());
            list.get(i).add(unit[i]);

            for (int j = 1; j < i; j++) {

                for (int x : list.get(j)) {
                    for (int y : list.get(i - j)) {

                        if(y == 0){
                            continue;
                        }

                        list.get(i).add(x + y);
                        list.get(i).add(x - y);
                        list.get(i).add(x * y);
                        list.get(i).add(x / y);
                    }
                }
            }

            if (list.get(i).contains(number)) {
                answer = i;
                break;
            }

        }
        return answer;
    }
}
