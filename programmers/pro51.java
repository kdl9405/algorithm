package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 튜플

public class pro51 {



    public static void main(String[] args) {

        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        int[] answer = solution(s);

        for (int i : answer) {
            System.out.print(i + ", ");
        }

    }

    static int[] solution(String s) {
        int[] answer = {};

        s = s.substring(2, s.length() - 2);
        s = s.replaceAll("[^0-9]", " ");
        String[] str = s.split("   ");

        Arrays.sort(str, (s1, s2) -> {
            return s1.length() - s2.length();
        });

        Queue<String> queue = new LinkedList<>();

        for(String st : str){
            String[] num = st.split(" ");
            for(int i = 0; i<num.length; i++){
                if (!queue.contains(num[i])) {
                    queue.offer(num[i]);
                }
            }
        }

        answer = new int[queue.size()];
        for(int i = 0; i<answer.length; i++){
            answer[i] = Integer.parseInt(queue.poll());
        }

        return answer;
    }
}