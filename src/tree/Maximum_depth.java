package tree;

import java.util.List;
import tree.TreeNode;

public class Maximum_depth {
	
	public int maximum_depth(TreeNode root) {
	    if (root == null) {
	        return 0;                                   // return 0 for null node
	    }
	    int left_depth = maximum_depth(root.left);
	    int right_depth = maximum_depth(root.right);
	    return Math.max(left_depth, right_depth) + 1;   // return depth of the subtree rooted at root
	}
	
	
	
	private int answer; // don't forget to initialize answer before call maximum_depth
	private void maximum_depth2(TreeNode root, int depth) {
	    if (root == null) {
	        return;
	    }
	    if (root.left == null && root.right == null) {
	        answer = Math.max(answer, depth);
	    }
	    maximum_depth2(root.left, depth + 1);
	    maximum_depth2(root.right, depth + 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			TreeNode root = new TreeNode("E");
		    TreeNode b = new TreeNode("B");
		    
		    TreeNode a = new TreeNode("A");
		    TreeNode d = new TreeNode("D");
		    TreeNode c = new TreeNode("C");
		    TreeNode f = new TreeNode("F");
		    TreeNode g = new TreeNode("G");
		    root.left=b;
		    root.right=f;
		    b.left=a;
		    b.right=d;
		    d.left=c;
		    f.left=g;
		    		
		    Maximum_depth test=new Maximum_depth();
		    test.maximum_depth2(root, 1);
		    System.out.println(test.answer);
	}

}
