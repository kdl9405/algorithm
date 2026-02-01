package programmers;

/*
 * 코딩테스트 연습 Summer/Winter Coding(~2018) 쿠키 구입
 */

public class pro286 {

    public int solution(int[] cookie) {

        int answer = 0;
        int n = cookie.length;

        for (int m = 0; m < n - 1; m++) {
            int l = m;
            int r = m + 1;

            int left = cookie[l];
            int right = cookie[r];

            while (true) {
                if (left == right) {
                    answer = Math.max(answer, left);
                }

                if (left <= right && l > 0) {
                    l--;
                    left += cookie[l];
                } else if (left >= right && r < n - 1) {
                    r++;
                    right += cookie[r];
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}
