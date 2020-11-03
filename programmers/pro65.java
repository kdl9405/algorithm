import java.util.*;

/**
 * 짝지어 제거하기
 * 
 */
public class pro65 {

    public static void main(String[] args) {
        String s = "abbba";

        System.out.println(solution(s));
    }

    static int solution(String s) {
        int answer = 0;

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (deque.isEmpty()) {
                deque.offer(s.charAt(i));
            } else {
                if (deque.peekLast() == s.charAt(i)) {
                    deque.pollLast();
                }else{
                    deque.offer(s.charAt(i));
                }
            }
        }

        if (deque.isEmpty()) {
            answer = 1;
        }
       

        return answer;
    }
}