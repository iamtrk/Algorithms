/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int isBalanced(TreeNode A) {
        if(A==null) return 1;
        
        if(A.left==null && A.right==null) return 1;
        
        return isBalanced(A.left)*isBalanced(A.right)*(Math.abs(getHeight(A.left)-getHeight(A.right))<=1?1:0);
        
        
    }
    
    public int getHeight(TreeNode a) {
        if(a==null) return 0;
        
        return 1+Math.max(getHeight(a.left), getHeight(a.right));
    }
}
