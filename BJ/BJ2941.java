import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BJ2941
 */
public class BJ2941 {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word[] ={"c=","c-","dz=","d-","lj","nj","s=","z="};
             
        String line = br.readLine();
        
        for(int i=0; i< word.length; i++){

            while(line.contains(word[i])){
            

                line = line.replace(word[i], " ");
            }
        }    
       

        System.out.println(line.length());

    }
    
}