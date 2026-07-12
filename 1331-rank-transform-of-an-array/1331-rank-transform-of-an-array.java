class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] a=arr.clone();
        Arrays.sort(a);
        int r=1;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:a){
            if(!map.containsKey(num)){
                map.put(num,r);
            r++;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
    }
}