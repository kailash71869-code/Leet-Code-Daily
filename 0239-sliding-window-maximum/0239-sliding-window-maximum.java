class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq=new ArrayDeque<>();
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){    
                dq.pollLast();
            }
            dq.offerLast(i);

            if(i>=k-1){
                list.add(nums[dq.peekFirst()]);
            }
        }
        int[] arr=new int[list.size()];
        int t=0;
        for(int i:list){
            arr[t++]=i;
        }
        return arr;
    }
}