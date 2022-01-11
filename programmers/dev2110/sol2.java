package programmers.dev2110;

public class sol2 {

    public static void main(String[] args) {

        int leave = 3;
        String day = "SUN";
        int[] holidays = { 2, 6, 17, 29 };

        System.out.println(solution(leave, day, holidays));

    }

    public static int solution(int leave, String day, int[] holidays) {
        int answer = 0;

        month = new int[31];
        for (int h : holidays) {
            month[h] = 1;
        }

        int sun = 1;
        int sat = 7;

        switch (day) {
            case "MON":

                sun = 7;
                sat = 6;

                break;

            case "TUE":

                sun = 6;
                sat = 5;

                break;
            case "WED":

                sun = 5;
                sat = 4;

                break;

            case "THU":

                sun = 4;
                sat = 3;

                break;
            case "FRI":

                sun = 3;
                sat = 2;

                break;

            case "SAT":

                sun = 2;
                sat = 1;

                break;
        }

        for (int i = 0; i < 6; i++) {
            if (sun < 31) {
                month[sun] = 1;
            }

            if (sat < 31) {
                month[sat] = 1;
            }

            sun += 7;
            sat += 7;
        }

        int e = 1;
        int h = leave;

        for (int i = 1; i < 31; i++) {

            e = i;
            h = leave;

            while (true) {

                if (e > 30) {
                    e = 30;
                    break;
                }

                if (month[e] == 0) {
                    h--;
                }

                if (h < 0) {
                    e--;
                    break;
                }

                e++;
            }

            answer = Math.max(answer, e - i + 1);
        }

        return answer;
    }

    static int[] month;

}
