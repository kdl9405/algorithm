package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/* 
    이진 검색 트리
*/
public class BOJ5639 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = new ArrayList<>();

        String n;
        while(true){
            n = br.readLine();

            if (n == null || n.equals("")){
                break;
            }

            number.add(Integer.parseInt(n));
            
        }

        sb = new StringBuilder();

        printNum(0, number.size()-1);

        System.out.println(sb.toString());

    }

    static StringBuilder sb;
    static List<Integer> number;

    static void printNum(int from, int to){

        if (from == to) {
            sb.append(number.get(from)+"\n");
            return;
        }

        int root = number.get(from);
        for(int i = from+1; i<=to; i++){
            if (number.get(i) > root) {
                printNum(from+1, i-1);
                printNum(i, to);
                sb.append(root+"\n");
                return;
            }

            if (i == to) {
                printNum(from+1, to);
                sb.append(root+"\n");
            }
        }

      
    }
}
