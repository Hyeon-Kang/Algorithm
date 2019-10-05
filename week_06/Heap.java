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
	
	private void heapFull() {
		maxSize++; // 저장 공간 한도 1 증가
		int tempHeap[] = new int [maxSize]; // 확장한 최댓값을 갖는 배열 선언
		
		for(int i=0; i<maxSize-1;i++) {
			tempHeap[i] = heap[i]; // 데이터 복사
		}
		
		heap= tempHeap; // 확장한 tempHeap을 heap에 저장
	}
	
	public void insert(int item) {
		if( nNode == maxSize) { // 추가하려 했더니 이미 heap이 가득 찬 경우 heap 확장 절차 시행
			heapFull();
		}
		nNode ++; //nNode 1 증가
		for(int i=1; i<nNode; i++) {
			if(nNode == 1) {
				heap[i] = item; // heap이 비어있다면[1]에 item저장
			}
			else if(item <= heap[i/2]) {
				heap[i] = item; // 부모노드보다 추가한 item이 작다면 현 위치에 item 저장
			}
			else { // item이 부모보다 큰 경우 자리 교체
				heap[i] = heap[i/2]; // 부모랑 자식 자리 교체
				heap[i/2] = item;
			}
		}

		
	}
	
	public int delete() {
		if(nNode == 0) {
			System.out.println("공백트리입니다.");
			return 0;
		}
		int t_temp;
		int item = this.heap[1]; // 삭제 대상 (최상위 노드)
		this.heap[nNode]; // 이동할 원소
		nNode = nNode-1;
		int i = 1;
		int j = 2;
		while(j < nNode) {
			if(j<nNode) {
				if(this.heap[j] < this.heap[j+1]) {
					j = j+1;
				}
				if(t_temp>=heap[j]) {
					return item;
				}
				this.heap[i] = this.heap[j];
				i = j;
				j = j*2;
			}
			heap[i] = t_temp;
			return item;
		}
	}
	
	public void show() {
		for (int i=1; i<=nNode; i++) {
			System.out.print(heap[i] + " | ");
			// 배열 순서대로 뱉어냄. 첫 인덱스 순으로 큰 값부터 나열
		}
		System.out.println("");
	}
}
