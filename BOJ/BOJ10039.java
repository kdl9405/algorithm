import java.io.*;

public class BJ10039 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        int[] score = new int[5];
        int sum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++){
            score[i] = Integer.parseInt(br.readLine());

            if(score[i] < 40){
                score[i] = 40;
            }

            sum = sum+score[i];
        }

        System.out.println(sum/5);

    }
}