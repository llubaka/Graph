
public class MainClass {
	
	static Graph graph = new Graph();
	
	public static void findPath(String startName, String endName,
			Searchable searcher) {
		graph.resetAllNodes();
		if(searcher.search(startName, endName)) {
			System.out.println("HAVE A PATH");
		}else {
			System.out.println("THERE IS NO PATH");
		}
	}
	
	public static void init() {
		graph.addNode(new Node("A",2));
		graph.addNode(new Node("B",3));
		graph.addNode(new Node("C",4));
		graph.addNode(new Node("D",1));
		graph.addNode(new Node("E",2));
		graph.addNode(new Node("F",3));
		
		graph.addLink("A", "B", true);
		graph.addLink("A", "C", true);
		graph.addLink("D", "B", true);
		graph.addLink("E", "B", true);
		graph.addLink("C", "E", true);
		graph.addLink("C", "F", true);
		graph.addLink("E", "F", true);
	}

	public static void main(String[] args) {
		init();
		findPath("A", "F", new GreedyByWeight(graph));
	}

}
