package tree;

import java.util.List;




public class TreeSample {

	  	//TreeNode root=new TreeNode(String);

	  public static void main(String[] args) {
		TreeNode root = new TreeNode("A");
	    TreeNode b = new TreeNode("B");
	    TreeNode c = new TreeNode("C");
	    TreeNode d = new TreeNode("D");
	    root.children = List.of(b, c, d);

	    TreeNode b1 = new TreeNode("B1");
	    TreeNode b2 = new TreeNode("B2");
	    TreeNode b3 = new TreeNode("B3");
	    b.children = List.of(b1, b2, b3);

	    TreeNode b21 = new TreeNode("B2.1");
	    TreeNode b22 = new TreeNode("B2.2");
	    b2.children = List.of(b21, b22);

	    TreeNode b31 = new TreeNode("b31");
	    b22.children = List.of(b31);

	    c.children = List.of(new TreeNode("c1"), new TreeNode("c2"));

	    //given root, write all the children in the Tree of root
	      printTree(root);
	  }

	  //pls write code here:
	  public static void printTree(TreeNode root) {
		  if (root==null) return;
		  System.out.println(root.name);
		  if (root.children!=null) {
			  for (TreeNode a:root.children) {
			  printTree(a);
			 }
		  }
	  }


	

}
