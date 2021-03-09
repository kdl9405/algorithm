import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ4949 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();

            if (s.equals(".")) {
                break;
            }

            s = s.replaceAll("[^\\[\\]()]", "");
            List<String> list = new ArrayList<>();
            int index = 0;
            boolean check = true;

            for (int i = 0; i < s.length(); i++) {

                switch (s.charAt(i)) {
                    case '[':
                        list.add(index, "[");
                        index++;
                        break;
                    case ']':
                        if (index > 0 && list.get(index - 1).equals("[")) {
                            list.remove(index - 1);
                            index--;
                        } else {
                            check = false;
                        }
                        break;
                    case '(':
                        list.add(index, "(");
                        index++;
                        break;
                    case ')':
                        if (index > 0 && list.get(index - 1).equals("(")) {
                            list.remove(index - 1);
                            index--;
                        } else {
                            check = false;
                        }
                        break;
                    default:
                        break;
                }

                if (!check) {
                    break;
                }
            }
            if (list.size()==0 && check) {
                sb.append("yes" + "\n");
            }else{
                sb.append("no" + "\n");
            }
        }

        System.out.println(sb);

    }
}
