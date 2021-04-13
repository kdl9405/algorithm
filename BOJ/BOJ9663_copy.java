import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ9663
 */
public class BOJ9663_copy {

    static int n;
    static int[] map;
    static int count = 0;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n];

        set_quean(0);

        System.out.println(count);

    }

    static void set_quean(int depth) {

        if (depth == n) {
            count++;
            return;
        }

        for(int i = 0; i<n; i++){
            
            map[depth] = i;

            if(poosible(depth)){
                set_quean(depth+1);
            }
        }
    }

    static boolean poosible(int col){

        for(int i =0; i<col; i++){
            if(map[col] == map[i]){
                return false;
            }
            else if(Math.abs(col -i) == Math.abs(map[col] - map[i])){
                return false;
            }
            
        }

        return true;

    }

}