package programmers;


/*
 * 코딩테스트 연습 연습문제 연속된 부분 수열의 합 https://school.programmers.co.kr/learn/courses/30/lessons/178870
 */
public class pro266 {

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[] {0, sequence.length};

        int left = 0;
        int right = 0;
        int sum = 0;

        for (; right < sequence.length; right++) {

            sum += sequence[right];

            while (sum > k && left < right) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                if (right - left < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right;
                }
            }
        }


        return answer;
    }
}
