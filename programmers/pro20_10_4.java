import java.util.*;

/**
 * pro20_10_4
 */
public class pro20_10_4 {

    
    public static void main(String[] args) {

        String s = "oo";

        System.out.println(solution(s));
        
    }
    static long solution(String s) {
        long answer = 0;

        HashMap<String, Long> map = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            for(int j = 2; i+j <= s.length(); j++){

                String temp = s.substring(i, i+j);
                if (!map.containsKey(temp)) {
                    
                    long last = 0;
                    
                    for(int x = temp.length()-1; x>=0; x--){
                        if(temp.indexOf(temp.charAt(x)) == x){
                            last = x;
                            break;
                        }
                    }

                    map.put(temp, last);
                    
                }
                answer += map.get(temp);
            }
        }

        return answer;
    }
}