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

}
