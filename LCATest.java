import static org.junit.jupiter.api.Assertions.*;

import javax.swing.tree.TreeNode;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class LCATest {

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
		 	System.out.println("LCA(4, 5): " + tree.findLCA(4,5));
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
		 	System.out.println("LCA(4, 6): " + tree.findLCA(4,6));
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
		 	System.out.println("LCA(3, 6): " + tree.findLCA(3,6));
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
		 	System.out.println("LCA(3, 7): " + tree.findLCA(3,7));
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
		 	System.out.println("LCA(1, 7): " + tree.findLCA(1,7));
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
		 	System.out.println("LCA(2, 5): " + tree.findLCA(2,5));
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
		 	System.out.println("LCA(2, 4): " + tree.findLCA(2,4));
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
		 	System.out.println("LCA(1, 4): " + tree.findLCA(1,4));
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
		 	System.out.println("LCA(5, 2): " + tree.findLCA(5,2));
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
		 	System.out.println("LCA(6, 7): " + tree.findLCA(6,7));
	    }
	 
	 

}
