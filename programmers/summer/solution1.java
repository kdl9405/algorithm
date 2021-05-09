package programmers.summer;

import java.util.*;

public class solution1 {
    public static void main(String[] args) {

    }

    public int[] solution(String code, String day, String[] data) {
        List<int[]> list = new ArrayList<>();

        for (String da : data) {
            String[] detail = da.split(" ");

            String c = detail[1].replaceAll("[^0-9]", "");
            if (!code.equals(c)) {
                continue;
            }

            String d = detail[2].substring(5, 15);

            if (!day.equals(d)) {
                continue;
            }
            


            String value = detail[0].replaceAll("[^0-9]", "");

            list.add(new int[] { Integer.parseInt(d), Integer.parseInt(value) });

        }

        Collections.sort(list, (a,b)->{
            return a[0]-b[0];
        });

        int[] answer = new int[list.size()];

        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i)[1];
        }

        return answer;

    }
}
