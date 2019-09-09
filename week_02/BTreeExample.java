package week02;

public class BTreeExample {

	public static void main(String[] args) { // binary Tree 예제
		BTree root;
		BTree LeftTemp;
		BTree RightTemp;
		
		BTree LeftSubroot;
		BTree RightSubroot;
		
		BTree empty = new BTree();
		
		LeftTemp = new BTree(empty, 'A', empty); // A 루트 추가
		RightTemp = new BTree(empty, 'B', empty); // B 루트 추가
		
		LeftSubroot = new BTree(LeftTemp, '+', RightTemp); // + 루트, (A, B 하위 노드)
		
		
		
		LeftTemp = new BTree(empty, 'C', empty); // C 루트 추가
		RightTemp = new BTree (empty, 'D', empty); // D 루트 추가
		
		RightSubroot = new BTree(LeftTemp, '/', RightTemp); // '/'를 루트로 두고 하위 노드로 C, D 연결
		
		root = new BTree (LeftSubroot, '*', RightSubroot); // 앞서 생성한 두 트리를 '*' 의 서브트리로 연결
		
		
		root.show(); // 생성된 트리 출력
		//root.leftSubTree().show();
		//root.rightSubTree().show();

	}

}
