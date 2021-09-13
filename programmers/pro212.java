package programmers;

import java.util.*;

/**
 * 입실 퇴실
 */
public class pro212 {

    public static void main(String[] args) {

        int[] enter = {1,4,2,3};
        int[] leave = {2,1,3,4};

        int[] answer = solution(enter, leave);

        for(int a: answer){
            System.out.println(a);
        }



    }

    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];

        HashSet<Integer> room = new HashSet<>();

        int j = 0;
        for (int i = 0; i < leave.length; i++) {

            if (!room.contains(leave[i])) {
                for (; j < enter.length; j++) {

                    room.add(enter[j]);

                    if (enter[j] == leave[i]) {
                        j++;
                        break;
                    }
                }
            }

            room.remove(leave[i]);

            answer[leave[i]-1] += room.size();


            for(int x : room){
                answer[x-1]++;
            }

        }
        return answer;
    }

}