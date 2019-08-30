package alg.java;

import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("input : ");
		int n = scan.nextInt();
		
		System.out.println("loop factorial-" + n + " : " + loop(n));
		// 순환 표현
		System.out.println("rec factorial-" + n + " : " + rec(n));
		// 재귀 표현
		
		
	}
	
	static int loop(int n ) {
		int result =1;
		for(int i =1; i<=n; i++) {
			result *=i;
		}
		return result;
	} // 순환으로 표현한 팩토리얼 함수 ( n* n-1 * n-2 * .... * 0)
	
	static int rec(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * rec(n-1);
			// 입력한 수와 입력한 수 -1 을 반복 호출하여 n-1이 1이 될 경우 1을 반환하며 프로그램 결과 반환
		}
	} // 재귀로 표현한 팩토리얼 함수

}
