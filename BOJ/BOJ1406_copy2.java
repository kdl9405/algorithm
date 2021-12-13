package BOJ;


/* 
    에디터
*/

import java.io.*;
import java.util.*;

public class BOJ1406_copy2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int cursor = s.length();

        
        LinkedList<Character> sList = new LinkedList<>();
        ListIterator<Character> sIter = sList.listIterator();

        for(int i = 0; i<cursor; i++){
            sIter.add(s.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            
            String input = br.readLine();

            if (input.equals("L")) {

                if (sIter.hasPrevious()) {
                    sIter.previous();
                }
                
            }else if(input.equals("D")){

                if (sIter.hasNext()) {
                    sIter.next();
                }

            }else if(input.equals("B")){

                if (sIter.hasPrevious()) {
                   sIter.previous();
                   sIter.remove();
                }

            }else{

                sIter.add(input.charAt(2));

            }
        }

        StringBuilder sb=  new StringBuilder();
        for(char c : sList){
            sb.append(c);
        }   
        
        System.out.println(sb.toString());
        
    }
}
