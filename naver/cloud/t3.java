package naver.cloud;


/* 
    
    트럭문제
        1. 가장 앞서서 가는 트럭과 그 뒤에 있는 트럭들의 연료 소비량이 다름
        2. 모든 트럭의 초기 연료가 주어졌을때, 매 순간 순서를 바꿔서 가장 오래 동안 갈 수 있는 시간? 거리?


    => 
        1. 트럭 배열을 정렬시켜, 단순 최대, 최소값을 구함.
        2. 단순 최대 최소 값으로 이분탐색을 시도 -> 이분탐색시, 해당 값으로 트럭들의 주행이 가능한지 확인
        3. 트럭의 가장 큰값부터 해당 시간을 주행할 때,  맨 앞에 위치할 수 있는 시간을 구함.
        4. 맨 앞에 위치할 수 있는 시간은 이분탐색으로 구함.
        5. 각 트럭의 맨 앞에 위치할 수 있는 시간의 합이 주행 시간보다 크거나 같으면 가능!!  

*/

import java.util.Arrays;

public class t3 {

    public static void main(String[] args) {

        int[] v = {7,7,7,7,7};
        int a = 3;
        int b = 1;

        System.out.println("result "+solution(v, a, b));

    }

    public static int solution(int[] v, int a, int b) {
        int answer = 0;

        Arrays.sort(v);

        int min = 0;
        int max = v[v.length - 1] / b;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (check(mid, v, a, b)) {

                answer = mid;
                min = mid+1;
            }else {
                max = mid-1;
            }
        }

        return answer;
    }

    static boolean check(int t, int[] v, int a, int b) {

        int time = t;

        for (int i = v.length - 1; i >= 0; i--) {

            if (v[i]/b < time) {
                return false;
            }

            if (t <= 0) {
                continue;
            }

            int min = 0;
            int max = v[i] / a;
            int c = 0;

            while (min <= max) {

                int mid = (min + max) / 2;

                int r = v[i] - (a * mid) - ((time - mid) * b);

                if (r >= 0) {
                    c = mid;
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }

            t -= c;
        }

        if (t > 0) {
            return false;
        }

        return true;
    }

}
