package programmers;

/* 
    금과 은 운반하기
*/

public class pro215 {

    public static void main(String[] args) {

        int a = 10;
        int b = 10;
        int[] g = { 100 };
        int[] s = { 100 };
        int[] w = { 7 };
        int[] t = { 10 };

        System.out.println(solution(a, b, g, s, w, t));

    }

    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;

        long min = 0;
        long max = 400000000000000L;

        while (min <= max) {
            long mid = (min + max) / 2;

            if (isPossible(mid, a, b, g, s, w, t)) {

                answer = mid;

                max = mid - 1;
            } else {

                min = mid + 1;
            }
        }

        return answer;
    }

    static boolean isPossible(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {

        long gold = 0;
        long silver = 0;
        long total = 0;

        for (int i = 0; i < t.length; i++) {
            long gg = g[i];
            long ss = s[i];
            long ww = w[i];
            long tt = t[i];

            long count = time / (tt * 2);
            if (time % (tt * 2) >= tt) {
                count++;
            }

            total += Math.min(gg + ss, count * ww);
            gold += Math.min(gg, count * ww);
            silver += Math.min(ss, count * ww);
        }

        if (a + b > total || a > gold || b > silver) {
            return false;
        }


        return true;
    }

}