package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ1874 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        List<String> list = new ArrayList<>();
        Stack<Integer> num = new Stack<>();
        boolean check = true;

        int x = 1;
        for (int i = 0; i < n; i++) {

            while (true) {

                if (x>n) {
                    if (num.peek() != arr[i]) {
                        check = false;
                        break;
                    }else{
                        num.pop();
                        list.add("-");
                        break;
                    }
                }else{
                    if (num.size() == 0) {
                        num.push(x);
                        list.add("+");
                        x++;
                    }else{
                        if (num.peek() == arr[i]){
                            num.pop();
                            list.add("-");
                            break;
                        }else{
                            num.push(x);
                            list.add("+");
                            x++;
                        }
                    }
                }
            }

            if (!check) {
                System.out.println("NO");
                break;
            }
        }

        if (check) {
            for(int i = 0; i<list.size();i++){
                System.out.println(list.get(i));
            }
        }


    }
}
