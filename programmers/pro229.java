package programmers;

/* 
    신고 결과 받기

*/

import java.io.*;
import java.util.*;

public class pro229 {
    public static void main(String[] args) {

        new pro229().test();
    }

    private void test() {
        String[] id_list = {"con", "ryan"};
        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        int k = 3;

        int[] answer = solution(id_list, report, k);
        for(int i : answer){
        System.out.println(i);
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {

        setUserId(id_list);

        parseReport(report);

        int[] answer = check(k);

        return answer;
    }

    Map<String, Integer> userId;
    Map<String, Set<String>> reporter;

    void setUserId(String[] id_list) {

        userId = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            userId.put(id_list[i], i);
        }
    }

    void parseReport(String[] report) {

        reporter = new HashMap<>();

        for (int i = 0; i < report.length; i++) {
            String[] r = report[i].split(" ");

            reporter.putIfAbsent(r[1], new HashSet<>());
            reporter.get(r[1]).add(r[0]);
        }
    }

    int[] check(int k) {

        int[] answer = new int[userId.size()];

        for (String banId : reporter.keySet()) {
            if (reporter.get(banId).size() >= k) {
                for (String user : reporter.get(banId)) {
                    answer[userId.get(user)]++;
                }
            }
        }

        return answer;
    }
}
