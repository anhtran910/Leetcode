package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Symmetric {

	public boolean isSymmetric(TreeNode root) {
       return isMirror(root, root);
    }
	
	
	public boolean isMirror(TreeNode t1,TreeNode t2) {
        if (t1==null && t2==null) return true;
        if (t1==null || t2==null) return false;
        return (t1.val==t2.val) && isMirror(t1.right,t2.left) && isMirror(t1.left,t2.right);
    }
	
	public boolean isSymmetric2(TreeNode root) {
	        Queue<TreeNode> q=new LinkedList<>();
	        q.add(root);
	        q.add(root);
	        while (!q.isEmpty()) {
	        	TreeNode t1=q.poll();
	        	TreeNode t2=q.poll();
	        	if (t1==null && t2==null) continue;
	        	if (t1==null || t2 ==null) return false;
	        	if (t1.val!=t2.val) return false;
	        	q.add(t1.right);
	        	q.add(t2.left);
	        	q.add(t1.left);
	        	q.add(t2.right);
	        }	
		return true;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
	    TreeNode l = new TreeNode(2);
	    
	    TreeNode r = new TreeNode(2);
	    TreeNode ll = new TreeNode(3);
	    TreeNode lr = new TreeNode(4);
	    TreeNode rl = new TreeNode(4);
	    TreeNode rr = new TreeNode(3);
	    root.left=l;
	    root.right=r;
	    l.left=ll;
	    l.right=lr;
	    r.left=rl;
	    r.right=rr;
	    
	    Symmetric test=new Symmetric();
	    System.out.println(test.isSymmetric2(root));
	}

}
