package programmers.summer;

import java.util.*;

// 대기 승객은 큐에 집어넣고
// 큐는 랭크순으로


public class solution2 {

    public static void main(String[] args) {
        int[] t = {7,6,8,1};
        int[] r = {0,1,2,3};
        
        int[] a = solution(t, r);

        for(int b : a){
            System.out.print(b+" ");
        }
    }

    public static int[] solution(int[] t, int[] r) {

        int len = t.length;

        int[] answer = new int[len];

        int[][] customer = new int[len][3]; // 0 : t  1: r  2: index

        for(int i = 0; i<len; i++){
            customer[i][0] = t[i];
            customer[i][1] = r[i];
            customer[i][2] = i;
        }    

        Arrays.sort(customer, (a,b)->{

            if(a[0]==b[0]){
                return a[1]-b[1];
            }

            return a[0]-b[0];
        });
       
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]){
                if (a[0]==b[0]) {
                    return a[2]-b[2];
                }
                return a[0]-b[0];
            }
            return a[1]-b[1];
        });
        
        int i = 0; // 리프트 인덱스
        int j = 0; // customer 인덱스
        int cnt = 0; // answer 인덱스

        while (cnt < len) {
            
            for(;j<len; j++){
                if (customer[j][0]>i) {
                    break;
                }
                pq.add(customer[j]);
            }

            if (pq.isEmpty()) {
                i = customer[j][0];
                // pq.add(customer[j]);
                // j++;
                continue;
            }

            System.out.println("!! cnt " + cnt);

            answer[cnt] = pq.poll()[2];

            i++;
            cnt++;

        }
       

        return answer;
    }

}
