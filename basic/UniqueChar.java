package basic;

import java.util.*;

public class UniqueChar {
    
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		System.out.println(uniqueChar(s));
		
	}

	static boolean uniqueChar(String s){
		HashSet<Character> hash = new HashSet<>();
		
		for(int i = 0; i<s.length(); i++){
			if(hash.contains(s.charAt(i))){
				return false;
			}else{
            hash.add(s.charAt(i));
			}
		}
		return true;
	}

}
