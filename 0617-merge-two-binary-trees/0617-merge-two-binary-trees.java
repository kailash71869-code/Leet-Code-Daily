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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        Queue<TreeNode[]> q=new LinkedList<>();
        q.offer(new TreeNode[]{root1,root2});

        while(!q.isEmpty()){
                TreeNode[] node=q.poll();
                TreeNode first_root=node[0];
                TreeNode second_root=node[1];

                first_root.val=first_root.val+second_root.val;

                if(first_root.left==null){
                    first_root.left=second_root.left;
                }else if(second_root.left!=null){
                    q.offer(new TreeNode[]{first_root.left,second_root.left});
                }

                if(first_root.right==null){
                    first_root.right=second_root.right;
                }else if(second_root.right!=null){
                    q.offer(new TreeNode[]{first_root.right,second_root.right});
                }
        }
        return root1;
    }
}