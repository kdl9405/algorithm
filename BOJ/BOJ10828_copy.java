import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ10828_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
                    System.out.println(-1);
                } else {
                    System.out.println(list.get(index-1));
                    list.remove(index-1);
                    index--;
                }
            } else if (s.contains("top")) {
                if (list.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(list.get(index-1));
                }
            } else if(s.contains("size")){
                System.out.println(list.size());
            }else if(s.contains("empty")){
                if (list.isEmpty()) {
                    System.out.println(-1);
                }else{
                    System.out.println(0);
                }
            }

            i++;
        }
      

    }
}
