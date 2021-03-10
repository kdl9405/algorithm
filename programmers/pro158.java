package programmers;

/* 
    핸드폰 번호 가리기

*/
public class pro158 {

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        
        String front = phone_number.substring(0,phone_number.length()-4);
        
        front = front.replaceAll("[0-9]","*");
        answer = front+(phone_number.substring(phone_number.length()-4,phone_number.length()));
        
        return answer;
    }
}
}
