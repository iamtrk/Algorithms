package accelhack;

public class Graph {

	// dependency list
	Node[] graph;
	int[] feasible;	// 0 means not visited; 1 -> visited; 2 -> feasible
	
	private static final int NOT_VISITED = 0;
	private static final int VISITED = 1;
	private static final int FEASIBLE = 2;
	
	public Graph(int n) {

		graph = new Node[n];
		
		for (int i = 0; i < n; i++)
			graph[i] = new Node(i);
		
		feasible = new int[n];
	}

	public void add (int nodeIndex, int dependencyIndex) {

		Node node = graph[nodeIndex];
		
		Node newDep = new Node(dependencyIndex);

		Node existingDeps = node.next;

		node.next = newDep;
		newDep.next = existingDeps;
	}
	
	// implements DFS
	private boolean hasCycle(int i) {
		
		if (feasible[i] == FEASIBLE)
			return false;
		else if (feasible[i] == VISITED)
			return true;
		else {
			
			// not visited node
			Node node = graph[i];
			
			feasible[i] = VISITED;
			while (node.next != null) {
				
				Node next = node.next;
				if (hasCycle(next.index))
					return true;
				
				node = next;
			}
				
			feasible[i] = FEASIBLE;
			return false;
		}
	}
	
	/**
	 * checks for a cycle in Directed graph
	 * 
	 * @return
	 */
	public boolean hasCycle() {
		
		for (int i = 0; i < graph.length; i++) {
			
			if (hasCycle(i))
				return true;
		}
		
		return false;
	}
}
