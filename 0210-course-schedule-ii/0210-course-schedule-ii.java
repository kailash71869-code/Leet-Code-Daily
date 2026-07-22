class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:prerequisites){
            int u=e[0];
            int v=e[1];

            adj.get(v).add(u);
        }
        int[] freq=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                freq[it]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
             if(freq[i]==0){
                q.offer(i);
             }
        }
          int idx=0;
        int[] topo=new int[numCourses];
        while(!q.isEmpty()){
            int node=q.poll();
            topo[idx++]=node;
            for(int it:adj.get(node)){
                freq[it]--;
                if(freq[it]==0){
                    q.offer(it);
                }
            }
        }
       if(idx!=numCourses){
        return new int[0];
       }
        return topo;
    }
}