import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ3052
 * 
 *
 */
class BOJ3052 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num, N;
        num = new int[11];
        N = new int[42];
        int temp;
        int count = 0;

        for (int i = 0; i < 10; i++){
            
            num[i] = Integer.parseInt(br.readLine());

            temp = num[i]%42;

            if(N[temp] == 0){
                N[temp] = 1;
                count +=1;
            }
            

        }

        System.out.println(count);
                
       
    }
}