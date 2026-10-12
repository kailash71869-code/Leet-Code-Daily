class Solution {
    public int maxSum(List<Integer> nums, int k) {
        if(nums.isEmpty() || nums.size()==0){
            return 0;
        }
        int n=nums.size();
        int[] count=new int[31];
        int mod=(int)(1e9+7);
        for(int num:nums){
            for(int i=0;i<31;i++){
                if(((num>>i)&1)==1){
                    count[i]++;
                }
            }
        }
        long ans=0;

        for(int i=0;i<k;i++){
            long num=0;
            for(int j=0;j<31;j++){
                if(count[j]>0){
                    num|=(1L<<j);
                    count[j]--;
                }
            }
            ans=(ans+num*num)%mod;
        }
        return (int)ans;
    }
}