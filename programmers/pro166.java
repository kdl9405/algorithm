package programmers;

/* 
    이진 변환 반복하기

*/
public class pro166 {
    public static void main(String[] args) {
        String s = "01110";

        int[] answer = solution(s);
        System.out.println(answer[0]+" "+answer[1]);
    }
    public int[] solution(String s) {
        
        int[] answer = new int[2];
                
        while(!s.equals("1")){
            String ns = s.replaceAll("0","");
            
            answer[0]++;
            answer[1] += (s.length() - ns.length());
            
            int num = ns.length();
            s = Integer.toBinaryString(num);            
            
        }     
        
        return answer;
    }
}