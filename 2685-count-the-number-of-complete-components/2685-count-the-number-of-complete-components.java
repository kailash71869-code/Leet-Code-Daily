class Solution {
    List<Integer>[] graph;
    boolean[] vis;
    public int countCompleteComponents(int n, int[][] edges) {
        graph=new ArrayList[n];
        vis=new boolean[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                int[] res=dfs(i);
                int node=res[0];
                int edge=res[1]/2;
                if(edge==node*(node-1)/2){
                    ans++;
                }
            }
        }
        return ans;
    }
    public int[] dfs(int node){
        vis[node]=true;
        int nodes=1;
        int edgess=graph[node].size();
        for(int neigbours:graph[node]){
            if(!vis[neigbours]){
            int[] temp=dfs(neigbours);
            nodes+=temp[0];
            edgess+=temp[1];
            }
        }
        return new int[]{nodes,edgess};
    }
}