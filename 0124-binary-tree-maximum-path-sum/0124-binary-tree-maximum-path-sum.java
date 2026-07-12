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
class Solution {
     int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftsum=Math.max(0,dfs(root.left));
        int rightsum=Math.max(0,dfs(root.right));
        max=Math.max(max,(leftsum+rightsum+root.val));
        return Math.max(leftsum,rightsum)+root.val;
    }
}