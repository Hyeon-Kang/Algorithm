package alg.java;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("input : ");
		int n = scan.nextInt();
		// 값 입력
		
		for(int i = 0; i<=n; i++) {
			System.out.println("fibo-" + i+ " : " + fibo(i));
			// 피보나치 수열 촐력
			
		}
		
	}
	
	static int fibo(int n) {
		if(n <=0) return 0; // 0 이하인 경우 0 반환
		if (n ==1 ) return 1; // 1 인경우 1 반환
		return fibo(n-1) + fibo (n-2); // 피보나치 수열 재귀적 표현
	}

}
