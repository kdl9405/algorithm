package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 

    집합

*/

public class BJ11723 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        boolean[] set = new boolean[21];
        StringBuilder sb= new StringBuilder();

        for(int i = 0; i<t; i++){

            String operation = br.readLine();

            if (operation.contains("all")) {
                Arrays.fill(set, true);
            }else if (operation.contains("empty")) {
                Arrays.fill(set, false);
            }else {
                String[] detail = operation.split(" ");
                int num = Integer.parseInt(detail[1]);
                switch (detail[0]) {
                    case "add":
                        set[num] = true;
                        break;
                
                    case "remove":
                        set[num] = false;                  
                        break;
                    
                    case "check":
                        if (set[num]){
                            sb.append("1").append("\n");
                        }else {
                            sb.append("0").append("\n");
                        }
                        break;
                
                    case "toggle":
                        if (set[num]){
                            set[num] = false;
                        }else {
                            set[num] = true;
                        }
                        break;
                    }
            }
        }

        System.out.println(sb.toString());
    }
}

