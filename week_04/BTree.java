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
			if(p != null) { // p 역시 공백 노드가 아닌 경우
				p = stack.peek(); // 스택에서 맨 위에 있는 데이터 읽기 (루트부터 접근)
				
				p = p.left; // p 의 초점을 좌측 서브노드로 이동
				while(p != null) { // 왼쪽 트리 순회
					stack.push(p); // -> |p|p.left|
					p = p.left; // 좌측 서브노드를 탐색하기 위해 이동 
					// (다음 순환에서 p=p.left 가 null로 판정된 경우 stack에 들은 |p.left|의 데이터를 읽고 탈출
					
				}
			}
			
			p = stack.pop(); // 스택의 좌측트리 데이터 pop  -> |p|
			System.out.print(p.item + " ");
			
			// 우측 데이터
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
	
	
	// root.item -> root.left -> root.right
	public void iterPreorder() {
		Stack<TreeNode> stack = new Stack<TreeNode>(); // 스택 초기화
		TreeNode p = root; // 임시노드 p에 this.root 복사
		
		// root node부터 접근
		if (p != null) {
			stack.push(p); // 스택에 루트 노드 저장
		}
		
		// 공백 스택이 아닌경우
		while (stack.isEmpty() != true) {
			
			
			// root 부터 접근해야 하므로 들어있는 데이터 꺼내기
			p=stack.pop();
			System.out.print(p.item + " ");

			// 스택이 FIFO 특성임을 감안하여 오른쪽 자식부터 집어넣는다. 
			// (꺼낼 때는 나중에 넣은 왼쪽부터 나오게!) 
			if (p.right!=null) {
				stack.push(p.right);
			}
			
			// 우측 서브노드
			if (p.left!=null) {
				stack.push(p.left);
			}
		}

	}



}
