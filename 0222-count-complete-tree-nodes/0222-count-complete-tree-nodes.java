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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int lt=findLeft(root);
        int rt=findRight(root);
        if(lt==rt){
            return ((1<<lt)-1);
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int findLeft(TreeNode root){
        int height=0;
        while(root!=null){
            height++;
            root=root.left;
        }
        return height;
    }
    public int findRight(TreeNode root){
        int height=0;
        while(root!=null){
            height++;
            root=root.right;
        }
        return height;
    }
}