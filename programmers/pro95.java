package programmers;

/**
 * 스킬체크 레벨2 - 3
 */
public class pro95 {

    public static void main(String[] args) {

        String s = "(())()"	;
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
                answer = false;
                break;
            }
        }
        if (count != 0) {
            answer = false;
        }
       

        return answer;
    }
}