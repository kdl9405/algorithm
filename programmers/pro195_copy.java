package programmers;

/* 
    110 옮기기

    18,19,20,21 시간초과
*/
public class pro195_copy {
    
    public static void main(String[] args) {
        
        String[] s = {"1110"};

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

        while (true) {

            int size = s.length();
            
            s = s.replaceAll("110", "");

            int dif = size-s.length();

            if (dif == 0) {
                break;
            }

            count += (dif/3);

        }
        
        
        if(count == 0){
            return s;
        }
        


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