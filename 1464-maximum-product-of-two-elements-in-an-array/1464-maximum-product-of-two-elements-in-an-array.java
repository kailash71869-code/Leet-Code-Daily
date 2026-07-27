class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int x:nums){
            pq.offer(x);
        }
        int first=pq.poll();
        int second=pq.poll();
        return (first-1)*(second-1);
    }
}