package week02;

public class BTree { //트리 클래스 선언
	private TreeNode root = new TreeNode();
	
	public BTree() { // 트리 생성자
		this.root = null;
	}
	
	public BTree(BTree left, Object item, BTree right) { //트리 생성자, 파라미터 부여
		this.root.setItem(item);
		this.root.setLeft(left.root);
		this.root.setRight(right.root);
	}
	
	public boolean isEmpty() { // 공백트리 검사
		if(this.rootData() == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Object rootData() { // 트리의 root data 반환
		return this.root.getItem();
	}
	
	public BTree leftSubTree() { // 왼쪽 서브트리 반환
		
		if(this.rootData() == null) {
			return null; // 트리가 비어있으면 null 반환
		}
		
		
		BTree ltree = new BTree();
		
		ltree.root = this.root.getLeft(); // 왼쪽 서브트리 값 복사
		
		return ltree;
		
	}
	
	public BTree rightSubTree() { // 오른쪽 서브트리 반환
	
		BTree rtree = new BTree();
		rtree.root = this.root.getRight(); // 오른쪽 서브트리 값 복사
		return rtree;
		
	}
	
	public void show() { // 트리 출력 함수
		BTree right = this.rightSubTree(); // 루트의 오른쪽 서브트리 임시저장
		BTree left = this.leftSubTree();   // 루트의 왼쪽 서브트리 임시저장
		
		System.out.println("root : " + this.rootData()); // 루트 출력
		System.out.println("Left Sub Tree root : " + left.root.getItem()); //왼쪽 서브트리 출력
		System.out.println("Right Sub Tree root : " + right.root.getItem()); //오른 서브트리 출력
		
		
		//이하는 서브트리의 서브트리 출력
		if(left.root.getLeft() != null) {
			BTree left_Lsub = left.leftSubTree();
			System.out.println("'"+ left.root.getItem()+"' TreeNode Left Sub Tree root : " + left_Lsub.root.getItem());
		}
		
		if(left.root.getRight() != null) {
			BTree left_Rsub = left.rightSubTree();
			System.out.println("'"+ left.root.getItem()+"' TreeNode Right Sub Tree root : " + left_Rsub.root.getItem());
		}
		
		if(right.root.getLeft() != null) {
			BTree right_Lsub = right.leftSubTree();
			System.out.println("'"+ right.root.getItem()+"' TreeNode Left Sub Tree root : " + right_Lsub.root.getItem());
		}
		
		if(right.root.getRight() != null) {
			BTree right_Rsub = right.rightSubTree();
			System.out.println("'"+ right.root.getItem()+"' TreeNode Right Sub Tree root : " + right_Rsub.root.getItem());
		}
		
		
	}
	
}
