/**
 * JadenCase 문자열 만들기
 * 
 */
public class pro63 {

    public static void main(String[] args) {

        String s = "3people unFollowed me";

        System.out.println(solution(s));

    }

    static String solution(String s) {
        String answer = "";

        char[] ch = s.toCharArray();

        for(int i = 0; i<ch.length; i++){
            if (i == 0) {
                if (Character.isLowerCase(ch[0])) {
                    ch[0] = Character.toUpperCase(ch[0]);
                }
            }else{
                if (ch[i-1] == ' ') {
                    if (Character.isLowerCase(ch[i])) {
                        ch[i] = Character.toUpperCase(ch[i]);
                    }
                }else if(Character.isUpperCase(ch[i])){
                    ch[i] = Character.toLowerCase(ch[i]);
                }
            }          

        }

        StringBuilder sb = new StringBuilder();

        for(char c : ch){
            sb.append(c);
        }
         
        answer = sb.toString();

        return answer;
    }
}