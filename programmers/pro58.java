package programmers;

import java.util.Arrays;

/**
 * 최댓값과 최솟값
 */
public class pro58 {

    public static void main(String[] args) {
        
        String s = "-1 -2 -3 -4" ;

        System.out.println(solution(s));

    }

    static String solution(String s) {
        String answer = "";

        String str[] = s.split(" ");

        Arrays.sort(str, (s1,s2) ->{
            return Integer.parseInt(s1) - Integer.parseInt(s2);
        });

        StringBuilder sb = new StringBuilder();

        sb.append(str[0]+" "+str[str.length-1]);

        answer = sb.toString();

        return answer;
    }
}
