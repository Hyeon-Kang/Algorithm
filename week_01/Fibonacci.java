package alg.java;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("input : ");
		int n = scan.nextInt();
		// �� �Է�
		
		for(int i = 0; i<=n; i++) {
			System.out.println("fibo-" + i+ " : " + fibo(i));
			// �Ǻ���ġ ���� �ͷ�
			
		}
		
	}
	
	static int fibo(int n) {
		if(n <=0) return 0; // 0 ������ ��� 0 ��ȯ
		if (n ==1 ) return 1; // 1 �ΰ�� 1 ��ȯ
		return fibo(n-1) + fibo (n-2); // �Ǻ���ġ ���� ����� ǥ��
	}

}
