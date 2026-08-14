/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void parentmap(Map<TreeNode,TreeNode> map,TreeNode node,TreeNode par){
        if(node==null){
            return;
        }
        map.put(node,par);
        parentmap(map,node.left,node);
        parentmap(map,node.right,node);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Map<TreeNode,TreeNode> map=new HashMap<>();
        parentmap(map,root,null);

        Queue<TreeNode> q=new LinkedList<>();
        Set<TreeNode> vis=new HashSet<>();
        q.offer(target);
        vis.add(target);

        int dis=0;

        while(!q.isEmpty()){
            int size=q.size();

            if(dis==k){
                while(!q.isEmpty()){
                    list.add(q.poll().val);
                }
                return list;
            }

            for(int i=0;i<size;i++){
              TreeNode node=q.poll();

              if(node.left!=null && !vis.contains(node.left)){
                q.offer(node.left);
                vis.add(node.left);
              }

              if(node.right!=null && !vis.contains(node.right)){
                q.offer(node.right);
                vis.add(node.right);
              }

              TreeNode parent_node=map.get(node);

              if(parent_node!=null && !vis.contains(parent_node)){      
                q.offer(parent_node);
                vis.add(parent_node);
              }
            }
            dis++;
        }
        return list;
    }
}