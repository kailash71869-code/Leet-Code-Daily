class Solution {
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        List<Integer> temp1=new ArrayList<>();
        List<Integer> temp2=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(i!=0){
                temp1.add(nums[i]);
            }
            if(i!=nums.length-1){
                temp2.add(nums[i]);
            }
        }
        return Math.max(maximumNonAdjcent(temp1),maximumNonAdjcent(temp2));
    }
    public int maximumNonAdjcent(List<Integer> arr){
        if(arr.size()==1){
            return arr.get(0);
        }
        int prev1=0;
        int prev2=arr.get(0);

        for(int i=0;i<arr.size();i++){
            int take=arr.get(i)+((i>1)?prev2:0);
            int notTake=prev1;

            int curr=Math.max(take,notTake);

            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}