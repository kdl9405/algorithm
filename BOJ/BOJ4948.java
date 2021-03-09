import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ4948 {

    public static boolean primeN[];

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            int n = Integer.parseInt(br.readLine());
            
            if(n == 0){
                break;
            }

            primeN = new boolean[2*n+1];
            check_prime();

            int count = 0;
            for(int i = n+1; i<= 2*n; i++){
                if(primeN[i] == false){
                    count++;
                }
            }

            System.out.println(count);
            
        }
        
    }

    public static void check_prime(){
        primeN[0] = true;
        primeN[1] = true;

        for(int i = 2; i<= Math.sqrt(primeN.length); i++) {

            if(primeN[i]){
                continue;
            }

            for(int j = i*i; j<primeN.length; j+=i){
                primeN[j] = true;
            }
        }
    }
}