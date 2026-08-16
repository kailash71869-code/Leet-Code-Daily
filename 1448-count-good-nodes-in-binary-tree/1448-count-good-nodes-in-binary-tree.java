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
    int count=0;
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int value=root.val;
        dfs(root,value);
        return count;   
    }
    public void dfs(TreeNode root,int value){
        if(root==null){
            return;
        }
        if(root.val>=value){
            count++;
            value=root.val;
        }
        dfs(root.left,value);
        dfs(root.right,value);
    }
}