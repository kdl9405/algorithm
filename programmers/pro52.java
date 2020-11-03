package programmers;

/**
 * 올바른 괄호
 */
public class pro52 {

    public static void main(String[] args) {
        String s = "(())()";
        
        System.out.println(solution(s));
    }

    static boolean solution(String s) {
        boolean answer = true;

        int count = 0;

        for(int i = 0; i<s.length(); i++){
            if (s.charAt(i) == '(') {
                count++;
            }else{
                count--;
            }
            if (count < 0) {
                return false;
            }
        }

        if (count != 0) {
            answer = false;
        }
        

        return answer;
    }
}