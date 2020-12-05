package basic;

import java.util.*;

public class IsAnagram {
    
    public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		System.out.println(isAnagram(s1, s2));
		
	}

	static boolean isAnagram(String s1, String s2){
		if(s1.length() != s2.length()){
			return false;
		}

		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i<s1.length(); i++){
			map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i),0)+1);
			map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i),0)-1);			
		}
		
		for(char c : map.keySet()){
			if(map.get(c) != 0){
				return false;
			}
		}

		return true;
	}

	

}
