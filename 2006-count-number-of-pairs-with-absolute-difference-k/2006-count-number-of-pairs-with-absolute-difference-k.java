class Solution {
    public int countKDifference(int[] nums, int k) {
        int[] freq=new int[101];
        int count=0;
        for(int x:nums){
            if(x-k>=1){
                count+=freq[x-k];
            }
            if(x+k<=100){
                count+=freq[x+k];
            }
            freq[x]++;
        }
        return count;
    }
}