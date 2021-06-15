package stack;

import java.util.LinkedList;
import java.util.Scanner;

public class StackApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringStack S = new StringStack();
        S.stack = new LinkedList<>();
        S.max = 0;

        System.out.print("총 스택 저장 공간의 크기 입력 >> ");
        S.max = Integer.parseInt(sc.nextLine());

        while (true) {
            System.out.print("문자열 입력 >> ");
            String val = sc.nextLine();
            System.out.println(val);
            if (val.equals("그만")) {
                break;
            }else{
                if (S.length() < S.capacity()) {
                    S.push(val);
                }else{
                    System.out.println("스택이 꽉 차서 푸시 불가!");
                }
            }
        }

        System.out.print("스택에 저장된 모든 문자열 팝");

        while (S.length() > 0) {
            System.out.print(S.pop()+" ");
        }
        


    }
}
