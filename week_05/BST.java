package week05;

class TreeNode {
	public int item;
	public TreeNode left;
	public TreeNode right;
}

public class BST {
	private TreeNode root = new TreeNode();
	
	public BST() {
		this.root = null;
	}
	
	// 입력한 데이터 순회 탐색
	public void search(int item) {
		if(searchBST(this.root, item) == null) { // 해당 데이터를 찾지 못한 경우
			System.out.println("[INFO] " + item + " Not Existing");
		}else {									 // 데이터 찾음	
			System.out.println("[INFO] " + item + " Existing");
		}
	}
	
	// 트리에서 입력한 원소 탐색 (재귀적 접근)
	private TreeNode searchBST(TreeNode B, int item) {
		TreeNode p;
		p = B;
		if ( p == null) return null; // 공백 이진트리 처리
		if ( p.item == item) return p; // 탐색 성공시 반환 값
		if ( p.item < item) {
			return searchBST(p.right, item); // 노드의 키값이 입력 인자보다 작으면 우측 순회
		} else {
			return searchBST(p.left, item); // 반대의 경우 좌측 순회
		}
	} // end searchBST

	
	// 원소를 삽입하는 메소드
	public void insert(int item) {
		// 트리를 이동할때 사용하는 2개의 포인터
		TreeNode p = this.root;
		TreeNode q = new TreeNode();
		
		// 공백 트리가 아니라면
		// 트리에 삽입하려는 원소가 있는지 검사한다.
		while(p != null) {
			if(item == p.item) {
				return;
			}
			// q는 p의 부모 노드(한 레벨 위)를 가르킨다.
			q = p;
			if(item < p.item) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		
		// 삽입할 새로운 노드를 만든다.
		TreeNode NewNode = new TreeNode();
		NewNode.item = item;
		NewNode.right = null;
		NewNode.left = null;
		
		// 공백 트리면 바로 삽입한다.
		if(this.root == null) {
			this.root = NewNode;
		// q는 탐색 종료 후의 원소
		} else if(item < q.item) {
			q.left = NewNode;
		} else {
			q.right = NewNode;
		}
	}


	// 삭제
	public void delete(int item) {
		deleteBST(this.root, item);
	}
	private void deleteBST(TreeNode root, int item) {
		// 주어진 키값 item를 가진 노드
		TreeNode p = root;
		// 삭제할 노드의 부모 노드
		TreeNode parent = p;
		TreeNode q = null;
		// 지울 노드를 찾아간다. 만약 찾지 못하면
		// 에러 출력
		while (p != null && p.item != item) {
			parent = p;
			if(p.item > item) {
				p = p.left;
			} else {
				p = p.right;
			}
			if(p == null) {
				System.out.println("트리가 존재하지 않습니다.");
			}
		}

		// 트리가 공백이면 공백 출력
		if(p == null) {
			return;
		}
		// 삭제할 노드가 마지막 노드(리프 노드)일 경우
		if((p.left == null) && (p.right == null)) {
			// p가 루트일 경우
			// 루트삭제
			if(p == root) {
				//이렇게 하면 안됨 동기화가 안된다.
				root = null;
				
				// 전체가 지워짐
				//this.root = null;
				
				// 강제로 지움
				//this.root.left.left = null;
			}
		}
		// 삭제할 노드의 자식이 1개 일 경우
		else if((p.left == null) || (p.right == null)) {
			// 삭제되는 노드에 자식을 위치시킨다.
			if(p.left != null) {
				parent.left = p.left;
			} else {
				parent.right = p.right;
			}
		}
		// 삭제할 노드의 자식이 2개일 경우
		else if((p.left != null) && (p.right != null)) {
			// 왼쪽 서브트리에서 최대 키값을 가진 원소를 찾는다.
			q = maxNode(p.left);
			p.item = q.item;
			
			if(q == p.left)
				p.left = p.left.left;
			deleteBST(p.left, p.item);	
		}
	}
	
	// 최대 키 값 탐색
	private TreeNode maxNode(TreeNode m) {
		TreeNode p = m;
		
		if(p == null) return p; // 최대인 경우 바로 반환
		else if (p.right == null) return p; // 공백인 경우 처리
		else {
			while (p.right != null) { // 더 큰 값을 찾아 오른쪽 끝까지 순회
				p = p.right;
			}
			return p;
		}
	} // end maxNode
	
	
	
	

	// 분할
	public void split(BST bBST, BST cBST, int x) {
		// 분할된 트리를 넣을 빈 트리 2개를 만든다
		TreeNode Small = new TreeNode();
		TreeNode Large = new TreeNode();
		
		// 위치를 알려줄 포인터 3개를 만든다.
		TreeNode S = Small;
		TreeNode L = Large;
		TreeNode P = this.root;
		
		
		// root 가 공백이 아닐때 까지
		while(P != null) {
			// 인수와 root가 일치한다면
			if (x == P.item) {
				// 옮겨둔 p.left(작은수트리)를 S.right에
				S.right = P.left;
				// 옮겨둔 p.right(큰수 트리)를 L.left에 넣는다.
				L.left = P.right;
				// 그리고 미리 만든 빈 트리에 각각 넣는다.
				bBST.root = Small.right;
				cBST.root = Large.left;
				break;
			} else if(x < P.item) {
				// 인수가 root의 item 보다 작으므로 왼쪽으로 넘어간다.
				L.left = P;
				L = P;
				P = P.left;
			} else {
				// 인수가 root의 item 보다 크므로 오른쪽으로 넘어간다.
				S.right = P;
				S = P;
				P = P.right;
			}
		}
		// null 처리를 안해주면 오류가 날 수도 있다.
		L.left = null;
		S.right = null;
		bBST.root = Small.right;
		cBST.root = Large.left;
	}
	
	
	
	
	// 트리 출력 함수
	public void show() {
		showBST (this.root);
		System.out.println();
	}
	
	// 출력 실행함수
	private void showBST(TreeNode B) {
		if (B != null) {
			System.out.print("[");
			showBST(B.left);
			System.out.print(B.item);
			showBST(B.right);
			System.out.print("]");
		}
	}// end showBST
}
