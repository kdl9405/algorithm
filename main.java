import java.util.Scanner;

class algo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("세 정수의 최대값을 구합니다.");

        System.out.print("A : "); int a = scanner.nextInt();
        System.out.print("B : "); int b = scanner.nextInt();
        System.out.print("C : "); int c = scanner.nextInt();

        int max = a;

        if (b> max) max = b;
        if (c> max) max = c;

        System.out.println("최대값은 " + max + "입니다.");
        
        

    }
}