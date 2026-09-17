class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        List<Integer>[] adj=new ArrayList[n+1];

        for(int i=1;i<=n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[] e:edges){
            int u=e[0];
            int v=e[1];

            boolean[] vis=new boolean[n+1];
            if(bfs(u,v,vis,adj)){
                return e;
            }

            adj[u].add(v);
            adj[v].add(u);
        }
        return new int[]{};
    }
    public boolean bfs(int u,int v,boolean[] vis,List<Integer>[] adj){
        Queue<Integer> q=new LinkedList<>();
        q.offer(u);
        vis[u]=true;

        while(!q.isEmpty()){
            int node=q.poll();
            if(node==v){
                return true;
            }
            for(int nie:adj[node]){
                if(!vis[nie]){
                    vis[nie]=true;
                    q.offer(nie);
                }
            }
        }
        return false;
    }
}