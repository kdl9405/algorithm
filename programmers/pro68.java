import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * 영어 끝말잇기

 */
public class pro68 {

    
    public static void main(String[] args) {

        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

        System.out.println(solution(n, words));
        
    }

    static int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Deque<String> deque = new LinkedList<>();
        deque.offer(words[0]);

        int i = 1;
        for(i = 1; i<words.length; i++){

            String before = deque.peekLast();

            if (before.charAt(before.length()-1) != words[i].charAt(0) || deque.contains(words[i])) {
                break;
            }

            else{
                deque.offer(words[i]);
            }            
        }

        System.out.println(i);

        if (deque.size() == words.length) {
            answer = new int[]{0,0};
        }else{

            answer[0] = i%n + 1;
            answer[1] = i/n + 1;
        }       

        return answer;
    }
}