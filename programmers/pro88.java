import java.util.*;

/**
 * 가장 긴 팰린드롬

 */
public class pro88 {

    public static void main(String[] args) {
        
        String s = "a";

        System.out.println(solution(s));
    }


    static int solution(String s)
    {
        int answer = 1;

        for(int i = 0; i<s.length()-1; i++){
            int count = 1;
            for(int j = 1; j<s.length(); j++){
                int x = i-j;
                int y = i+j;
                if (x>=0 && y<s.length()) {
                    if (s.charAt(x) == s.charAt(y)) {
                        count = count + 2;
                    }else{
                        break;
                    }
                }else{
                    break;
                }
            }
            answer = Math.max(answer , count);
            
            if(s.charAt(i) == s.charAt(i+1)){
                count = 2;
                for(int j = 1; j<s.length(); j++){
                    int x = i-j;
                    int y = i+j+1;
                    if (x>=0 && y<s.length()) {
                        if (s.charAt(x) == s.charAt(y)) {
                            count = count + 2;
                        }else{
                            break;
                        }
                    }else{
                        break;
                    }
                }
                answer = Math.max(answer , count);
            }
        }      

        return answer;
    }
}