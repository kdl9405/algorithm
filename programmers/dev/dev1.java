package programmers.dev;

public class dev1 {

    public static void main(String[] args) {

    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        boolean[] nums = new boolean[46];

        for (int win : win_nums) {
            nums[win] = true;
        }

        int mathes = 0;
        int zero = 0;

        for (int lot : lottos) {

            if (lot == 0) {
                zero++;
                continue;
            }

            if (nums[lot]) {
                mathes++;
            }
        }

        answer[0] = 7 - (mathes + zero);
        answer[1] = 7 - mathes;

        if (answer[0] < 1) {
            answer[0] = 1;
        }else if(answer[0] >= 6){
            answer[0] = 6;
        }
        
        if (answer[1] >= 6) {
            answer[1] = 6;
        }

        return answer;
    }

}
