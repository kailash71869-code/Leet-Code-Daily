class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
         List<List<Integer>> adj=new ArrayList<>();
         int[] freq=new int[V];

         for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
         }

         for(int i=0;i<V;i++){
            for(int e:graph[i]){
                adj.get(e).add(i);
                freq[i]++;
                }   
            }
        
         Queue<Integer> q=new LinkedList<>();
         List<Integer> list=new ArrayList<>();
         for(int i=0;i<V;i++){
            if(freq[i]==0){
                q.offer(i);
            }
         }

         while(!q.isEmpty()){
            int val=q.poll();
            list.add(val);
            for(int it:adj.get(val)){
                freq[it]--;
                if(freq[it]==0){
                    q.offer(it);
                }
            }
         }
         Collections.sort(list);
         return list;
    }
}