class Solution {
    public int[] resultArray(int[] nums) {
        if(nums.length<=2){
            return nums;
        }
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        l1.add(nums[0]);
        l2.add(nums[1]);
        for(int i=2;i<nums.length;i++){
           if(l1.get(l1.size()-1)<l2.get(l2.size()-1)){
            l2.add(nums[i]);
           }else if(l2.get(l2.size()-1)<l1.get(l1.size()-1)){
            l1.add(nums[i]);
           }
        }

        int[] arr=new int[nums.length];
        int idx=0;
        for(int x:l1){
            arr[idx++]=x;
        }
        for(int x:l2){
            arr[idx++]=x;
        }
        return arr;
    }
}