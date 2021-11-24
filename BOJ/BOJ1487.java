package BOJ;

/* 
    물건 팔기
*/

import java.io.*;
import java.util.*;


public class BOJ1487 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int price = 0;
        int profit = 0;

        HashMap<Integer, List<Integer>> customer = new HashMap<>();
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (!customer.containsKey(p)) {
                customer.put(p, new ArrayList<>());
            }
            if (p > m) {
                customer.get(p).add(m);
            }
        }

        int[] customer_price = Arrays.stream(customer.keySet().toArray()).mapToInt(i->(int)i).toArray();
        Arrays.sort(customer_price);

        for(int i = 0; i<customer_price.length; i++){
            
            int v = 0;
            for(int j = i; j<customer_price.length; j++){
                for(int m : customer.get(customer_price[j])){
                    if (customer_price[i] > m) {
                        v += (customer_price[i] - m);
                    }
                }
            }

            if (v > profit) {
                profit = v;
                price = customer_price[i];
            }
        }

        System.out.println(price);
    }
}
