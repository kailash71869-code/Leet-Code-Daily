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
    class Good{
        TreeNode node;
        int max;
        public Good(TreeNode node,int max){
            this.node=node;
            this.max=max;
        }
    }
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int count=0;

        Queue<Good> q=new LinkedList<>();
        q.offer(new Good(root,root.val));

        while(!q.isEmpty()){
            Good values=q.poll();
            TreeNode nod=values.node;
            int x=values.max;

            if(nod.val>=x){
                count++;
            }

            int newmax=Math.max(nod.val,x);
            if(nod.left!=null){
                q.offer(new Good(nod.left,newmax));
            }
            if(nod.right!=null){
                q.offer(new Good(nod.right,newmax));
            }

        }
        return count;
    }
}