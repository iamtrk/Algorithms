/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public TreeNode flatten(TreeNode a) {
	    TreeNode root = a;
	    Stack<TreeNode> stack = new Stack<>();
	    
	    while(a!=null || !stack.isEmpty()) {
	        if(a.right!=null) {
	            stack.add(a.right);
	        }
	        
	        if(a.left!=null) {
	            a.right = a.left;
	            a.left = null;
	        } else if(!stack.isEmpty()) {
	            TreeNode t = stack.pop();
	            a.right = t;
	        }
	        
	        a = a.right;
	    }
	    
	    return root;
	}
}
