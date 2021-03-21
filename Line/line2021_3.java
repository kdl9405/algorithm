package Line;

import java.util.*;

public class line2021_3 {
    
    public static void main(String[] args) {
        int[] enter = {1,3,2};
        int[] leave = {1,2,3};

        int[] result = solution(enter, leave);
        for(int r : result){
            System.out.print(r+" ");
        }
    }

    static int[] solution(int[] enter, int[] leave) {

        int[] answer = new int[enter.length];
        HashSet<Integer> room = new HashSet<>();

        int j = 0;
        for(int i = 0; i<leave.length; i++){
            while (!room.contains(leave[i])) {
                room.add(enter[j]);
                j++;
            }

            room.remove(leave[i]);
            answer[leave[i]-1] += room.size();
            for(Integer x : room){
                answer[x-1]++;
            }

        }
        return answer;
    }
}

