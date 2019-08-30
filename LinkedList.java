package alg.java;

public class LinkedList {

	private ListNode head;
	
	public void addLastNode (Object data) {
		// �� �ڿ� ��� �߰�
		
		ListNode newNode = new ListNode();
		
		newNode.setData(data);
		newNode.setLink(null);
		// �� ��� ����
		
		if(head == null) {
			head = newNode;
			return;
		} // �ش� ����Ʈ ��尡 null ���̸� �ٷ� ������ newNode ����
		
		ListNode temp = head;
		// �ӽó�� temp�� head ����
		while(temp.getLink() != null) 
			// temp ��� link ���� null�� �ƴѰ��
		{
			temp = temp.getLink();
			// temp�� ���� ��尪 ȹ��
		}
		temp.setLink(newNode);
		// temp �ڿ� newNode ����
	}
	
	public void deleteLastNode() { // ������ ��� ����
		ListNode preNode, curNode;
		
		if (head == null) {
			System.out.println("[INFO] Delete Fail : Empty List");
			return;
		} // ����Ʈ head�� null�� ��� ����Ʈ�� ����ִٴ� �˸� ���
		
		if(head.getLink() == null) {
			head = null;
			return;
		} // ����Ʈ ����� ���� ������ null�� ��� null ��ȯ
		
		preNode = head;
		curNode = head.getLink();
		// ��ȯ Ž���� ���� ����
		
		while(curNode.getLink() != null) {
			// ����� link ���� null �� ���� �� ���� ���� ���� �̵� (link ���� null�� ��尡 ������ ������״�)
			preNode = curNode;
			curNode = curNode.getLink();
		}
		preNode.setLink(null);
		// ���������� ��ĭ �� ����� link ���� null�� �ʱ�ȭ �Ͽ� ������ ���� ������ ���´� (������ ��� ����)
	}
	
	public void delete(Object data) { // ����Ʈ���� �ش� �����͸� ���� ��� ����
		ListNode preNode, curNode;
		
		if(head == null) {
			System.out.println("[INFO] Delete Fail : Empty List");
			return;
		} // ����Ʈ�� �� ����ִ� ��� ���� ����Ʈ �˸� ���
		
		if(head.getLink() == null) {
			head = null;
			return;
		} // ����Ʈ head�� link���� null�� ���
		
		preNode = head;
		curNode = head.getLink();
		// ��ȯ Ž���� ���� ����
		
		if(data.equals(preNode.getData())) {
			head = preNode.getLink();
			preNode.setLink(null);
			return;
		}
		
		while(curNode != null) { // ���� ���� ���� null�� ��� = preNode.link ����� null�� ���
			if(data.equals(curNode.getData())) {
				if(curNode.getLink() == null) { // ������ ��带 ã�� ���
					preNode.setLink(null); // ���� ����� ���� ���� null�� �ʱ�ȭ �Ͽ� ���� ��带 ������ �� ó�� �Ѵ�.
				} else {
					preNode.setLink(curNode.getLink()); // ���� ���� �̵�
					curNode.setLink(null); // ���� ���� ���� null�� ����
				}
				return;
			}
			
			preNode = curNode;
			curNode = curNode.getLink();
			// ��� ���� ��ũ ���� ���� ����� ������ ���� (���� ���� �̵��ϴ� ����)
		}
		System.out.println("[INFO] No Delete Node"); // ����Ʈ�� �Է��� �����͸� ���� ��尡 ���� ���
	}
	
	public ListNode search(Object data) { // ��� ��ȯ Ž��
		ListNode temp = head;
		
		while(temp != null) { // Ž���ϴ� ����� ���� null�� �ƴ� ���
			if(data.equals(temp.getData())) { // ��ǥ ���� ���� ����� �� ��
				return temp; // ��ġ�� �ش� ��� ��ȯ (��ȯ Ž�� ����)
			} else {
				temp = temp.getLink(); // ��ġ���� �ʴ� ��� ���� ���� �̵�
			}
		}
		
		System.out.println("[INFO] No Search Node" + data); // ã�� �����Ͱ� ����Ʈ�� ���� ���
		return null;
	}
	
	public void insert(ListNode preNode, Object data) { // ��� ���� �Լ�
		ListNode newNode = new ListNode(data);
		
		if(head == null) {
			System.out.println("[INFO] Insert Fail : Empty List");
			return;
		} // ����Ʈ�� ����ִ°�� : ���鸮��Ʈ �˸� ���
		if(preNode == null) {
			System.out.println("[INFO] Insert Fail : PreNode is null");
			return;
		} // ���� ��尡 ����־ ������ �� ���� ���
		
		newNode.setLink(preNode.getLink());
		// ������ ��忡 preNode�� link �� ����
		preNode.setLink(newNode);
		// prenode -> newNode ó�� �ǹǷ� ��� ���� ����
	}
	
	public void show() {
		// ����Ʈ ��� �Լ�
		int i =0;
		if(head == null) {
			System.out.println("[INFO] Empty List");
			return;
		} // ����Ʈ head�� link ���� null�� ��� ����Ʈ�� ����ִٴ� �˸� ���
		ListNode temp = head;
		
		System.out.println("[INFO] List show start");
		// ��� ���� �˸�
		
		while(temp != null) {
			System.out.println("[INFO] List-" + i++ + " : "+ temp.getData());
			// ��� ���� :  ��� ������ ���
			temp = temp.getLink();
			// ��¿� �� ��带 ���� ���� �̵�
		}
		
		System.out.println("[INFO] List show end");
		// ��� ���� �˸�
	}

}
