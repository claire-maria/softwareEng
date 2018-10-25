package cs3016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DAG {
	public static final int UNVISITED = 0, IN_PROGRESS = 1, VISITED = 2;

	private final ArrayList<Integer>[] adjTable; // Adjacency table for all adjacency lists.

	/**
	 * Constructor.
	 * 
	 * @param v
	 *            - Number of vertices.
	 */
	@SuppressWarnings("unchecked")
	public DAG(int v) {
		// Create table of adjacency lists for v vertices.
		adjTable = (ArrayList<Integer>[]) new ArrayList[v];

		for (int i = 0; i < v; i++)
			adjTable[i] = new ArrayList<Integer>();
	}

	/**
	 * Add a directed edge from v->w.
	 *
	 * @param v
	 *            - Origin vertex.
	 * @param w
	 *            - Destination vertex.
	 */
	public void addEdge(int v, int w) {
		if (v >= 0 && v < adjTable.length && w >= 0 && w < adjTable.length)
			addEdge(adjTable, v, w);
		else
			System.out.println("Edge " + v + "->" + w + " ignored due to non-existent vertex.");
	}

	/**
	 * Add edge v->w to the adjacency table if it does not exist otherwise.
	 *
	 * @param adjTable
	 *            - The adjacency table to insert the new edge.
	 * @param v
	 *            - Origin vertex.
	 * @param w
	 *            - Destination vertex.
	 */
	private void addEdge(ArrayList<Integer>[] adjTable, int v, int w) {
		ArrayList<Integer> adjList = adjTable[v]; // Adjacency list for vertex v.
		if (!adjList.contains(w)) {
			adjList.add(w);
			if (isCyclic()) {
				// Remove offending edge from adjacency list.
				for (int i = 0; i < adjList.size(); i++) {
					if (adjList.get(i) == w)
						adjList.remove(i);
				}
				System.out.println("Cycle-completing edge " + v + "->" + w + " ignored.");
			}
		} else
			System.out.println("Duplicate edge " + v + "->" + w + " ignored.");
	}

	private boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {

		// Mark the current node as visited and
		// part of recursion stack
		if (recStack[i])
			return true;

		if (visited[i])
			return false;

		visited[i] = true;

		recStack[i] = true;
		List<Integer> children = adjTable[i];

		for (Integer c : children)
			if (isCyclicUtil(c, visited, recStack))
				return true;

		recStack[i] = false;

		return false;
	}

	boolean isCyclic() {
		int V = adjTable.length;
		// Mark all the vertices as not visited and
		// not part of recursion stack
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];

		// Recurse graph
		for (int i = 0; i < V; i++)
			if (isCyclicUtil(i, visited, recStack))
				return true;

		return false;
	}

}