package programmers;

import java.util.*;

/**
 * 다음 큰 숫자
 */

public class pro53 {

    public static void main(String[] args) {

        System.out.println(solution(15));

    }   

    static int solution(int n) {
        int answer = 0;

        String s = Integer.toBinaryString(n);
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            if (s.charAt(i) == '1') {
                count++;
            }
        }

        loop:
        for(int i = n+1; i<=1000001; i++){
            s = Integer.toBinaryString(i);
            int c = 0;

            for(int j = 0; j<s.length(); j++){
                if (s.charAt(j) == '1') {
                    c++;
                }
            }

            if (c == count) {
                answer = i;
                break loop;
            }
        }

        return answer;
    }
}