package cs3016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DAG {
	public static final int UNVISITED = 0, IN_PROGRESS = 1, VISITED = 2;

	private final ArrayList<Integer>[] adjTable; // Adjacency table for all adjacency lists.

	@SuppressWarnings("unchecked")
	public DAG(int v) {
		// Create table of adjacency lists for v vertices.
		adjTable = (ArrayList<Integer>[]) new ArrayList[v];

		for (int i = 0; i < v; i++)
			adjTable[i] = new ArrayList<Integer>();
	}

	/**
	 * Add a directed edge from v->w.
	 */
	public void addEdge(int v, int w) {
		if (v >= 0 && v < adjTable.length && w >= 0 && w < adjTable.length)
			addEdge(adjTable, v, w);
		else
			System.out.println("Edge " + v + "->" + w + " ignored due to non-existent vertex.");
	}

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

	public ArrayList<Integer> lowestCommonAncestors(int v1, int v2) {
		ArrayList<Integer> lowestCommonAncestors = new ArrayList<Integer>();
		if (v1 == v2) {
			lowestCommonAncestors.add(v1);
			return lowestCommonAncestors;
		}
		if (v1 < 0 || v1 >= adjTable.length || v2 < 0 || v2 >= adjTable.length) {
			return null;
		}

		// Reverse adjacency table to find parents of all vertices.
		ArrayList<Integer>[] parentTable = reverse(adjTable);

		boolean[] v1Ancestors = new boolean[adjTable.length];
		Arrays.fill(v1Ancestors, false);

		v1Ancestors[v1] = true;
		for (int v : parentTable[v1]) {
			markAncestors(parentTable, v1Ancestors, v);
		}

		// Populate ArrayList with lowest common ancestors.
		Queue<Integer> currentLevel = new LinkedList<Integer>();
		Queue<Integer> nextLevel = new LinkedList<Integer>();
		for (int v : parentTable[v2])
			currentLevel.add(v);

		while (!currentLevel.isEmpty()) {
			while (!currentLevel.isEmpty()) {
				int v = currentLevel.remove();

				if (v1Ancestors[v])
					lowestCommonAncestors.add(v);

				if (lowestCommonAncestors.isEmpty()) {
					for (int w : parentTable[v])
						nextLevel.add(w);
				}
			}
			currentLevel = nextLevel;
			nextLevel = new LinkedList<Integer>();
		}

		return lowestCommonAncestors;
	}

	// dfs
	void markAncestors(ArrayList<Integer>[] parentTable, boolean[] v1Ancestors, int vertex) {
		v1Ancestors[vertex] = true;
		for (int v : parentTable[vertex]) {
			markAncestors(parentTable, v1Ancestors, v);
		}
	}

	// reverses adj table to get ancestor
	private ArrayList<Integer>[] reverse(ArrayList<Integer>[] adjTable) {
		ArrayList<Integer>[] reversed = (ArrayList<Integer>[]) new ArrayList[adjTable.length];
		for (int i = 0; i < reversed.length; i++)
			reversed[i] = new ArrayList<Integer>();

		// For each v->w, add w->v to reversed adjacency table.
		for (int v = 0; v < adjTable.length; v++) {
			for (int w : adjTable[v])
				addEdge(reversed, w, v);
		}
		return reversed;
	}

	/*
	 * return adj table as a string
	 */
	public String toString() {
		return toString(adjTable);
	}

	private String toString(ArrayList<Integer>[] adjTable) {
		String string = "";
		for (int v = 0; v < adjTable.length; v++) {
			string += v + ": ";
			for (int vertex : adjTable[v]) // Add each vertex in the current adjacency list.
				string += vertex + " ";
			string += "\n";
		}
		return string;
	}
}
