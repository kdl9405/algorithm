import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ10773 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        int i = 0;
        int index = 0;

        while (i< n) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                index--;
                list.remove(index);                
            }else{
                list.add(index, num);
                index++;
            }
            i++;
        }

        int sum = 0;

        for(int x : list){
            sum += x;
        }

        System.out.println(sum);
    }
}
