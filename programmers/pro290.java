package programmers;

/*
 * 코딩테스트 연습 연습문제 유사 칸토어 비트열
 */
public class pro290 {

    public int solution(int n, long l, long r) {
        return getCount(n, l - 1, r - 1);
    }


    private int getCount(int n, long l, long r) {

        if (n == 0) {
            return 1;
        }

        int count = 0;
        long size = (long) Math.pow(5, n - 1);

        for (int i = 0; i < 5; i++) {

            if (i == 2) {
                continue;
            }

            long start = i * size;
            long end = (i + 1) * size - 1;

            if (start <= r && end >= l) {
                count += getCount(n - 1, Math.max(l, start) - start, Math.min(r, end) - start);
            }
        }

        return count;
    }
}
