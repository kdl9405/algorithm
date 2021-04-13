package BOJ;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
    이중 우선순위 큐
    
*/

public class BOJ7662 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            
            int count = Integer.parseInt(br.readLine());

            for (int j = 0; j < count; j++) {
                String[] operation = br.readLine().split(" ");
                if (operation[0].equals("I")) {
                    
                    int num = Integer.parseInt(operation[1]);

                    treeMap.put(num, treeMap.getOrDefault(num, 0)+1);
                    
                } else if (!treeMap.isEmpty()) {
                   
                    if (operation[1].equals("1")) {

                        int max = treeMap.lastKey();
                        if (treeMap.get(max) == 1) {
                            treeMap.remove(max);
                        }else{
                            treeMap.put(max, treeMap.get(max)-1);
                        }

                    } else {

                        int min = treeMap.firstKey();
                        if (treeMap.get(min) == 1) {
                            treeMap.remove(min);
                        }else{
                            treeMap.put(min, treeMap.get(min)-1);
                        }
                    }
                }
            }

            if (treeMap.isEmpty()) {
                sb.append("EMPTY");
            } else {
                
                sb.append(treeMap.lastKey() + " " + treeMap.firstKey());
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
