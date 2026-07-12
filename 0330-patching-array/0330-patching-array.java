class Solution {
    public int minPatches(int[] nums, int n) {
       int patch=0;
       long till=0;
       for(int i=0;i<nums.length && till<n;i++)
       {
          while(till<n && till<nums[i]-1)
          {
            patch++;
            till+=(till+1);
          }
          till+=nums[i];
       }
    while(till<n)
    {
        patch++;
        till+=(till+1);
    }
    return patch;
}
}
