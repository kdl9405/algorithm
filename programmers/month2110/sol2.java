package programmers.month2110;

/* 
*/

public class sol2 {

    public static void main(String[] args) {

        int n = 3;
        long left = 2;
        long right = 5;

        System.out.println(solution(n, left, right));

    }

    public static int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left) + 1];

        for (int i = 0; i < answer.length; i++) {

            int row = (int) (left / n);
            int col = (int) (left % n);

            int num = row + 1;

            if (col < num) {
                answer[i] = num;
            } else {
                answer[i] = (col - num) + (num + 1);
            }

            left++;
        }

        return answer;
    }

}
