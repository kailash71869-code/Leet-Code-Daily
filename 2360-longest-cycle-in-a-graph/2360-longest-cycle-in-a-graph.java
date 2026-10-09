class Solution {
    int max=-1;
    public int longestCycle(int[] edges) {
        if(edges.length==0){
            return 0;
        }
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<edges.length;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            if(edges[i]!=-1){
            int u=i;
            int v=edges[i];

            adj.get(u).add(v);
            }
        }

        boolean[] vis=new boolean[edges.length];
        boolean[] vispath=new boolean[edges.length];
        int[] depth=new int[edges.length];

        for(int i=0;i<edges.length;i++){
           if(!vis[i]){
                dfs(i,0,vis,vispath,depth,adj);
            }
        }
        return max;
    }
    public void dfs(int node,int count,boolean[] vis,boolean[] vispath,int[] depth,List<List<Integer>> adj){
        vis[node]=true;
        vispath[node]=true;
        depth[node]=count;

        for(int nie:adj.get(node)){
            if(!vis[nie]){
                dfs(nie,count+1,vis,vispath,depth,adj);
            }else if(vispath[nie]){
                int length=count-depth[nie]+1;
                max=Math.max(max,length);
            }
        }
        vispath[node]=false;
    }
}