package BOJ;

import java.io.*;
import java.util.*;

/* 
    중복 빼고 정렬하기

*/
public class BOJ10867 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        new BOJ10867().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Set<Integer> number = new HashSet<>(); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            number.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> numList = new ArrayList<>(number);
        Collections.sort(numList);

        StringBuilder answer = new StringBuilder();
        for(int n : numList){
            answer.append(n).append(" ");
        }        

        System.out.println(answer.toString().trim());
        
    }
}
