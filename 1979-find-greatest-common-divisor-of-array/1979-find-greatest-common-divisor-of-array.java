class Solution {
    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int max=nums[0];
        int min=nums[nums.length-1];
        int t= gcd(max,min);
        return t;
    }
    public int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}