class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer,Integer> t=new  HashMap<>();
       for(int i=0;i<nums.length;i++)
       {
        int comp=target-nums[i];
        if(t.containsKey(comp))
        {
            return new int[]{t.get(comp),i};
        }
        t.put(nums[i],i);
       }
       return new int[]{-1,-1};
    }
}