package basic;

import java.util.*;

public class ReverseString {
    
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		String r = reverseS(s);

		System.out.println(r);
	}

	static String reverseS(String s){
		String r = "";

		for(int i = 0; i<s.length(); i++){
			r = s.charAt(i) + r;
		}

		return r;
	}

}
