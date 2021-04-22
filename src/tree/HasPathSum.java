package tree;

public class HasPathSum {
	public boolean hasPathSum(TreeNode root, int targetSum) {
	     
		if (root==null) return false;
		return dfs(root, targetSum, 0);
	    }
	
	boolean dfs(TreeNode node, int targetSum, int sum) {
		
		if(node.left==null && node.right==null) {
			if(sum+node.val==targetSum)
				return true;
			else
				return false;
		}
		boolean left=false;
		boolean right=false;
		if(node.left!=null)
			left=dfs(node.left, targetSum, sum+ node.val);
		
		//if(left) return true;
		
		if(node.right!=null)
			right=dfs(node.right, targetSum, sum+ node.val);
		
		return (left || right);
		
	}
	
	public boolean hasPathSum2(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && targetSum == root.val) return true;
        return hasPathSum(root.left, targetSum - root.val) ||
            hasPathSum(root.right, targetSum - root.val);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
	    TreeNode l = new TreeNode(4);
	    
	    TreeNode r = new TreeNode(8);
	    TreeNode ll = new TreeNode(11);
	    //TreeNode lr = new TreeNode(5);
	    TreeNode rl = new TreeNode(13);
	    TreeNode rr = new TreeNode(4);
	    TreeNode lll = new TreeNode(7);
	    TreeNode llr = new TreeNode(2);
	    TreeNode rrr = new TreeNode(1);
	    
	    root.left=l;
	    root.right=r;
	    l.left=ll;
	    //l.right=lr;
	    r.left=rl;
	    r.right=rr;
	    ll.left=lll;
	    ll.right=llr;
	    rr.right=rrr;
	    
	    HasPathSum test= new HasPathSum();
	    System.out.println(test.hasPathSum2(root, 22));
	}

}
