package programmers;

public class pro262 {


    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        int x = startX;
        int y = startY;

        int index = 0;
        for (int[] ball : balls) {

            int min = Integer.MAX_VALUE;

            if (!(x == ball[0] && y < ball[1])) {
                int dx = x - ball[0];
                int dy = y - (2 * n - ball[1]);

                min = Math.min(min, dx * dx + dy * dy);
                // System.out.println(index+"_"+0 +" = " + (dx*dx + dy*dy));
            }

            if (!(x == ball[0] && y > ball[1])) {
                int dx = x - ball[0];
                int dy = y + ball[1];

                min = Math.min(min, dx * dx + dy * dy);
                // System.out.println(index+"_"+1 +" = " + (dx*dx + dy*dy));
            }

            if (!(y == ball[1] && x < ball[0])) {
                int dx = x - (2 * m - ball[0]);
                int dy = y - ball[1];

                min = Math.min(min, dx * dx + dy * dy);
                // System.out.println(index+"_"+2 +" = " + (dx*dx + dy*dy));
            }

            if (!(y == ball[1] && ball[0] < x)) {
                int dx = x + ball[0];
                int dy = y - ball[1];

                min = Math.min(min, dx * dx + dy * dy);
                // System.out.println(index+"_"+3 +" = " + (dx*dx + dy*dy));
            }

            answer[index] = min;
            index++;
        }

        return answer;
    }

}
