package programmers;
/*
 * 코딩테스트 연습 PCCP 기출문제 [PCCP 기출문제] 3번 / 아날로그 시계
 */

public class pro280 {

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        long start = h1 * 3600L + m1 * 60L + s1;
        long end = h2 * 3600L + m2 * 60L + s2;

        long ans = count(end) + (isAlarm(end) ? 1 : 0) - count(start);
        return (int) ans;
    }

    // [0, t) 구간에서 알람 횟수
    private long count(long t) {
        if (t <= 0)
            return 0;

        long sm = (t * 59 - 1) / 3600 + 1; // 초-분 겹침
        long sh = (t * 719 - 1) / 43200 + 1; // 초-시 겹침

        long res = sm + sh - 1; // 0초 트리플 보정

        if (t > 43200)
            res--; // 12:00:00 트리플 보정

        return res;
    }

    private boolean isAlarm(long t) {
        return (t * 59) % 3600 == 0 || (t * 719) % 43200 == 0;
    }
}
