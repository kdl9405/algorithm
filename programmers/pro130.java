package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* 
    매뉴 리뉴얼
*/

public class pro130 {
    public static void main(String[] args) {

        String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
        int[] course = { 2, 3, 4 };

        String[] answer = solution(orders, course);
        for (String a : answer) {
            System.out.println(a);
        }
    }

    public static String[] solution(String[] orders, int[] course) {

        orderCheck = orders.clone();

        HashMap<Character, Integer> menu = new HashMap<>();
        for (String o : orders) {
            for (int i = 0; i < o.length(); i++) {
                menu.put(o.charAt(i), menu.getOrDefault(o.charAt(i), 0) + 1);
            }
        }

        candidator = new boolean[26];
        for (Character m : menu.keySet()) {
            if (menu.get(m) > 1) {
                candidator[m - 'A'] = true;
            }
        }

        List<String> list = new ArrayList<>();
        for (int c : course) {
            maxCount = 0;
            arr = new char[c];
            candiCount = new HashMap<>();            
            dfs(c, 0, 0);

            for(String s : candiCount.keySet()){
                if (candiCount.get(s) == maxCount) {
                    list.add(s);
                }
            }


        }

        String[] answer = list.toArray(new String[list.size()]);
        Arrays.sort(answer);
        return answer;
    }

    static boolean[] candidator;
    static char[] arr;
    static String[] orderCheck;
    static HashMap<String, Integer> candiCount;
    static int maxCount;

    static void dfs(int r, int depth, int x) {
        if (depth == r) {
            // 조합이 2번 이상 주문된적 있는지 확인하고 있으면 list 삽입
            int count = 0;

            loop:
            for (String o : orderCheck) {

                for (Character c : arr) {
                    if (!o.contains(c.toString())) {
                        continue loop;
                    }
                }
                count++;                
            }
            if (count >=2 ) {
                StringBuilder sb = new StringBuilder();
                for(Character c : arr){
                    sb.append(c);
                }
                candiCount.put(sb.toString(), count);
                maxCount = Math.max(count, maxCount);
            }


            return;
        }

        for (int i = x; i < 26; i++) {
            if (candidator[i]) {
                candidator[i] = false;
                arr[depth] = (char) (i + 'A');
                dfs(r, depth + 1, i + 1);
                candidator[i] = true;
            }
        }
    }
}
