package naver.cloud;

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
