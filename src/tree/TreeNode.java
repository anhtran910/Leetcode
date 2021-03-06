package tree;

import java.util.List;

public class TreeNode {
	public int val;
	
	 public TreeNode left;
	 public TreeNode right;
	 public TreeNode() {}
	 public TreeNode(int val) { this.val = val; }
	 public TreeNode(int val, TreeNode left, TreeNode right) {
	 this.val = val;
	 this.left = left;
	 this.right = right;
	 }
	 
	 String name;
	 public TreeNode(String name) { this.name = name; }
	 public TreeNode(String name, TreeNode left, TreeNode right) {
	 this.name = name;
	 this.left = left;
	 this.right = right;
	 }
	 
	 public List<TreeNode> children;
}
