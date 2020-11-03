package prograss;

public class solution1 {

    public static void main(String[] args) {

        int p = 1987;

        int result = solution(p);

        // System.out.println(result);

    }

    public static int solution(int p) {
        int answer = 0;

        p = p + 1;
       

        while (true) {
            if (checkNum(p) == true) {
                answer = p;
    
                break;    
            }
            
            p = p +1;
            
        }      
        

        return answer;

    }

    public static boolean checkNum(int p) {

        int[] number = new int[10];

        String numP = Integer.toString(p);

        String[] strArr = numP.split("");

        for (int i = 0; i < strArr.length; i++) {
            int num = Integer.parseInt(strArr[i]);

            number[num] += 1;
        }

        for (int j = 0; j < 10; j++) {
            if (number[j] > 1) {
                return false;
            }
        }

        return true;
    }
}