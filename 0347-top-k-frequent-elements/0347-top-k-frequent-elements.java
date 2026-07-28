class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer,Integer> map=new HashMap<>();
      for(int x:nums){
        map.put(x,map.getOrDefault(x,0)+1);
      }
      PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

      for(Map.Entry<Integer,Integer> e:map.entrySet()){
        pq.offer(e);
        if(pq.size()>k){
            pq.poll();
        }
      }
      int[] arr=new int[k];
      int idx=0;
      while(!pq.isEmpty()){
        arr[idx++]=pq.poll().getKey();
      }
      return arr;
    }
}
