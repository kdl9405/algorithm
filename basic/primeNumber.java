package basic;

import java.util.*;
//에라토스테네스의 체
public class primeNumber {
    
    public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
        
        System.out.println(primeN(num));
			
	}

	static int primeN(int num){
		if(num <=1){
		return 0;
		}
	
		int answer = 0;
		StringBuilder sb = new StringBuilder();
		
		boolean[] arr = new boolean[num+1];
		
		for(int i = 2; i<=num; i++){
			if(arr[i]){
				continue;
			}
			answer++;
			sb.append(i+" ");
			for(int j = 1; i*j<=num; j++){
				arr[i*j] = true;
			}
		}
		
		System.out.println(sb);
		return answer;
		
	}
}
