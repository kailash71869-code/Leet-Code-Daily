class Solution {
    public int findPairs(int[] nums, int k) {
        if(k<0){
            return 0;
        }
        if(k==0){
            int count=0;
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int x:nums){
                map.put(x,map.getOrDefault(x,0)+1);
            }
            for(int x:map.keySet()){
                if(map.get(x)>=2){
                    count++;
                }
            }
            return count;
        }
        Set<Integer> set=new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        int count=0;
        for(int x:set){
            if(set.contains(x+k)){
                count++;
            }
        }
        return count;
    }
}