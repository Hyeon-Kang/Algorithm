package week06;

public class Heap {
	private int nNode; // Heap에 저장된 노드의 개수
	private int maxSize; // 최대 노드 개수
	private int heap[]; // Heap(배열 표현)

	public Heap() {
		nNode = 0;
		maxSize = 5;
		heap = new int[maxSize];
	}
	
	public Heap(int[] tree) {
		nNode = tree.length -1;
		maxSize = tree.length;
		heap = tree;
		
		int p, temp;
		
			
			for(int i = (this.nNode/2); i>=1; i--) { // 트리의 중간 레벨로 이동
				
				p = i;
				for (int j = 2*p; j<= this.nNode; j = 2*j) { 
					// 해당 노드의 자식으로 이동, 이동한 노드가 가장 마지막 노드보다 인덱스가 작다면 그 자식 노드로 이동
					if(j < this.nNode) { // 이동했는데 아직 마지막 인덱스가 아니라면
						if(this.heap[j] < this.heap[j+1]) j++; // +1 (왼쪽에서 오른쪽 노드로 이동)
					}
					if(this.heap[p] >= this.heap[j]) { // 자식 노드가 부모보다 큰 경우 (정상이므로 절차 통과)
						return; // or break;
					}
					temp = this.heap[p];
					this.heap[p] = this.heap[j];
					this.heap[j] = temp;
					p = j; // 자식과 부모 swap
				}
			}
		
	}

	private void heapFull() {
		maxSize++; // 저장 공간 한도 1 증가
		int tempHeap[] = new int[maxSize]; // 확장한 최댓값을 갖는 배열 선언

		for (int i = 0; i < maxSize - 1; i++) {
			tempHeap[i] = heap[i]; // 데이터 복사
		}

		heap = tempHeap; // 확장한 tempHeap을 heap에 저장
	}

	public void insert(int item) {
		// nNode는 1부터 시작함 (배열의 번호 사용의 편의성을 위해 배열 0번 인덱스를 비워둠)
		nNode ++;

		// 배열이 가득 찬 경우 확장 절차 시행
		if (nNode == maxSize) {
			heapFull();
		}

		// 공백 heap인 경우 1번(첫 자리)에 item 삽입
		if (nNode == 1) {
			heap[nNode] = item;
		}
		
		// 최하위 노드부터 탐색
		for (int i = nNode; i > 0;) {
			// 최하위 노드가 root일 경우 return
			if (i == 1) {
				return; // 위의 공백heap이랑 동일하므로 메소드 종료.
			}

			// 넣은 원소가 부모보다 큰 경우 swap 실행
			if (item > heap[i / 2]) {

				heap[i] = heap[i / 2]; //부모의 값을 자식의 자리에 넣고
				heap[i / 2] = item; // 부모의 자리에 받은 원소 삽입

				i = i / 2; // 다음 연산에 쓸 배열 인덱스 이동 (부모 노드로 이동), 순차 표현이 아니므로 다음과 같이 진행
			} else {
				heap[i] = item; // 받은 원소가 부모보다 작은경우 자식노드 위치에 정상적으로 입력
				break;
			}
		}
	}

	public int delete() {
		int n = nNode;
		if (nNode == 0) {
			System.out.println("공백트리입니다.");
			return 0;
		}

		int item = this.heap[1]; // 삭제 대상 (최상위 노드)
		int temp = this.heap[nNode]; // 이동할 원소
		// heap[]; // 이동할 원소

		this.nNode -= 1; // 힙 원소수 1 감소
		int i = 1; // 부모노드
		int j = 2; // i의 왼쪽 자식 노드
		while (j <= nNode) {
			if (j < nNode) { // 현재 노드의 자식노드중 더 큰 자식 노드를 찾는다. (루트 노드의 왼쪽 자식)
				if (this.heap[j] < this.heap[j + 1]) {
					j++; // BST이므로 값이 더 큰 자식으로 갱신
				}
			}
			if (temp >= heap[j]) { // 더 큰 자식 노드보다 마지막 노드가 크면, while문 중지
				// return item;
				break;
			}

			this.heap[i] = this.heap[j]; // 더 큰 자식 노드보다 마지막 노드가 작으면, 부모노드와 더 큰 자식노드를 교환
			// 한 단계 아래로 이동.
			i = j; // 부모를 자식으로 갱신
			j = j * 2; // 자식을 좌측 노드로 갱신
		}
		heap[i] = temp;
		return item;

	}

	public void show() {
		for (int i = 1; i <= nNode; i++) {
			System.out.print(heap[i] + " | ");
			// 배열 순서대로 뱉어냄. 첫 인덱스 순으로 큰 값부터 나열
		}
		System.out.println("");
	}
}
