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
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
             int first = 0;
        int last = 0;
        int curridx=0;
            int minidx = q.peek().getValue();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> p = q.poll();
                TreeNode node = p.getKey();
                int value = p.getValue();
                 curridx = value - minidx;
                if (i == 0) {
                    first = curridx;
                }
                if (i == size-1) {
                    last = curridx;
                }
                if (node.left != null) {
                    q.offer(new Pair<>(node.left, 2 * curridx + 1));
                }
                if (node.right != null) {
                    q.offer(new Pair<>(node.right, 2 * curridx + 2));
                }
            }
            max = Math.max(max, last - first + 1);
        }
        return max;
    }
}