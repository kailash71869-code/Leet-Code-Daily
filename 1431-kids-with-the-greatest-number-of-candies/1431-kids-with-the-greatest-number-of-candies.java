class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> t=new ArrayList<>();
        int max=0;
        for(int i:candies){
           max=Math.max(max,i);
        }
        for(int k:candies){
            if(k+extraCandies>=max){
                t.add(true);
            }
            else{
                t.add(false);
            }
        }
        return t;
    }
}