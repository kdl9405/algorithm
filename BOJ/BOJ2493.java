package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493 {

    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        Stack<Tower> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {

            int height = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                stack.add(new Tower(i, height));
            } else {
                while (!stack.isEmpty()) {
                    Tower tower = stack.peek();
                    if (tower.height >= height) {
                        arr[i] = tower.num;
                        stack.add(new Tower(i, height));
                        break;
                    } else {
                        stack.pop();
                    }
                }
                if (stack.isEmpty()) {
                    stack.add(new Tower(i, height));
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}

class Tower {
    int num;
    int height;

    public Tower(int num, int height) {
        this.num = num;
        this.height = height;
    }
}
