package programmers;

import java.util.Arrays;

/* 
    입국심사

    1. 누가 어떤 심사관에게 입국심사를 받는지는 중요하지 않음!!
    2. i 시간동안 심사관들이 심사할 수 있는 사람의 총 합이 n 이상이어야 함
    3. => 이때의 최소 i를 찾는 문제!!
*/
public class pro203 {

    public static void main(String[] args) {

    }

    public static long solution(int n, int[] times) {

        Arrays.sort(times);

        long min = 0;
        long max = times[times.length - 1] * (long)n;

        while (min<=max) {
            long mid = (min+max)/2;

            long sum = 0;

            for(int t : times){
                sum += mid/t;
            }

            if (sum < n) {
                min = mid+1;
            }else {
                max = mid;
            }
        }

        return min;
    }
}
