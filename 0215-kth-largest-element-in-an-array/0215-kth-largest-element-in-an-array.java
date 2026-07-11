class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==1){
            return 1;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:nums){
            pq.offer(i);
        }
        int count=0;
        while(pq.size()>1){
            count++;
            if(count==k){
                return pq.poll();
            }
            pq.poll();
        }
        return pq.isEmpty()?-1:pq.poll();
    }
}