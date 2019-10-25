package week09;

public class Graph_01 {
	private int[][] adj_matrix;
	private int vertex_size;
	
	public Graph_01(int vertex_size) {
		this.adj_matrix = new int[vertex_size][vertex_size];
		this.vertex_size = vertex_size;
	}
	
	// 무방향 그래프 간선 추가
	public void add_edge(int i, int k) {
		this.adj_matrix[i][k] = 1;
		this.adj_matrix[k][i] = 1; // 무방향 그래프 행렬은 대칭성을 보인다.
	}
	
	// 무방향 그래프 간선 삭제
	public void delete_edge(int i, int k) {
		this.adj_matrix[i][k] = 0;
		this.adj_matrix[k][i] = 0; // 무방향 그래프 행렬은 대칭성을 보인다.
	}
	
	// 그래프 출력
	public void show() {
		if (this.vertex_size == 0) {
			System.out.println("[INFO] no vertex"); // 노드 없음 = 행렬이 존재하지 않음
		}
		String temp = null;
		int i;
		for(i = 0; i<this.vertex_size;i++) {
			temp = "";
			for(int j=0; j<this.vertex_size;j++) {
				if(this.adj_matrix[i][j] == 1) {
					temp += j +" ";
				}
			}
			System.out.println(i + " : " + temp);
		} // end show Iterator
		
	}

}
