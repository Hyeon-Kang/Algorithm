package alg.java;

public class main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode temp = new ListNode();
		
		list.addLastNode("A"); // ������ ��忡 A �߰�
		list.addLastNode("B");
		list.addLastNode("C");
		list.addLastNode("E");
		list.addLastNode("F");
		list.addLastNode("G");
		list.show();			// ��� Ȯ��
		
		temp = list.search("A"); // ��ȯ Ž��
		
		list.insert(temp,  "D"); // ��� ����
		list.show();
		
		list.delete("A"); // A ���� ���� ��� ����
		list.delete("G");
		list.show();
		
		list.deleteLastNode(); // ������ ��� ����
		list.deleteLastNode();
		list.deleteLastNode();
		list.show();

	}

}
