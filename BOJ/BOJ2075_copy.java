package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* 
    N번째 큰 수
    1984 ms
*/
public class BOJ2075_copy {

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<n; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        Collections.sort(list, Collections.reverseOrder());

        System.out.println(list.get(n-1));
    }
}
