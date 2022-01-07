package BOJ;

/* 
    국영수
*/

import java.io.*;
import java.util.*;

public class BOJ10825 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<score> pq = new PriorityQueue<>();

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            pq.add(new score(name, korean, english, math));
            
        }

        StringBuilder sb= new StringBuilder();
        while (!pq.isEmpty()) {
            sb.append(pq.poll().name).append("\n");
        }

        System.out.println(sb.toString());


    }

    private static class score implements Comparable<score> {

        String name;
        int korean;
        int english;
        int math;

        score(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(score s) {

            if (s.korean == korean) {

                if (s.english == english) {

                    if (s.math == math) {
                        return name.compareTo(s.name);
                    }

                    return s.math - math;
                }

                return english - s.english;
            }

            return s.korean - korean;
        }

    }
}
