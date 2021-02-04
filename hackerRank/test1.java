package hackerRank;

import java.util.List;

public class test1 {
    public static void main(String[] args) {
    
        


    }   

    public static int minCost(int rows, int cols, int initR, int initC, int finalR, int finalC, List<Integer> costRows, List<Integer> costCols) {
        // Write your code here
        
        int answer = 0;
        
        if (initR > finalR) {
            int temp = initR;
            initR = finalR;
            finalR = temp;
        }
        if (initC > finalC) {
            int temp = initC;
            initC = finalC;
            finalC = temp;
        }
        
        for(int i = initR; i<finalR; i++){
            answer += costRows.get(i);
        }
        
        for(int i = initC; i<finalC; i++){
            answer += costCols.get(i);
        }   
        
        
        return answer;
    
        }

}
