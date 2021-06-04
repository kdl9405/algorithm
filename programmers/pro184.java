package programmers;

/* 
    약수의 개수와 덧셈
*/
public class pro184 {

    public static void main(String[] args) {

    }

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i <= right; i++) {
            if (isSquare(i)) {
                answer -= i;
            } else {
                answer += i;
            }
        }

        return answer;
    }

    static boolean isSquare(int x) {

        int s = (int) Math.sqrt(x);
        if (s * s == x) {
            return true;
        }
        return false;
    }
}
