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
    public int minimumOperations(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans=0;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            int[] arr=new int[size];
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                arr[i]=node.val;
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            ans+=minarr(arr);
        }
        return ans;
    }
    public int minarr(int[] arr){
        int n=arr.length;
        int[][] mat=new int[n][2];
        for(int i=0;i<n;i++){
            mat[i][0]=arr[i];
            mat[i][1]=i;
        }
        int swap=0;

        Arrays.sort(mat,(a,b)->Integer.compare(a[0],b[0]));

        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            int j=i;
            int count=0;
            if(vis[i] || mat[i][1]==1){
                continue;
            }
            while(!vis[j]){
                vis[j]=true;
                j=mat[j][1];
                count++;
            }
            swap+=(count-1);
        }
        return swap;
    }
}