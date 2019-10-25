package week09;

public class Main_01 {

	public static void main(String[] args) {
		Graph_01 graph = new Graph_01(5);
		graph.add_edge(0, 1);
		graph.add_edge(0, 2);
		graph.add_edge(1, 2);
		graph.add_edge(1, 3);
		graph.add_edge(2, 3);
		graph.add_edge(3, 4);

		System.out.println("Graph");
		graph.show();
		
		graph.delete_edge(0, 1);
		graph.delete_edge(1, 3);
		System.out.println("\n===0-1 1-3 delete===");
		graph.show();
		

	}

}
