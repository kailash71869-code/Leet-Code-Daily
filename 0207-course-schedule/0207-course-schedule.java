class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int[] freq=new int[numCourses];
        for(int[] e:prerequisites){
            int u=e[0];
            int v=e[1];

            adj.get(u).add(v);
        }
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
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            list.add(node);
            for(int it:adj.get(node)){
                freq[it]--;
                if(freq[it]==0){
                    q.offer(it);
                }
            }   
        }
        return list.size()==numCourses?true:false;
    }
}