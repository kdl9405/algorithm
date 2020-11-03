package programmers;

public class pro40 {
    
    public static void main(String[] args) {

        System.out.println(solution(12, 31));
        
    }

    static String solution(int a, int b) {
        String answer = "";
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU" };
        
        int[] month = new int[13];
        month[1] = 0;
        month[2] = 31;
        month[3] = 60;
        for(int i = 4; i<=7; i++){
            if (i % 2 == 0) {
                month[i] += month[i-1]+31;
            }else{
                month[i] += month[i-1]+30;
            }
        }
        month[8] = month[7] + 31;
        for(int i = 9; i<=12; i++){
            if (i % 2 == 0) {
                month[i] += month[i-1]+30;
            }else{
                month[i] += month[i-1]+31;
            }
        }

        answer = day[(month[a]+b-1)%7];


        return answer;
    }
}
