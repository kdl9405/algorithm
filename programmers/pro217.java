package programmers;

/* 
    최소직사각형
*/

public class pro217 {

    public static void main(String[] args) {

    }

    public int solution(int[][] sizes) {
        int answer = 0;

        int r = 0;
        int c = 0;

        for (int[] size : sizes) {
            int a = Math.min(size[0], size[1]);
            int b = Math.max(size[0], size[1]);

            r = Math.max(r, a);
            c = Math.max(c, b);
        }

        answer = r * c;

        return answer;
    }
}
