package programmers;

public class pro242 {

    public int solution(int[] schedules, int[][] timelogs, int startday) {

        boolean[] isFail = new boolean[schedules.length];

        int day = startday;
        for (int j = 0; j < 7; j++) {
            if (day == 6 || day == 7) {
                day++;
                continue;
            }

            for (int i = 0; i < schedules.length; i++) {
                if (isFail[i])
                    continue;

                if (!isAllowed(schedules[i], timelogs[i][j]))
                    isFail[i] = true;
            }

            day = (day % 7) + 1;
        }

        int answer = 0;
        for (boolean result : isFail) {
            if (!result)
                answer++;
        }

        return answer;
    }

    private boolean isAllowed(int schedule, int timelog) {

        int scheduleMinute = (schedule / 100) * 60 + (schedule % 100);
        int timelogMinute = (timelog / 100) * 60 + (timelog % 100);

        return timelogMinute - scheduleMinute <= 10;
    }
}
