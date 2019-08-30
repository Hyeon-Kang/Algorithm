package alg.java;


public class ListNode {
	private Object data;
	private ListNode link;
	
	public ListNode() {
		this.setData(null);
		this.setLink(null);
		
	} // ����Ʈ��� ������
	
	public ListNode(Object data) {
		this.setData(data);
		this.setLink(null);
		
	} // ����Ʈ��� ������ (data �� ����)
	
	public ListNode (Object data, ListNode link) {
		this.setData(data);
		this.setLink(link);
	} // data�� link ���� ���ڷ� �޴� ������
	
	public Object getData() {
		return data;
	} // data ȹ��
	
	public void setData(Object data) {
		this.data = data;
	} // data ����
	
	public ListNode getLink() {
		return link;
	} // link ȹ��
	
	public void setLink(ListNode link) {
		this.link = link;
	} // link ����
}
