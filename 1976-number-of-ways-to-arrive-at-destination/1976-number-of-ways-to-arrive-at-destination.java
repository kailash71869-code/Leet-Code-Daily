class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e:roads){
            int u=e[0];
            int v=e[1];
            int wt=e[2];
            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }

        int mod=1_000_000_007;

        long[] dis=new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);
        long[] ways=new long[n];

        dis[0]=0;
        ways[0]=1;

        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] value=pq.poll(); 
            long dist=value[0];
            int node=(int)value[1];

            if(dist>dis[node]){
                continue;
            }

            for(int[] nie:adj.get(node)){
                int next=nie[0];
                long wgt=nie[1];

                if(wgt+dist<dis[next]){
                    dis[next]=wgt+dist;
                    pq.offer(new long[]{wgt+dist,next});
                    ways[next]=ways[node];
                }else if(wgt+dist==dis[next]){
                    ways[next]=(ways[next]+ways[node])%mod;
                }
            }
        }
        return (int)ways[n-1];
    }
}