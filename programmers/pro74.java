import java.util.*;
/**
 * [3차] 방금그곡

 */
public class pro74 {

    public static void main(String[] args) {

        String[] musicinfos = {"03:00,03:10,FOO,CCB#CCB", "04:00,04:08,BAR,ABC"};
        String m ="CCB";

        System.out.println(solution(m, musicinfos));
    }
    
    static String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        m = change(m);
        int time = 0;
        
        for(int i = 0; i < musicinfos.length; i++){
            String[] info = musicinfos[i].split(",");
            int start = (Integer.parseInt(info[0].substring(0,2))*60) + Integer.parseInt(info[0].substring(3,5));
            int fin = (Integer.parseInt(info[1].substring(0,2))*60) + Integer.parseInt(info[1].substring(3,5));
            
            Queue<Character> queue = new LinkedList<>();

            info[3] = change(info[3]);

            for(int j = 0; j<info[3].length(); j++){
                queue.offer(info[3].charAt(j));
            }
            StringBuilder sb = new StringBuilder();
            
            for(int j = 0; j<fin-start; j++){
                sb.append(queue.peek());
                queue.offer(queue.poll());
            }
            
            String real = sb.toString();
            
            if (real.contains(m)) {
                if (time < fin-start) {
                    time = fin-start;
                    answer = info[2];
                }
            }
        }
        
        
        
        return answer;
    }

   static String change (String s){

        s = s.replaceAll("A#", "H");
        s = s.replaceAll("C#", "I");
        s = s.replaceAll("D#", "J");
        s = s.replaceAll("F#", "K");
        s = s.replaceAll("G#", "L");

        return s;
   }
    
}