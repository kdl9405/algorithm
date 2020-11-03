package programmers;

public class pro44 {
    
    public static void main(String[] args) {
        
        System.out.println(solution(3, 6));
    }

    static long solution(int a, int b) {
        long answer = 0;
        
        long x = (long) a;
        long y = (long) b;
        
        answer = (x+y) * (Math.abs(x-y)+1) /2;
        
        return answer;
    }
}

