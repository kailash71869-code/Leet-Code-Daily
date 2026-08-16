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
    class Pair{
        TreeNode nod;
        int level;
        public Pair(TreeNode nod,int level){
            this.nod=nod;
            this.level=level;
        }
    }
    public int maxLevelSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int maxval=Integer.MIN_VALUE;
        int maxlevel=1;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,1));

        while(!q.isEmpty()){
            int size=q.size();
            int sum=0;
            int l=0;
           
            for(int i=0;i<size;i++){
                Pair curr=q.poll();
                TreeNode node=curr.nod;
                l=curr.level;
                sum+=node.val;
                if(node.left!=null){
                    q.offer(new Pair(node.left,l+1));
                }

                if(node.right!=null){
                    q.offer(new Pair(node.right,l+1));
                }
                 
               
            }
             if(maxval<sum){
                    maxval=sum;
                    maxlevel=l;
                }
        }
        return maxlevel;
    }
}