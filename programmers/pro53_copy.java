package programmers;

import java.util.*;

/**
 * 다음 큰 숫자
 */

 // 시간초과
public class pro53_copy {

    public static void main(String[] args) {

        System.out.println(solution(15));

    }

    static List<Integer> list;
    static int[] arr;

    static int solution(int n) {
        int answer = 0;

        String s = Integer.toBinaryString(n);
        int len = s.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }

        arr = new int[count];

        list = new LinkedList<>();

        dfs(0,0, count, len+1);

        Collections.sort(list);

        for(int i = 0; i< list.size(); i++){
            if (list.get(i) > n) {
                answer = list.get(i);
                break;
            }
        }

        return answer;
    }

    public static void dfs(int x, int depth, int m, int n) {

        if (depth == m) {
            
            int[] num = new int[n];

            for(int val : arr){
                num[val] = 1;
            }
            
            StringBuilder sb = new StringBuilder();
            for(int val : num){
                sb.append(val);
            }

            list.add(Integer.parseInt(sb.toString(), 2));
                        
            return;
        }

        for(int i = x; i<n; i++){

            arr[depth] = i;
            dfs(i + 1, depth + 1, m, n);
        }

    }

  
}