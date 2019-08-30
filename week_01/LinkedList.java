package alg.java;

public class LinkedList {

	private ListNode head;
	
	public void addLastNode (Object data) {
		// 맨 뒤에 노드 추가
		
		ListNode newNode = new ListNode();
		
		newNode.setData(data);
		newNode.setLink(null);
		// 빈 노드 생성
		
		if(head == null) {
			head = newNode;
			return;
		} // 해당 리스트 헤드가 null 값이면 바로 생성한 newNode 연결
		
		ListNode temp = head;
		// 임시노드 temp에 head 연결
		while(temp.getLink() != null) 
			// temp 노드 link 값이 null이 아닌경우
		{
			temp = temp.getLink();
			// temp의 연결 노드값 획득
		}
		temp.setLink(newNode);
		// temp 뒤에 newNode 연결
	}
	
	public void deleteLastNode() { // 마지막 노드 삭제
		ListNode preNode, curNode;
		
		if (head == null) {
			System.out.println("[INFO] Delete Fail : Empty List");
			return;
		} // 리스트 head가 null인 경우 리스트가 비어있다는 알림 출력
		
		if(head.getLink() == null) {
			head = null;
			return;
		} // 리스트 헤드의 연결 정보가 null인 경우 null 반환
		
		preNode = head;
		curNode = head.getLink();
		// 순환 탐색을 위한 변수
		
		while(curNode.getLink() != null) {
			// 노드의 link 값이 null 이 나올 때 까지 다음 노드로 이동 (link 값이 null인 노드가 마지막 노드일테니)
			preNode = curNode;
			curNode = curNode.getLink();
		}
		preNode.setLink(null);
		// 마지막보다 한칸 앞 노드의 link 값을 null로 초기화 하여 마지막 노드와 연결을 끊는다 (마지막 노드 삭제)
	}
	
	public void delete(Object data) { // 리스트에서 해당 데이터를 가진 노드 삭제
		ListNode preNode, curNode;
		
		if(head == null) {
			System.out.println("[INFO] Delete Fail : Empty List");
			return;
		} // 리스트가 텅 비어있는 경우 공백 리스트 알림 출력
		
		if(head.getLink() == null) {
			head = null;
			return;
		} // 리스트 head의 link값이 null인 경우
		
		preNode = head;
		curNode = head.getLink();
		// 순환 탐색을 위한 변수
		
		if(data.equals(preNode.getData())) {
			head = preNode.getLink();
			preNode.setLink(null);
			return;
		}
		
		while(curNode != null) { // 다음 연결 값이 null인 경우 = preNode.link 결과가 null인 경우
			if(data.equals(curNode.getData())) {
				if(curNode.getLink() == null) { // 마지막 노드를 찾은 경우
					preNode.setLink(null); // 앞의 노드의 연결 값을 null로 초기화 하여 다음 노드를 삭제한 것 처럼 한다.
				} else {
					preNode.setLink(curNode.getLink()); // 다음 노드로 이동
					curNode.setLink(null); // 이후 연결 값을 null로 지정
				}
				return;
			}
			
			preNode = curNode;
			curNode = curNode.getLink();
			// 노드 값과 링크 값을 다음 노드의 값으로 복사 (다음 노드로 이동하는 절차)
		}
		System.out.println("[INFO] No Delete Node"); // 리스트에 입력한 데이터를 가진 노드가 없는 경우
	}
	
	public ListNode search(Object data) { // 노드 순환 탐색
		ListNode temp = head;
		
		while(temp != null) { // 탐색하는 노드의 값이 null이 아닌 경우
			if(data.equals(temp.getData())) { // 목표 값과 현재 노드의 값 비교
				return temp; // 일치시 해당 노드 반환 (순환 탐색 종료)
			} else {
				temp = temp.getLink(); // 일치하지 않는 경우 다음 노드로 이동
			}
		}
		
		System.out.println("[INFO] No Search Node" + data); // 찾는 데이터가 리스트에 없는 경우
		return null;
	}
	
	public void insert(ListNode preNode, Object data) { // 노드 삽입 함수
		ListNode newNode = new ListNode(data);
		
		if(head == null) {
			System.out.println("[INFO] Insert Fail : Empty List");
			return;
		} // 리스트가 비어있는경우 : 공백리스트 알림 출력
		if(preNode == null) {
			System.out.println("[INFO] Insert Fail : PreNode is null");
			return;
		} // 앞의 노드가 비어있어서 삽입할 수 없는 경우
		
		newNode.setLink(preNode.getLink());
		// 생성한 노드에 preNode의 link 값 연결
		preNode.setLink(newNode);
		// prenode -> newNode 처럼 되므로 노드 삽입 성공
	}
	
	public void show() {
		// 리스트 출력 함수
		int i =0;
		if(head == null) {
			System.out.println("[INFO] Empty List");
			return;
		} // 리스트 head의 link 값이 null인 경우 리스트가 비어있다는 알림 출력
		ListNode temp = head;
		
		System.out.println("[INFO] List show start");
		// 출력 시작 알림
		
		while(temp != null) {
			System.out.println("[INFO] List-" + i++ + " : "+ temp.getData());
			// 노드 순서 :  노드 데이터 출력
			temp = temp.getLink();
			// 출력에 쓸 노드를 다음 노드로 이동
		}
		
		System.out.println("[INFO] List show end");
		// 출력 종료 알림
	}

}
