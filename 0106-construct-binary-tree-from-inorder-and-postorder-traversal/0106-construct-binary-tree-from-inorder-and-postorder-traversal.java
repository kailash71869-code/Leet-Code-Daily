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
    Map<Integer,Integer> map=new HashMap<>();
    int postDec;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || postorder.length!=inorder.length){
            return null;
        }
        for(int i=0;i<postorder.length;i++){
            map.put(inorder[i],i);
        }
        postDec=postorder.length-1;
        return build(postorder,0,postorder.length-1);
    }
    private TreeNode build(int[] postorder,int left,int right){
        if(left>right){
            return null;
        }
        int value=postorder[postDec--];
        TreeNode root=new TreeNode(value);
        int index=map.get(value);
        root.right=build(postorder,index+1,right);
        root.left=build(postorder,left,index-1);
        return root;
    }
}