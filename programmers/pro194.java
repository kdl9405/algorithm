package programmers;

import java.util.*;

/* 
    표 편집

*/

public class pro194 {

    public static void main(String[] args) {

        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

        System.out.println(solution(8, 2, cmd));

    }

    public static String solution(int n, int k, String[] cmd) {

        Stack<Integer> deletion = new Stack<>();
        
        for(String c : cmd){
            if (c.equals("C")) {

                deletion.push(k);
                n--;
                if (k == n) {
                    k--;
                }
                
            }else if(c.equals("Z")){

                if (k >= deletion.pop()) {
                    k++;
                }
                n++;


            }else{
                String[] oper = c.split(" ");

                if ("U".equals(oper[0])) {
                    k-= Integer.parseInt(oper[1]);
                    
                }else {
                    k+= Integer.parseInt(oper[1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            sb.append('O');
        }

        while (!deletion.isEmpty()) {
            sb.insert(deletion.pop().intValue(), 'X');
        }

        return sb.toString();
    }
}
