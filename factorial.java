package alg.java;

import java.util.Scanner;

public class factorial {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("input : ");
		int n = scan.nextInt();
		
		System.out.println("loop factorial-" + n + " : " + loop(n));
		// ��ȯ ǥ��
		System.out.println("rec factorial-" + n + " : " + rec(n));
		// ��� ǥ��
		
		
	}
	
	static int loop(int n ) {
		int result =1;
		for(int i =1; i<=n; i++) {
			result *=i;
		}
		return result;
	} // ��ȯ���� ǥ���� ���丮�� �Լ� ( n* n-1 * n-2 * .... * 0)
	
	static int rec(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * rec(n-1);
			// �Է��� ���� �Է��� �� -1 �� �ݺ� ȣ���Ͽ� n-1�� 1�� �� ��� 1�� ��ȯ�ϸ� ���α׷� ��� ��ȯ
		}
	} // ��ͷ� ǥ���� ���丮�� �Լ�

}
