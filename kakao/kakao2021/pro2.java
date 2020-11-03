package kakao.kakao2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class pro2 {

    static char[] arr;
    static boolean[] visit;
    static List<String> result;

    public static void main(String[] args) {

        String[] orders = { "XYZ", "XWY", "WXA" };
        int[] course = { 2, 3, 4 };

        String[] result = solution(orders, course);

        for (String s : result) {
            System.out.println(s);
        }

    }

    static String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        List<String> answer2 = new ArrayList<>();

        Arrays.sort(orders, (s1, s2) -> {
            return s1.length() - s2.length();
        });

        for (int i = 0; i < course.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();

            for (String order : orders) {

                result = new ArrayList<>();
                arr = new char[course[i]];
                visit = new boolean[order.length()];

                dfs(0, 0, course[i], order);

                for (String r : result) {

                    String[] str = r.split("");
                    
                    Arrays.sort(str, (s1,s2)->{
                        return s1.compareTo(s2);
                    });

                    r = "";
                    for(int n = 0; n<str.length; n++){
                        r+=str[n];
                    }

                    map.put(r, map.getOrDefault(r, 0) + 1);
                }

            }

            System.out.println(map);

            
            if (!map.isEmpty()) {
                int max = Collections.max(map.values());

                if (max > 1) {
                    for (String s : map.keySet()) {
                        if (map.get(s).equals(max)) {
                            answer2.add(s);
                        }
                    }
                }
            }

        }

        answer = new String[answer2.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answer2.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void dfs(int x, int depth, int c, String order) {

        if (depth == c) {

            StringBuilder sb = new StringBuilder();
            for (char ch : arr) {
                sb.append(ch);
            }
            result.add(sb.toString());
            return;
        }

        for (int i = x; i < order.length(); i++) {

            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = order.charAt(i);
                dfs(i+1, depth + 1, c, order);
                visit[i] = false;
            }
        }
    }
}