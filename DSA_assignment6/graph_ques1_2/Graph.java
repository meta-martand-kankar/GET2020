package graph;

import java.util.List;

/**
 * This interface represents a Graph.
 * @author Martand
 */
public interface Graph {

	public boolean isConnected();
	public void displayGraph();
	public List<Integer> reachable(int vertex);
	public List<Edge> minimumSpanningTree();
	public int shortestPath(int source, int destination);

}
