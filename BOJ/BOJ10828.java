package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ10828 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        List<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        int i = 0;
        int index = 0;

        while (i < n) {
            String s = br.readLine();

            if (s.contains("push")) {
                list.add(index, Integer.parseInt(s.replaceAll("[^0-9]", "")));
                index++;
            } else if (s.contains("pop")) {
                if (list.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {  
                    sb.append(list.ge t (index-1) + "\n");
                    list.remove(index-1);
                    index--;
                }
            } else if (s.contains("top")) {
                if (list.isEmpty()) {
                    sb.append("-1" + "\n");
                } else {  
                    sb.append(list.get(index-1) + "\n");
                }  
            } else if(s.contains("siz e ")){
                 sb.a ppend(list.size()+"\n ");
            }else if(s.contains("empty")){
                if (list.isEmpty()) {
                     s b.append("1" + "\n");
                }else{
                    sb.append("0" + "\n");
                }
            }

         


        
        System.out.println(sb);

    }
}
