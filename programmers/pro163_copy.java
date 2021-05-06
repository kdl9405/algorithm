package programmers;


/* 
    괄호 변환

    // 1) p에 대해서 앞부터 탐색
    // 2) 균형잡힌 문자열 u를 찾음 -> u가 올바른지 판단
    // 3) 올바르면 sb에 u를 붙이고 나머지 v를 시작  = u+v
    // 4) 올바르지 않으면, "(" + v + ")"+ u(앞뒤 제거 후 뒤집어서)

*/
public class pro163_copy {
    public String solution(String p) {
        
        sb = new StringBuilder();

        divide(p);
    
        return sb.toString();
    }
    
    static StringBuilder sb;
    static boolean isCorrect;
    
    static void divide(String p){
        
        if(p.length() == 0){
            return;
        }
        
        isCorrect = true;
        int cnt = 0;
        
        for(int i = 0; i<p.length(); i++){
            if(p.charAt(i) == '('){
                cnt++;
            } else {
                cnt--;
                if(cnt < 0){
                    isCorrect = false;
                }
            }
            
            if(i != 0 && cnt == 0){
                
                String u = p.substring(0,i+1);
                String v = p.substring(i+1,p.length());

                makeU(u,v);
                
                break;
            }
        }
    }
    
    static void makeU(String u, String v){
        
        if(isCorrect){
            sb.append(u);
            divide(v);
        }else {
            sb.append("(");
            divide(v);
            sb.append(")");
            
            for(int i = 1; i<u.length()-1; i++){
                if(u.charAt(i) == '('){
                    sb.append(")");
                }else{
                    sb.append("(");
                }
            }
        }
        
        return;
        
    }
}