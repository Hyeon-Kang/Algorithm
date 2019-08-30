package alg.java;


public class ListNode {
	private Object data;
	private ListNode link;
	
	public ListNode() {
		this.setData(null);
		this.setLink(null);
		
	} // 리스트노드 생성자
	
	public ListNode(Object data) {
		this.setData(data);
		this.setLink(null);
		
	} // 리스트노드 생성자 (data 값 인자)
	
	public ListNode (Object data, ListNode link) {
		this.setData(data);
		this.setLink(link);
	} // data와 link 값을 인자로 받는 생성자
	
	public Object getData() {
		return data;
	} // data 획득
	
	public void setData(Object data) {
		this.data = data;
	} // data 설정
	
	public ListNode getLink() {
		return link;
	} // link 획득
	
	public void setLink(ListNode link) {
		this.link = link;
	} // link 설정
}
