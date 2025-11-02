package programmers;

/*
 * 코딩테스트 연습 2025 프로그래머스 코드챌린지 1차 예선 비밀 코드 해독
 */


public class pro274 {

    public int solution(int n, int[][] q, int[] ans) {

        N = n;
        choice = new int[5];

        answer = 0;
        questions = q;
        answers = ans;

        find(0, 1);

        return answer;
    }

    private int N, answer;
    private int[] choice;
    private int[][] questions;
    private int[] answers;


    private void find(int index, int now) {

        if (index == 5) {
            if (check())
                answer++;
            return;
        }

        if (now > N) {
            return;
        }

        choice[index] = now;
        find(index + 1, now + 1);
        find(index, now + 1);
    }

    private boolean check() {

        for (int i = 0; i < questions.length; i++) {
            if (countShareNumber(questions[i], choice) != answers[i])
                return false;
        }

        return true;
    }

    private int countShareNumber(int[] a, int[] b) {

        int count = 0;
        for (int aa : a) {
            for (int bb : b) {
                if (aa == bb)
                    count++;
            }
        }

        return count;
    }

}
