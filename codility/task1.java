// binary gap 

public class task1 {
    public static void main(String[] args) {
        int N = 1041;
        
        System.out.println(solution(N));
    }
    
    static int solution(int N) {
        int answer = 0;

        String s = Integer.toBinaryString(N);

        int count = 0;
        for(int i = 0; i<s.length(); i++){
            if (s.charAt(i) == '0') {
                count++;
            }else{
                answer = Math.max(answer, count);
                count = 0;
            }

        }
        
        return answer;
    }
}
