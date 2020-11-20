package Graph_DS;

import java.util.HashMap;

public class Graph_Client {

	public static void main(String[] args) {
		Graph graph=new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		
		graph.addEdge("A", "B", 2);
		graph.addEdge("A", "D", 6);
		graph.addEdge("B", "C", 8);
		graph.addEdge("C", "D", 10);
		graph.addEdge("D", "E", 1);
		graph.addEdge("E", "F", 13);
		graph.addEdge("E", "G", 15);
		graph.addEdge("F", "G", 24);

		graph.display();
//		
//		System.out.println(graph.numVertex());
//		System.out.println(graph.numEdge());
//		System.out.println(graph.containsVertex("D"));
//		System.out.println(graph.containsEdge("A", "X"));
//		graph.removeEdge("A", "D");
//		graph.display();
//		graph.removeVertex("A");
//		graph.display();
//		
//		graph.addVertex("H");
//		graph.display();
//		
//		graph.addEdge("E", "G", 19);
//		graph.display();
		
//		System.out.println(graph.hasPath("A", "F", new HashMap<>()));
//		System.out.println(graph.BFS("A", "F"));
//		System.out.println(graph.DFS("A", "F"));
//		System.out.println("Breadth First Traversal");
//		graph.removeEdge("E", "D");
//		graph.BFT();
//		System.out.println("------------------------------------");
//		System.out.println("Depth First Traversal");
//		graph.removeEdge("E", "D");
//		graph.DFT();
//		System.out.println("-------------------------------------");
//		graph.removeEdge("B", "C");
//		graph.removeEdge("F", "G");
//		System.out.println("Cycle is Present in Graph --> "+graph.isCycle());
//		graph.removeEdge("E", "D");
//		System.out.println("Graph is connected --> "+graph.isConnected());
		
//		graph.removeEdge("E", "D"); //for break conectivity
		
//		graph.removeEdge("B", "C");//for break Cycle
//		graph.removeEdge("F", "G");//for break Cycle
//		System.out.println("Graph is Tree ---> "+graph.isTree());
		
		graph.removeEdge("E", "D");
		graph.addVertex("H");
		System.out.println(graph.getComponentConnected());
	}

}
