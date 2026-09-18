class Solution {
    class Pair{
        int first;
        int second;
        int value;
        public Pair(int first,int second,int value){
            this.first=first;
            this.second=second;
            this.value=value;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        if(points.length==0){
            return new int[][]{};
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.value-a.value);
        for(int[] p:points){
            int f=p[0];
            int s=p[1];
            int val=(int)Math.pow(f,2)+(int)Math.pow(s,2);
            pq.offer(new Pair(f,s,val));

            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] arr=new int[k][2];

        for(int i=0;i<k;i++){
            arr[i][0]=pq.peek().first;
            arr[i][1]=pq.peek().second;
            pq.poll();
        }
        return arr;
    }
}