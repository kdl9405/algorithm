package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/* 
    생태학
*/
public class BOJ4358 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String tree = "";
        int count = 0;

        HashMap<String, Integer> hashMap = new HashMap<>();
        while (true) {

            tree = br.readLine();

            if (tree == null || tree.length() == 0) {
                break;
            }

            hashMap.put(tree, hashMap.getOrDefault(tree, 0) + 1);
            count++;
        }

        String[][] arr = new String[hashMap.keySet().size()][2];

        int i = 0;

        for (String name : hashMap.keySet()) {
            double per = hashMap.get(name)*100;

            per /= count;

            arr[i][0] = name;
            arr[i][1] = String.format("%.4f", per);

            i++;
        }

        Arrays.sort(arr, (a1, a2) -> {
            return a1[0].compareTo(a2[0]);
        });

        StringBuffer sb = new StringBuffer();

        for (String[] a : arr) {
            sb.append(a[0] + " " + a[1]).append("\n");
        }

        System.out.println(sb.toString().trim());

    }
}
