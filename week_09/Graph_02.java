package week09;


// 무방향 그래프의 연결리스트 표현
public class Graph_02 {
	private Node_02[] header;
	private int vertex_size;
	
	public Graph_02(int vertex_size) {
		this.header = new Node_02[vertex_size];
		this.vertex_size = vertex_size;
		
		for(int i=0; i<this.vertex_size;i++) {
			this.header[i] = null;
		}
	}
	
	public void show() {
		if(this.vertex_size == 0) {
			System.out.println("[INFO] no vertex");
		}
		
		for(int i = 0; i<vertex_size; i++) {
			Node_02 temp = header[i];
			
			System.out.print(i+" : ");
			
			while(temp!=null) {
				System.out.print(temp.vertex + " ");
				temp = temp.link;
			}
			System.out.println();
		}
	}
	
	// 무방향 간선 추가
	public void add_edge(int i, int k) {
		Node_02 temp = new Node_02(k, null);   // vertex값으로 k를 갖는 임시 노드 생성
		temp.link = header[i]; 
		header[i] = temp; 
		// 맨 앞 자리에 새로운 노드 삽입
		
		// 반대 경우 추가 (대칭성을 보이므로 반대의 경우도 똑같이 처리함)
		Node_02 temp_r = new Node_02(i, null);
		temp_r.link = header[k];
		header[k] = temp_r;
	}
	
	
//	public void delete(int i, int k) {
//		delete_edge(i, k);
//		delete_edge(k, i);
//	}
	
	// 무방향 간선 삭제
	public void delete_edge(int i, int k) {
		if (header[i] == null || header[k] == null) return; // 공백인 경우
		if(header[i].vertex == k) header[i] = header[i].link; 
		// header[i]의 vertex가 k인 경우 해당 노드를 다음 순서 노드로 덮어씌움
		
		else {
			// 연결리스트 지정 삭제
			
			// 순환 탐색을 하여 해당 노드를 찾아 제거
			Node_02 pre, temp;
			pre = header[i];
			temp = header[i].link;
			
			// null 이 나오기 전 까지 안 나오면 계속 순환
			while(temp!=null) {
				if(temp.vertex == k) { // 순환하다 k 발견시
					pre.link = temp.link; // 노드 제거 절차
					//System.out.println("노드 " + temp.vertex +"와의 간선 삭제"); // trace
					break;
				}
				pre=temp;
				temp=temp.link;
			}
		}
		// 반대 경우 삭제 (위와 똑같이 대칭적 작업 수행)
		if (header[k] == null || header[i] == null) return; // 공백인 경우
		if(header[k].vertex == i) header[k] = header[k].link; 
		// [i]가 k인 경우 해당 노드를 다음 순서 노드로 덮어씌움
		
		else {
			// 연결리스트 지정 삭제
			Node_02 pre, temp;
			pre = header[k];
			temp = header[k].link;
			while(temp!=null) {
				if(temp.vertex == i) {
					pre.link = temp.link;
					//System.out.println("노드 " + temp.vertex +"와의 간선 삭제"); // trace
					break;
				}
				pre=temp;
				temp=temp.link;
			}
		}
	}
	
	
}
