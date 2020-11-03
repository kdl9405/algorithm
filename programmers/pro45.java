package programmers;

public class pro45 {

    //멀쩡한 사각형
    
    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }

    static long solution(int w, int h) {
        long answer = 1;

        long x = Math.max(w, h);
        long y = Math.min(w, h);

        long r = 0;

        while (true) {

            long mod = x%y;
         
            if (mod == 0) {
                r = y;
                break;
            }
            
            x = y;
            y = mod;
        }

        x = Math.max(w, h);
        y = Math.min(w, h);

        answer = (x*y) - (x+y-r);
        


        return answer;
    }
}

