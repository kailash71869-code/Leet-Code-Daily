class Solution {
    public int countHillValley(int[] nums) {
        int count=0;
        int left=nums[0];
         for(int i=1;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                continue;
            }
            int right=nums[i+1];
            if((left<nums[i] && nums[i]>right) || (nums[i]<left && nums[i]<right)){
                count++;
            }
            left=nums[i];
        }
        return count;
    }
}