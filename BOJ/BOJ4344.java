import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ4344
 * 
 *
 */
class BOJ4344 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        double[] overAvg;
        overAvg = new double[t];        

        for (int n = 0; n < t; n++) {

            
            String[] score = br.readLine().split(" ");
            int total = 0;
            int avg = 0;
            int count = 0;

            for(int i = 1; i<score.length; i++){

                total += Integer.parseInt(score[i]);
                
            }

            avg = total / Integer.parseInt(score[0]);

            for(int i = 1; i<score.length; i++){

                if(Integer.parseInt(score[i]) > avg)
                    count +=1;
            }

            overAvg[n] = 100 * (double)count / (Integer.parseInt(score[0]));
            
             
        }

        for (int n = 0; n<t; n++){
            System.out.printf("%.3f", overAvg[n]);
             System.out.println("%");
            
        }

        

    }
}