package prograss;

public class solution3 {

    public static void main(String[] args) {

        int total_sp = 121;
        int[][] skills = { { 1, 2 }, { 1, 3 }, { 3, 6 }, { 3, 4 }, { 3, 5 } };

        solution(total_sp, skills);

    }

    public static int[] solution(int total_sp, int[][] skills) {
        int[] answer = {};

        int max = 0;

        for (int i = 0; i < skills.length; i++) {
            if (skills[i][0] > max) {
                max = skills[i][0];
            }
            if (skills[i][1] > max) {
                max = skills[i][1];
            }
        }

        int[] number = new int[max+1];
        
        for (int j = 0; j < skills.length; j++) {          
            
            number[skills[j][0]] += 1;
            number[skills[j][1]] += 1;
        }

        for (int j = 1; j < number.length; j++) {
            if(number[j] !=1){
                for (int i = 0; i < skills.length; i++) {
                   if(skills[i][0] ==1){
                       
                   } 
                }
        
            }
        }

        return number;
    }
}