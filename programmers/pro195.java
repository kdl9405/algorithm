package programmers;

import java.util.Stack;

/* 
    110 옮기기
*/
public class pro195 {
    
    public static void main(String[] args) {
        
        String[] s = {"100111100"};

        solution(s);
    }

    public static String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for(int i = 0; i<s.length; i++){
            answer[i] = change(s[i]);
        }

        return answer;
    }

    static String change (String s){

        int count = 0;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length(); i++){

            if(stack.size()>1 &&  s.charAt(i) == '0'){

                char a = stack.pop();
                char b = stack.pop();

                if (a == '1' && b == '1') {
                    count++;
                }else{
                    stack.push(b);
                    stack.push(a);
                    stack.push('0');
                }

               
            }else {
                stack.push(s.charAt(i));
            }

        }
        
        if(count == 0){
            return s;
        }
        
        s = stack.toString().replaceAll("[^0-1]", "");

        StringBuilder x = new StringBuilder();
        while (count-- > 0) {
            x.append("110");
        }

        StringBuilder sb = new StringBuilder(s);
        
        boolean find = false;

        for(int i = sb.length()-1; i>=0; i--){
            if (sb.charAt(i) == '0') {

                sb.insert(i+1,x.toString().trim());
                
                find = true;
                
                break;
            }
        
        }
        
        if(!find){
            sb.insert(0,x.toString().trim());
        }

        return sb.toString();
    }
}