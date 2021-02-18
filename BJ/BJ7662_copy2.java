package BJ;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
    이중 우선순위 큐
    시간초과
*/

public class BJ7662_copy2 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            HashMap<Integer, Integer> hashMap = new HashMap<>();

            int count = Integer.parseInt(br.readLine());

            for (int j = 0; j < count; j++) {
                String[] operation = br.readLine().split(" ");
                if (operation[0].equals("I")) {
                    
                    int num = Integer.parseInt(operation[1]);

                    hashMap.put(num, hashMap.getOrDefault(num, 0)+1);

                } else if (!hashMap.isEmpty()) {
                    
                    int[] arr = hashMap.keySet().stream().mapToInt(a->a).toArray();
                    Arrays.sort(arr);

                    if (operation[1].equals("1")) {

                        int max = arr[arr.length-1];
                        if (hashMap.get(max) == 1) {
                            hashMap.remove(max);
                        }else{
                            hashMap.put(max, hashMap.get(max)-1);
                        }

                    } else {

                        int min = arr[0];
                        if (hashMap.get(min) == 1) {
                            hashMap.remove(min);
                        }else{
                            hashMap.put(min, hashMap.get(min)-1);
                        }
                    }
                }
            }

            if (hashMap.isEmpty()) {
                sb.append("EMPTY");
            } else {
                int[] arr = hashMap.keySet().stream().mapToInt(a->a).toArray();
                Arrays.sort(arr);
                sb.append(arr[arr.length-1] + " " + arr[0]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
