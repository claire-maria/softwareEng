import static org.junit.jupiter.api.Assertions.*;

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
			System.out.println(graph.adj.get(i));
			// V0 adj v2
			// V1 adj V2 and V3
			// V2 adj V4
			// V3 adj V4
			// V4 is not adj to any V this is correct
		}
	}
	//Test root == null
	@Test
	public void rootTest() {
		LCA tree = new LCA();
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
			System.out.println(graph.adj.get(i));
			// V0 adj v2 and V1
			// V1 adj V2 and V3
			// V2 adj V4
			// V3 adj V5
			// V4 is adj to v3 and V5
			// v5 is not adj to any V
			// correct
		}
	}
	//test if graphs are acyclic
	//First test is an acyclic graph, result should be false
	@Test 
	public void testIsCyclic(){
		Graph graph = new Graph(5);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		System.out.println(graph.isCyclic());
		assertEquals(graph.isCyclic(), false);
		
	}
}
