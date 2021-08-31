package programmers;

import java.util.Arrays;

/* 
    [3차] 파일명 정렬
*/
public class pro196 {

    public static void main(String[] args) {
        
    }

    public static String[] solution(String[] files) {

        String[][] temp = new String[files.length][3]; // 0 - title , 1 - header , 2 - number

        for(int i = 0; i<files.length; i++){

            temp[i][0] = files[i];

            temp[i][1] = files[i].replaceAll("[0-9]", "\\*").split("\\*")[0];
            temp[i][2] = files[i].replaceAll("[^0-9]", " ").trim().split(" ")[0];
        }


        Arrays.sort(temp, (t1,t2)->{

            if (t1[1].equalsIgnoreCase(t2[1])) {
                return Integer.parseInt(t1[2]) - Integer.parseInt(t2[2]); 

            }
           
            return t1[1].compareToIgnoreCase(t2[1]);
        });


        String[] answer = new String[files.length];

        for(int i = 0; i<files.length; i++){
            answer[i] = temp[i][0];
        }

        return answer;
    }
    
}
