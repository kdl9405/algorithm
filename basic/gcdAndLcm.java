package basic;

import java.util.*;
// 유클리드 호제법
public class gcdAndLcm {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();

        System.out.println(gcd(num1, num2));
        System.out.println(lcm(num1, num2));

		
	}

	static int gcd(int num1, int num2){

		int a = num1;
		int b = num2;

		if(num1 < num2){
			a = num2;
			b = num1;
		}

		while(b!=0){
			int n = a%b;
			a = b;
			b = n;		
		}
	return a;
	}

	static int lcm(int num1, int num2){
		int gcdN = gcd(num1, num2);
		return (num1*num2)/gcdN;
	}
}