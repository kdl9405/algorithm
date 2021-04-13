package BOJ;

import java.io.*;
import java.util.*;

/* 
    택배
*/

// 도착지 오름차순
//      출발지 오름차순
//                          

public class BOJ8980 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] possible = new int[n+1];
        Arrays.fill(possible, c);

        ArrayList<ArrayList<parcel>> info = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            info.add(new ArrayList<>());
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            long a = Long.parseLong(st.nextToken());

            info.get(t).add(new parcel(f, a));
        }

        long total = 0;

        for (int i = 0; i <= n ; i++) {
            ArrayList<parcel> cityParcel = info.get(i);
            Collections.sort(cityParcel, (p1, p2) -> {
                if (p1.from == p2.from) {
                    return (int)(p1.amount - p2.amount);
                }
                return p2.from - p1.from;
            });

            for(parcel p : cityParcel){
                
                long max = p.amount;
                for(int x = p.from; x<i; x++){
                    max = Math.min(max, possible[x]);
                }

                total += max;

                for(int x = p.from; x<i; x++){
                    possible[x] -= max;
                }
            }           
        }  
        System.out.println(total);
    }
}

class parcel {
    int from;
    long amount;

    public parcel(int from, long amount) {
        this.from = from;
        this.amount = amount;
    }
}
