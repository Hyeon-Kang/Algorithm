package week04;

import java.util.Stack;

class TreeNode {
	public Object item;
	public TreeNode left;
	public TreeNode right;
	
}
public class BTree {
	private TreeNode root = new TreeNode();
	
	public BTree() {
		this.root = null;
	}
	
	public BTree(BTree left, Object item, BTree right) {
		this.root.item = item;
		this.root.left = left.root;
		this.root.right = right.root;
	}
	
	public boolean isEmpty() { // 트리가 공백트리인지 검사
		if (this.root == null ) return true;
		return false;
	}
	
	public Object rootData() { // root data 출력, 없는 경우 null과 메시지 출력
		if(this.isEmpty()) {
			System.out.println("[INFO] Tree is Empty");
			return null;
		}else return root.item;
	}
	
	public BTree leftSubTree() { // 좌측 서브트리 출력
		BTree left = new BTree ();
		left.root = this.root.left;
		return left;
	}
	
	public BTree rightSubTree() { // 우측 서브트리 출력
		BTree right = new BTree();
		right.root = this.root.right;
		return right;
	}
	
	public void show() { // 트리 출력 함수
		BTree right = this.rightSubTree();
		BTree left = this.leftSubTree();
		
		System.out.println("root : " + this.rootData());
		System.out.println("Left Sub Tree root : " + left.root.item);
		System.out.println("Right Sub Tree root : " + right.root.item);
	}
	
	// 후위 순회
	public void PostOrder() {
		ThePostOrder(this.root);
	}
	private void ThePostOrder(TreeNode T) {
		if(T != null) {
			ThePostOrder(T.left); // 좌측 노드 방문
			ThePostOrder(T.right); // 우측 노드 방문
			System.out.print(T.item);
			//System.out.println(T.item); // root 방문
		}
	}
	
	
	// 중위 순회
	public void InOrder() {
		TheInOrder(this.root);
	}
	
	private void TheInOrder(TreeNode T) {
		if(T != null) {
			TheInOrder(T.left); // 좌측 노드 방문
			System.out.print(T.item);// 루트 방문
			TheInOrder(T.right); // 우측 노드 방문
		}
	}
	
	
	
	// 전위 순회
	
	public void PreOrder() {
		ThePreOrder(this.root);
	}
	
	private void ThePreOrder(TreeNode T) {
		if(T != null) {
			System.out.print(T.item); // root 선 방문
			ThePreOrder(T.left); // 좌측 노드 방문
			ThePreOrder(T.right); // 우측노드 방문
		}
	}
	
	// 중위순회 반복 (루트를 중간에)
	public void iterInorder() {
		Stack<TreeNode> stack = new Stack<TreeNode>(); //스택 초기화
		TreeNode p = root; // 트리노드 p에  해당 메소드 사용 트리의 root 노드 연결
		
		if( p != null) { // 노드가 공백이 아닌 경우
			stack.push(p); // stack에 p push  -> |p|
		}
		
		while(stack.isEmpty() != true) { // 공백 스택이 아닐 때
			if(p != null) { // p 역시 노드가 아닌 경우
				p = stack.peek(); // 스택에서 맨 위에 있는 데이터 읽기
				
				p = p.left; // p 의 초점을 좌측 서브노드로 이동
				while(p != null) { // 왼쪽 트리 순회
					stack.push(p); // -> |p|p.left|
					//System.out.println("추적");
					p = p.left;
				}
			}
			
			p = stack.pop(); // 스택의 좌측트리 데이터 pop  -> |p|
			System.out.print(p.item + " ");
			p = p.right;
			if(p != null) { 
				stack.push(p); 
			}
		}		
	}
	
	// 전위순회 (루트 먼저 방문)
	public void iterPreoder() {
		Stack<TreeNode> stack = new Stack<TreeNode> ();
		TreeNode p = root;
		
		
		if(p != null) {
			stack.push(p);
		}
		
		while(stack.isEmpty() != true) {
			if(p != null) {
				p = stack.peek(); // 스택 데이터 읽기
				
			}
		}
		
	}


}
