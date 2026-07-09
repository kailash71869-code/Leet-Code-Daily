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
    public boolean isBalanced(TreeNode root) {
     return dfs(root)!=-1;
    }
    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        int lt=dfs(root.left);
        if(lt==-1){
            return -1;
        }
        int rt=dfs(root.right);
        if(rt==-1){
            return -1;
        }   
        if(Math.abs(lt-rt)>1){
            return -1;
        }
        return Math.max(lt,rt)+1;
    }
}