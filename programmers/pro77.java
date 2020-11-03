/**
 * [3차] n진수 게임
 */
public class pro77 {

    
    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1));
    }
    static String solution(int n, int t, int m, int p) {
        String answer = "";

        int len = t * m;

        String s = makeS(n, len);
        
        for(int c = 0; c<t; c++){
            answer+= s.charAt((p-1)+(m*c));
        }

        return answer;
    }

    static String makeS (int n, int len){
        String s = "01";
        
        int i = 2;        
        while (s.length()<len) {
            String temp = "";
            int num = i;
            while (num != 0) {

                temp = Integer.toHexString(num%n).toUpperCase() + temp;
                num /=n ; 
            }
            s += temp;
            i++;
        }

        return s;
    }
}