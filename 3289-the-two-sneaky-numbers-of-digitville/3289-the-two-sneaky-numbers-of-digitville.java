class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer,Integer> t=new HashMap<>();
        for(int num:nums)
        {
            t.put(num,t.getOrDefault(num,0)+1);
        }
        int[] arr=new int[2];
        int i=0;
        for(int num:t.keySet())
        {
            if(t.get(num)==2)
            {
                arr[i++]=num;
            }
        }
        Arrays.sort(arr);
        return arr;
    }
}