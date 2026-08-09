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
    int ans=0;
    int maxdepth=-1;
    public int findBottomLeftValue(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root,0);
        return ans;
    }
    public void dfs(TreeNode root,int depth){
        if(root==null){
            return;
        }
        if(maxdepth<depth){
            maxdepth=depth;
            ans=root.val;
        }
        dfs(root.left,depth+1);
        dfs(root.right,depth+1);
    }
}