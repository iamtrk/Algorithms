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
    public int isSymmetric(TreeNode A) {
        return isSymmetric(A, A);
    }
    
    public int isSymmetric(TreeNode A, TreeNode B) {
        if(A==null && B==null) return 1;
        if((A!=null && B==null) || (A==null && B!=null)) return 0;
        if(A.val != B.val) return 0;
        
        return isSymmetric(A.left, B.right)*isSymmetric(A.right, B.left);
    }
}
