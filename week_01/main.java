package alg.java;

public class main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		ListNode temp = new ListNode();
		
		list.addLastNode("A"); // 마지막 노드에 A 추가
		list.addLastNode("B");
		list.addLastNode("C");
		list.addLastNode("E");
		list.addLastNode("F");
		list.addLastNode("G");
		list.show();			// 결과 확인
		
		temp = list.search("A"); // 순환 탐색
		
		list.insert(temp,  "D"); // 노드 삽입
		list.show();
		
		list.delete("A"); // A 값을 가진 노드 삭제
		list.delete("G");
		list.show();
		
		list.deleteLastNode(); // 마지막 노드 삭제
		list.deleteLastNode();
		list.deleteLastNode();
		list.show();

	}

}
