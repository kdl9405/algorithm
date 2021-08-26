package programmers;

/* 
    숫자 문자열과 영단어

*/
public class pro191 {
    
    public static void main(String[] args) {
        
    }

    public static int solution(String s) {

        String[] number = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight","nine"};

        for(int i = 0; i<10; i++){
            if (s.contains(number[i])) {
                s = s.replaceAll(number[i], Integer.toString(i));
            }
        }

        return Integer.parseInt(s);
    }
}
