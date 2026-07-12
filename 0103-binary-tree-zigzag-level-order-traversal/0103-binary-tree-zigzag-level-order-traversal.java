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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> que=new LinkedList<>();
        int flag=0;
        que.offer(root);
        while(!que.isEmpty()){
        List<Integer> list=new ArrayList<>();
        int size=que.size();
        for(int i=0;i<size;i++){
            TreeNode node=que.poll();
            list.add(node.val);
            if(node.left!=null) que.offer(node.left);
            if(node.right!=null) que.offer(node.right);
        }
            if(flag==1){
                Collections.reverse(list);
                ans.add(list);
                flag=0;
            }else{
                ans.add(list);
                flag=1;
            }
        }
        return ans;
    }
}