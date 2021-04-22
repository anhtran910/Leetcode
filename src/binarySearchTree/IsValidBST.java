package binarySearchTree;

import tree.TreeNode;

public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
		return validate(root,null,null);
		
    }
	
	public boolean validate(TreeNode root,Integer low, Integer high) {
		if (root==null) return true;
		if ((low!=null && root.val<=low) || (high!=null && root.val>=high)) return false;
		return validate(root.left,low,root.val) && validate(root.right,root.val,high);
	}
	
	Integer preVal;
	
	public boolean isValidBST2(TreeNode root) {
		preVal=null;
		return inOrder(root);
		
    }
	
	public boolean inOrder(TreeNode root) {
		if (root==null) return true ;
		if (!inOrder(root.left)) return false;
		if (preVal!=null && root.val<=preVal) return false;
		preVal=root.val;
		return inOrder(root.right);
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
	    TreeNode l = new TreeNode(2);
	    
	    TreeNode r = new TreeNode(4);
	    TreeNode ll = new TreeNode(1);
	    //TreeNode lr = new TreeNode(5);
	    TreeNode rl = new TreeNode(3);
	    TreeNode rr = new TreeNode(6);
	    //TreeNode lll = new TreeNode(7);
	   // TreeNode llr = new TreeNode(2);
	    //TreeNode rrr = new TreeNode(1);
	    
	    root.left=l;
	    root.right=r;
	    l.left=ll;
	    //l.right=lr;
	    r.left=rl;
	    r.right=rr;
//	    ll.left=lll;
//	    ll.right=llr;
//	    rr.right=rrr;
	
	    IsValidBST test=new IsValidBST();
	    System.out.println(test.isValidBST2(root));
	
	}

}
