class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int idx=matrix.length*matrix[0].length-1;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++){
                pq.add(matrix[row][col]);
            }
        }
        while(--k>0){
            pq.poll();
        }
        return pq.isEmpty()?0:pq.poll();
    }
}