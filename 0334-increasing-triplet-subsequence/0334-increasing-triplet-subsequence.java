class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int i=Integer.MAX_VALUE;
        int j=Integer.MAX_VALUE;
        for(int index=0;index<nums.length;index++){
            if(nums[index]<=i){
                i=nums[index];
            }
            else if(nums[index]<=j){
                j=nums[index];
            }else{
                return true;
            }
        }
        return false;
    }
}