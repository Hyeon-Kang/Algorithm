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
	
	// 트리에 원소 추가
	public void insert(int item) {
		TreeNode p = this.root; // 포인터 1
		TreeNode q = new TreeNode(); // 포인터 2
		
		while(p != null)  { // 적합한 자리 탐색 순환
			if(p.item == item) return; // 삽입하려 할 원소가 이미 트리에 있는 경우 처리
			q = p;
			if(item < p.item) {
				p = p.left; // 좌측 노드 확인
			} else {
				p = p.right; // 우측 노드 확인
			}
		} // end while
		
		TreeNode temp = new TreeNode();
		temp.item = item;
		temp.right = null;
		temp.left = null;
		
		if(this.root == null) {
			root = temp; // 공백트리인 경우 바로 삽입
		} else if(item <q.item) {
			q.left = temp; // 노드의 왼쪽 서브노드에 삽입
		} else {
			q.right = temp; // 목표 노드의 오른쪽 서브노드에 삽입
		}
	}// end insert
	
	public void delete(int item) {
		deleteBST(this.root, item);
	}
	
	// 데이터 삭제가 관련되었으므로 private와 접근 메소드로 분리해놓음.
	private void deleteBST(TreeNode root, int item) {
		
		// 접근 포인터 선언
		TreeNode p = root;
		TreeNode parent = p;
		TreeNode q = null;
		
		if(p == null) {
			System.out.println("삭제할 원소가 트리에 존재하지 않습니다.");
		}
		
		if( (p.left == null) && (p.right == null) ) { // 삭제할 노드가 리프노드인 경우 (degree 0)
			if( parent.left == p) { // 목표가 왼쪽 서브노드에 있다면 왼쪽 null
				parent.left = null;
			} else {                // 반대인 경우 오른쪽 null;
				parent.right = null;
			}
		}
		
		if( (p.left == null) || (p.right== null)) { // 삭제할 노드가 degree 1 인경우
			if( p.left != null) {
				if (parent.left == p) {
					parent.left = p.left;
				} else {
					parent.right = p.right;
				}
			}
		}
		
		if ( (p.left != null) && (p.right != null)) { // 차수가 2인 경우
			q = maxNode(p.left);
			p.item = q.item;
			deleteBST(p.left, p.item);
		}
	}// end DeleteBST
	
	
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
	
	// 입력 원소 값을 기준으로 2개의 트리로 분할
	public void split(BST bBST, BST cBST, int x) {
		BST Small = new BST();
		BST Large = new BST();
		
		TreeNode S = Small.root; // Small의 순회 포인터
		TreeNode L = Large.root; // Large의 순회 포인터
		TreeNode P = this.root; // 분할하려는 BST의 순회 포인터
		System.out.println("this.root : "+ P.item);
		System.out.println("this.root.left : "+ P.left.item);
		while(P != null) {
			if(x == P.item) { // 해당 원소 발견 시
				S.right = P.left; // 해당 노드의 좌측 서브 노드를 S 포인터의 우측 노드에 저장
				System.out.println("S.rignt : "+ S.right.item);
				L.left = P.right; // 반대인 오른쪽 노드를 L 포인터의 좌측 노드에 저장
				bBST.root = Small.root.right; // 여태 적립된 Small의 우측 서브트리를 bBST에 저장
				cBST.root = Large.root.left;  // 여태 적립한 Large의 좌측 서브트리를 cBST에  저장
				System.out.println("입력 원소 "+x+"가 원본 BST에 있습니다.");
			} else if (x < P.item) { // 입력 원소 x가 현재 포인터 P의 키값보다 작은 경우
				L.left = P;  // L 포인트의 좌측 노드에 현재 P 노드 연결
				L = P; 		 // 저장했으니 L은 다음 노드로 한 칸 이동하고
				P = P.left;  // P 역시 더 작은 값을 찾기 위해 좌측 서브노드로 한 칸 이동한다.
			} else { // 입력 원소 x가 현재 포인터 P의 item 값보다 큰 경우
				S.right = P; // S 포인트의 우측 서브노드에 P 노드 적립
				S = P;   	 // S 포인트를 다음 칸으로 이동
				P = P.right; // P 포인트 역시 전달을 했으니 더 큰 값을 찾아 우측 서브노드로 이동
			}
			bBST.root = Small.root.right;
			cBST.root = Large.root.left;
			System.out.println("입력한 원소 "+ x + "가 원본 트리에 없습니다.");
		}
		
	}// end split
	
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
