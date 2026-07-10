class Solution {
    public int findCircleNum(int[][] isConnected) {
       int n=isConnected.length;
       boolean[] vis=new boolean[n];
       int provinces=0;
       for(int i=0;i<n;i++){
         if(!vis[i]){
            bfs(i,isConnected,vis);
            provinces++;
         }
       }
       return provinces;
    }
    public void bfs(int start,int[][] isConnected,boolean[] vis){
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        vis[start]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int i=0;i<isConnected.length;i++){
                if(isConnected[node][i]==1 && !vis[i]){
                    vis[i]=true;
                q.offer(i);
                }
            }
        }
    }
}