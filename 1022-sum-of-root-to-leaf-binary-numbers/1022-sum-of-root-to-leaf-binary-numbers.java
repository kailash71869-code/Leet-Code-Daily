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
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root,0);
        return sum;
    }
    public void dfs(TreeNode root,int value){
        if(root==null){
            return;
        }
        value=value*2+root.val;
        if(root.left==null && root.right==null){
            sum+=value;
            return;
        }
        dfs(root.left,value);
        dfs(root.right,value);
    }
}