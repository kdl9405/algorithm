package BJ;

import java.io.*;
import java.util.*;

/* 
    택배
*/

public class BJ8980 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<parcel>> info = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            info.add(new ArrayList<>());
        }
        int m = Integer.parseInt(br.readLine());
        // int[][] info = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            info.get(f).add(new parcel(t, a));
        }

        HashMap<Integer, Integer> delivery = new HashMap<>();
        int total = 0;
        int now = 0;

        for (int i = n; i >= 0; i--) {
            ArrayList<parcel> cityParcel = info.get(i);
            Collections.sort(cityParcel, (p1, p2) -> {
                if (p2.to == p1.to) {
                    return p2.amount - p1.amount;
                }
                return p1.to - p2.to;
            });

            // for(int j = 0; j<cityParcel.size(); j++){
            // System.out.println("from = "+i+" to = "+cityParcel.get(j).to+" amout =
            // "+cityParcel.get(j).amount);
            // }

            if (delivery.containsKey(i)) {
                now -= delivery.get(i);
                total += delivery.get(i);
                delivery.remove(i);
            }

            for (parcel p : cityParcel) {

                if (c >= now + p.amount) {
                    now += p.amount;
                    total += p.amount;
                    delivery.put(p.to, value)
                }
            }
        }

        // for (int i = 4; i >= 0; i--) {
        // if (delivery.containsKey(i)) {

        // System.out.println(i+"에 내렷당 " + delivery.get(i));
        // now -= delivery.get(i);
        // total += delivery.get(i);
        // delivery.remove(i);
        // }

        // if (!info.get(i).isEmpty()) {
        // ArrayList<parcel> cityParcel = info.get(i);
        // Collections.sort(cityParcel, (p1, p2) -> {
        // if (p1.to == p2.to) {
        // return p1.amount - p2.amount;
        // }
        // return p1.to - p2.to;
        // });

        // for (parcel p : cityParcel) {

        // System.out.println("to = " + p.to + " amount = " + p.amount);

        // if (c >= now + p.amount) {
        // now += p.amount;
        // delivery.put(p.to, delivery.getOrDefault(p.to, 0) + p.amount);
        // } else {
        // if (c != now) {
        // delivery.put(p.to, delivery.getOrDefault(p.to, 0) + (c-now));
        // now = c;
        // }
        // }
        // }
        // }

        // System.out.println("dele " + delivery);
        // System.out.println("now = " + now + " total = " + total);
        // }

        System.out.println(total);
    }
}

class parcel {
    int to;
    int amount;

    public parcel(int to, int amount) {
        this.to = to;
        this.amount = amount;
    }
}
