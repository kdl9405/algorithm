package programmers;

public class pro41 {
    
    public static void main(String[] args) {
        
        System.out.println(solution("qwer"));
    }

    static String solution(String s) {
        String answer = "";

        if (s.length() % 2 == 0) {
            answer = s.substring((s.length() / 2)-1, (s.length() / 2)+1);
        }else{
            answer = Character.toString(s.charAt(s.length()/2));
        }

        return answer;
    }
}
