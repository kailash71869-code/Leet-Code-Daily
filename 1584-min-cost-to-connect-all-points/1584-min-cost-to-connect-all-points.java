class Solution {
    class Pair{
        int distance;
        int weight;
        public Pair(int distance,int weight){
            this.distance=distance;
            this.weight=weight;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adj=new ArrayList<>();
        int n=points.length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int valWg=Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                adj.get(i).add(new int[]{j,valWg});
                adj.get(j).add(new int[]{i,valWg});
            }
        }

        boolean[] vis=new boolean[n];

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Integer.compare(a.distance,b.distance));
        pq.offer(new Pair(0,0));
        int sum=0;

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int d=p.distance;
            int node=p.weight;

            if(vis[node]){
                continue;
            }

            vis[node]=true;
            sum+=d;

            for(int[] nie:adj.get(node)){
                int nextNode=nie[0];
                int wgt=nie[1];

                if(!vis[nextNode]){
                    pq.offer(new Pair(wgt,nextNode));
                }
            }
        }
        return sum;
    }
}