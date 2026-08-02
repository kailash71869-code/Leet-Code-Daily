class Solution {
    Integer dp[][];
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        dp=new Integer[n][n];
        return solve(nums,0,n-1)>=0;
    }
    public int solve(int[] nums,int start,int end){
        if(start==end){
            return nums[start];
        }
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        int left=nums[start]-solve(nums,start+1,end);
        int right=nums[end]-solve(nums,start,end-1);
        return dp[start][end]=Math.max(left,right);
    }
}