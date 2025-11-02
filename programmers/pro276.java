package programmers;


/*
 * 코딩테스트 연습 연습문제 과제 진행하기
 * 
 * 
 * 
 * 작업을 순회..
 * 
 * 만약 stack이 비었다면? 지금 순회한 작업을 stack 에 넣기
 * 
 * 만약 stack이 존재한다면? 지금 순회한 작업의 시작시간보다 큰 작업이 나올때까지 stack을 꺼내면서 완료리스트에 넣기
 */

import java.util.*;

public class pro276 {

    public static void main(String[] args) {

        String[][] plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};

        String[] answer = solution(plans);

        System.out.println("RESULT");
        for (String a : answer) {
            System.out.print(a + " ");
        }
    }


    public static String[] solution(String[][] plans) {

        List<String> answer = new ArrayList<>();

        int[][] sequence = new int[plans.length][2];

        for (int i = 0; i < plans.length; i++) {

            String[] timeArr = plans[i][1].split(":");

            sequence[i] =
                    new int[] {i, Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1])};
        }

        Arrays.sort(sequence, (a, b) -> {
            return a[1] - b[1];
        });

        Stack<int[]> task = new Stack<>();

        int before = sequence[0][1];
        for (int[] s : sequence) {

            while (!task.isEmpty()) {
                if (before == s[1]) {
                    break;
                }

                int[] t = task.pop();
                if (before + t[1] > s[1]) {
                    task.push(new int[] {t[0], before + t[1] - s[1]});
                    break;
                }

                answer.add(plans[t[0]][0]);
                before += t[1];
            }

            task.push(new int[] {s[0], Integer.parseInt(plans[s[0]][2])});
            before = s[1];
        }

        while (!task.isEmpty()) {
            int[] nextTask = task.pop();
            answer.add(plans[nextTask[0]][0]);

        }

        return answer.toArray(new String[0]);
    }
}
