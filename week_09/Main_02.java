package week09;

public class Main_02 {

	public static void main(String[] args) {
		Graph_02 graph = new Graph_02(7);
		
		graph.add_edge(0, 1);
		graph.add_edge(0, 2);
		graph.add_edge(0, 3);
		graph.add_edge(0, 4);
		
		graph.add_edge(1, 4);
		
		graph.add_edge(2, 4);
		graph.add_edge(2, 5);
		
		graph.add_edge(3, 5);
		
		graph.add_edge(5, 6);
		
		System.out.println("Graph");
		graph.show();
		
		System.out.println("\n===0-4 Delete===");
//		graph.delete(0, 4);
//		graph.delete(5, 3);
		graph.delete_edge(0, 4);
		graph.show();
	}

}
