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
		
		// # 스택에 루트를 입력
		if( p != null) { // 노드가 공백이 아닌 경우
			stack.push(p); // stack에 p push  -> |p|
		}
		
		// # 스택이 비워질 때 까지 반복
		while(stack.isEmpty() != true) { // 공백 스택이 아닐 때
			if(p != null) { // p 역시 노드가 아닌 경우
				p = stack.peek(); // # 스택 최상단 노드 데이터 출력 // 최초 접근 시 공백 출력
				
				p = p.left; // # p 의 초점을 좌측 서브노드로 이동
				
				while(p != null) { // # 왼쪽 트리 끝까지 순회 (null 찾기)
					stack.push(p); // -> |p|p.left|
					
					p = p.left;
				}
			}
			
			p = stack.pop(); // 스택의 좌측트리 데이터 pop  -> |p|
			System.out.print(p.item + " "); //노드 데이터 출력
			p = p.right; // # 우측 서브노드로 이동
			if(p != null) { 
				stack.push(p); // # 우측 끝 탐색
			}
		}		
	}
	
	// 전위순회 (루트 먼저 방문) 
	
	// root.item -> root.left -> root.right
	public void iterPreorder() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode p = root;
		// 트리노드 p 에 root 전달 (포인터 이동)
		if (p != null) {
			stack.push(p); // p에 데이터가 있다면 스택에 저장
		}
		
		while (stack.isEmpty() != true) {
			
			
			// 데이터 꺼내면서 출력
			p=stack.pop();
			System.out.print(p.item + " ");

			// 우측 순회
			if (p.right!=null) {
				
				stack.push(p.right);
			}
			// 좌측 순회
			if (p.left!=null) {
				
				stack.push(p.left);
			}
		}

	}

	
	public BTree copy() {
		BTree temp = new BTree();
		temp.root = theCopy(this.root);
		
		
		return temp;
	}
	
	private TreeNode theCopy(TreeNode T) {
		// 공백트리시 바로 null 반환
		if (T == null) {
			return null;
		} else {
			// 임시로 저장할 노드 선언
			TreeNode temp = new TreeNode();

			// 좌측, 우측, 저장 데이터 순
			temp.left = theCopy(T.left);
			temp.right = theCopy(T.right);
			temp.item = T.item;
			return temp; // 결과 반환
		}
	}
	
	public boolean equals (BTree S) {
		return theEquals(this.root, S.root);
	}
	
	public boolean theEquals(TreeNode S, TreeNode T) {
		
		// 두 트리가 모두 공백트리인 경우 바로 true 반환
		if (S == null && T == null) {

			return true;
			
		// 둘 다 null이 아닌 경우 순차적으로 재귀 접근
		} else if (S != null && T != null) {
			
			if (S.item==T.item) {
				
				// 내부 item이 같은 경우 재귀적 접근을 통한 좌우 순차 탐색
				return theEquals(S.left, T.left) && theEquals(S.right, T.right);
			}						
		}
		// 모두 해당이 없다면 false 반환
		return false;
	}
	
	

}// end BTree
