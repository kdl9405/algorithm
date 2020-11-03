
import java.util.Arrays;
import java.util.Comparator;

//가장 큰수

public class pro16 {

    public static void main(String[] args) {

        int[] numbers = { 0, 00, 000};

        

         System.out.println(solution(numbers));

    }

    static String solution(int[] numbers) {
        String answer = "";

        String[] str = new String[numbers.length];
        
        for(int i = 0; i<str.length; i++){
            str[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(str , new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
            
        });

        for(int i = str.length-1; i>=0; i--){

            answer = answer+str[i];
          
        }

        if (answer.charAt(0) == '0') {

            answer = new String();
            answer = "0";            
        }

        return answer;
    }

    
}
