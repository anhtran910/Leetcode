package tree;

public class PrintTree3Way {
	
	public void printInOrder (TreeNode root) {
		if (root==null) return ;
		printInOrder(root.left);
			
		System.out.print(root.val);
		printInOrder(root.right);
		
	}
	
	public void printPreOrder (TreeNode root) {
		if (root==null) return ;			
		System.out.print(root.val);
		printPreOrder(root.left);
		printPreOrder(root.right);
		
	}
	
	public void printPostOrder (TreeNode root) {
		if (root==null) return ;			
		
		printPostOrder(root.left);
		printPostOrder(root.right);
		System.out.print(root.val);
		 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
	    TreeNode l = new TreeNode(2);
	    
	    TreeNode r = new TreeNode(3);
	    TreeNode ll = new TreeNode(4);
	    TreeNode lr = new TreeNode(5);
	    TreeNode rl = new TreeNode(6);
	    TreeNode rr = new TreeNode(7);
	    TreeNode rll = new TreeNode(8);
	    TreeNode rrl = new TreeNode(9);
	    TreeNode rrr = new TreeNode(10);
	    
	    root.left=l;
	    root.right=r;
	    l.left=ll;
	    l.right=lr;
	    r.left=rl;
	    r.right=rr;
	    rl.left=rll;
	    rr.left=rrl;
	    rr.right=rrr;
	    
	    PrintTree3Way test=new PrintTree3Way();
	    test.printInOrder(root);
	    System.out.println();
	    test.printPreOrder(root);
	    System.out.println();
	    test.printPostOrder(root);
	}

}
