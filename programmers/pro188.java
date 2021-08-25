package programmers;


/* 
상호 평가

*/

public class pro188 {

    public static void main(String[] args) {

        int[][] scores = {{70,49,90},{68,50,38},{73,31,100}};
        
        System.out.println(solution(scores));
    }

    public static String solution(int[][] scores) {

        StringBuilder sb = new StringBuilder();


        for(int i = 0; i<scores.length; i++){

            int self = scores[i][i];
            int min = 101;
            int max = -1;

            int sum = 0;
            int avg = 0;

            for(int j = 0; j<scores.length; j++){

                if (i == j) {
                    continue;
                }

                sum += scores[j][i];

                min = Math.min(min, scores[j][i]);
                max = Math.max(max, scores[j][i]);
            }

            if (self < min || self > max ) {
                avg = sum / (scores.length-1);
            }else{
                sum += self;
                avg = sum / (scores.length);
            }

            if (avg >= 90) {
                sb.append("A");
            }else if(avg >= 80){
                sb.append("B");
            }else if(avg >= 70){
                sb.append("C");
            }else if(avg >= 50){
                sb.append("D");
            }else{
                sb.append("F");
            }
        }

       


        return sb.toString();
        
    }
    
}
