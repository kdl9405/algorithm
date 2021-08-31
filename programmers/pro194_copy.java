package programmers;

import java.util.*;

/* 
    표 편집

    효율성 실패

*/

public class pro194_copy {

    public static void main(String[] args) {

        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

        System.out.println(solution(8, 2, cmd));

    }

    public static String solution(int n, int k, String[] cmd) {
        String answer = "";

        List<Boolean> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(true);
        }

        Stack<Integer> deletion = new Stack<>();

        for (String c : cmd) {
            
            String[] oper = c.split(" ");

            switch (oper[0]) {
                case "U":

                    k-= Integer.parseInt(oper[1]);

                    break;

                case "D":

                    k+= Integer.parseInt(oper[1]);

                    break;

                case "C":

                    list.remove(k);
                    deletion.push(k);

                    if (k == list.size()) {
                        k--;
                    }

                    break;

                case "Z":

                    int d = deletion.pop();

                    if (d <= k) {
                        k++;
                    }

                    list.add(d, true);

                    break;
            }


        }

        while (deletion.isEmpty()) {
            list.add(deletion.pop(), false);
        }

        StringBuilder sb = new StringBuilder();
        for(Boolean b : list){
            if (b) {
                sb.append("O");
            }else{
                sb.append("X");
            }
        }

        return answer = sb.toString();
    }
}
