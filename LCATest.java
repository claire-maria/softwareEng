package cs3016;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertNotEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class LCATest {
	// test graph LCA functions
	@Test
	public void test1() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("LCA(4, 5): " + tree.findLCA(4, 5));
	}

	@Test
	public void test2() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("LCA(4, 6): " + tree.findLCA(4, 6));
	}

	@Test
	public void test3() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("LCA(3, 6): " + tree.findLCA(3, 6));
	}

	@Test
	public void test4() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("LCA(3, 7): " + tree.findLCA(3, 7));
	}

	@Test
	public void test5() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("LCA(1, 7): " + tree.findLCA(1, 7));
	}

	@Test
	public void test6() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("LCA(2, 5): " + tree.findLCA(2, 5));
	}

	@Test
	public void test7() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("LCA(2, 4): " + tree.findLCA(2, 4));
	}

	@Test
	public void test8() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("LCA(1, 4): " + tree.findLCA(1, 4));
	}

	@Test
	public void test9() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("LCA(5, 2): " + tree.findLCA(5, 2));
	}

	@Test
	public void test10() {
		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		System.out.println("LCA(6, 7): " + tree.findLCA(6, 7));
	}
	
	//Test for alt cases
	@Test
	public void testExtra() {
		LCA tree = new LCA();
		tree.root = new Node(0);
		tree.root.left = new Node(1);
		tree.findLCA(50, -9);
		tree.findLCA(-1, 20);
		tree.findLCA(-100, -100);
		tree.findLCA(0, 0);
		tree.findLCA(9, -20);
		assertNotEquals(null, tree.findLCA(0,1)); 
		
		
	}

	// Test Graph creation
	//
	@Test
	public void testGraph1() {
		Graph graph = new Graph(5);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);

		assertEquals(5, graph.adj.size());
		// If size is correct I can assume it built
		for (int i = 0; i < graph.adj.size(); i++) {
			System.out.println(graph.adj.size());
			// V0 adj v2
			// V1 adj V2 and V3
			// V2 adj V4
			// V3 adj V4
			// V4 is not adj to any V this is correct
		}
	}

	// Test root == null
	@Test
	public void rootTest() {
		LCA tree = new LCA();
		int n = 0;
		List<Integer> path = null;
		tree.findPath(null, n, path);
		assertEquals(tree.root, null);
	}

	@Test
	public void testGraph2() {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 3);
		graph.addEdge(4, 5);

		assertEquals(6, graph.adj.size());
		// If size is correct I can assume it built
		for (int i = 0; i < graph.adj.size(); i++) {
			System.out.println(graph.adj.size());
			// V0 adj v2 and V1
			// V1 adj V2 and V3
			// V2 adj V4
			// V3 adj V5
			// V4 is adj to v3 and V5
			// v5 is not adj to any V
			// correct
		}
	}

	// test if graphs are acyclic
	// First test is an acyclic graph, result should be false
	@Test
	public void testIsCyclic() {
		Graph graph = new Graph(3);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		System.out.println(graph.isCyclic());
		assertEquals(graph.isCyclic(), false);

	}

	// second test is a cyclic graph, result should be true
	@Test
	public void testIsCyclic2() {
		Graph graph2 = new Graph(4);
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 2);
		graph2.addEdge(1, 2);
		graph2.addEdge(2, 0);
		graph2.addEdge(2, 3);
		graph2.addEdge(3, 3);
		System.out.println(graph2.isCyclic());
		assertEquals(graph2.isCyclic(), true);

	}

	// res should be true
	@Test
	public void testIsCyclic3() {
		Graph graph2 = new Graph(5);
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 2);
		graph2.addEdge(0, 3);
		graph2.addEdge(1, 0);
		graph2.addEdge(1, 2);
		graph2.addEdge(2, 1);
		graph2.addEdge(2, 0);
		graph2.addEdge(3, 0);
		graph2.addEdge(3, 4);
		System.out.println(graph2.isCyclic());
		assertEquals(graph2.isCyclic(), true);

	}

	@Test
	public void testConstructor() {
		DAG dag;

		dag = new DAG(5);
		assertEquals("0: \n1: \n2: \n3: \n4: \n", dag.toString());

		dag = new DAG(0);
		assertEquals("", dag.toString());

		dag = new DAG(1);
		assertEquals("0: \n", dag.toString());
	}
	// Prints the following therefore working
	// 0: 1
	// 1: 2 3
	// 2:
	// 3:

	@Test
	public void testAddEdge() {
		DAG dag;

		dag = new DAG(4);
		dag.addEdge(0, 1);
		dag.addEdge(1, 2);
		dag.addEdge(1, 3);
		System.out.println(dag.toString());
	}

	@Test
	public void testAddEdge2() {
		DAG dag;

		dag = new DAG(4);
		dag.addEdge(0, 5);
		dag.addEdge(-1, 2);
		dag.addEdge(0, -6);
		dag.addEdge(20, 20);
		System.out.println(dag.toString());
	}

	@Test
	public void testAddEdge3() {
		DAG dag;

		ArrayList<Integer>[] adj;
		dag = new DAG(5);
		dag.addEdge(0, 1);
		dag.addEdge(0, 2);
		dag.addEdge(0, 3);
		dag.addEdge(1, 0);
		dag.addEdge(1, 2);
		dag.addEdge(2, 1);
		dag.addEdge(2, 0);
		dag.addEdge(3, 0);
		dag.addEdge(3, 4);
		System.out.println(dag.toString());
	}
	@Test
	public void testAddEdge4() {
		DAG dag;

		ArrayList<Integer>[] adj;
		dag = new DAG(5);
		dag.addEdge(0, 1);
		dag.addEdge(0, 1);
		dag.addEdge(0, 3);
		dag.addEdge(1, 20);
		dag.addEdge(1, 2);
		dag.addEdge(20, 1);
		dag.addEdge(2, 0);
		dag.addEdge(3, 0);
		dag.addEdge(3, 4);
		
		System.out.println(dag.toString());
	}
	@Test
	public void testLCA1() {
		DAG dag;
		ArrayList<Integer>[] parentTable = null;
		boolean[] v1Ancestors = null;
		dag = new DAG(10);
		dag.addEdge(0, 1);
		dag.addEdge(1, 2);
		dag.addEdge(1, 3);
		dag.addEdge(5, 7);
		dag.addEdge(9, 4);
		dag.addEdge(6, 7);
		dag.addEdge(3, 8);
		dag.addEdge(7, 8);
//		dag.addEdge(-5, -7);
//		dag.addEdge(-1, 70);
//		dag.addEdge(40, -7);
//		dag.addEdge(0, 0);
		System.out.println(dag.lowestCommonAncestors(-5, -7));
		System.out.println(dag.lowestCommonAncestors(-1, 70));
		System.out.println(dag.lowestCommonAncestors(40, -7));
		
		
		System.out.println(dag.lowestCommonAncestors(0, 0));
		
		System.out.println(dag.lowestCommonAncestors(0, 1));
		System.out.println(dag.lowestCommonAncestors(1, 2));
		System.out.println(dag.lowestCommonAncestors(1, 3));
		System.out.println(dag.lowestCommonAncestors(0, 2));
		System.out.println(dag.lowestCommonAncestors(0, 3));
		System.out.println(dag.lowestCommonAncestors(5, 7));
		System.out.println(dag.lowestCommonAncestors(7, 8));
		System.out.println(dag.lowestCommonAncestors(8, 4));
		System.out.println(dag.lowestCommonAncestors(9, 1));
		System.out.println(dag.lowestCommonAncestors(0, 9));
		System.out.println(dag.lowestCommonAncestors(6, 1));
		System.out.println(dag.lowestCommonAncestors(2, 8));
		System.out.println(dag.lowestCommonAncestors(8, 1));
		System.out.println(dag.lowestCommonAncestors(9, 4));
	}

}
