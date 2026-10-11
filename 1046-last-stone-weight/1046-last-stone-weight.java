class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length==0){
            return 0;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int x:stones){
            pq.offer(x);
        }

        while(!pq.isEmpty()){
            if(pq.size()==1){
                return pq.poll();
            }
            int a=pq.poll();
            int b=pq.poll();
            if(a!=b){
                pq.offer(a-b);
            }

        }
        return 0;
    }
}