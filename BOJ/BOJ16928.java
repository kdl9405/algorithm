package BOJ;

import java.io.*;
import java.util.*;

/*
    뱀과 사다리 게임
*/


public class BOJ16928 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> move = new HashMap<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            move.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        boolean[] visit= new boolean[101];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visit[1] = true;

        int count = 0; 
        while (!queue.isEmpty()) {

            if (visit[100]) {
                break;
            }
            
            int size = queue.size();

            while (size-- >0) {
                int now = queue.poll();

                for(int i = 1; i<=6; i++){

                    int next = now+i;

                    if (next>100) {
                        break;
                    }

                    while (move.containsKey(next)) {
                        next = move.get(next);
                    }

                    if (!visit[next]) {
                        visit[next] = true;
                        queue.add(next);
                    }
                }
            } 

            count++;
        }


        System.out.println(count);
    }
}
