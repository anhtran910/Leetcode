/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
	
	    public boolean checkTree(TreeNode p, TreeNode q){
	        if (p==null && q==null) return true;
	        if (p==null || q==null) return false;
	        if (p.val!=q.val) return false;
	        return true;
	    }
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        //if (!checkTree(p,q)) return false;
	        Queue<TreeNode> queueP=new LinkedList<>();
	        Queue<TreeNode> queueQ=new LinkedList<>();
	        queueP.add(p);
	        queueQ.add(q);
	        while (!queueP.isEmpty()){
	            TreeNode curr_p=queueP.remove();
	            TreeNode curr_q=queueQ.remove();
	            if (!checkTree(curr_p,curr_q)) return false;
	            if (curr_p!=null) {
	            	queueP.add(curr_p.left);
	            	queueQ.add(curr_q.left);
	            	queueP.add(curr_p.right);
	            	queueQ.add(curr_q.right);
	            }
	            
	           
	        }
	        return true;
	    }
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	
		}

}
